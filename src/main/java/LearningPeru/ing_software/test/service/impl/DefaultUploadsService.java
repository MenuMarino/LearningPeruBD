package LearningPeru.ing_software.test.service.impl;

import LearningPeru.ing_software.test.service.UploadsService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.io.*;

@Service
public class DefaultUploadsService implements UploadsService {

    @Override
    public Boolean save(String path, MultipartFile file) throws IOException {
        System.out.println("\n\n\nJJJJJJJJJJ\n\n\n");
        System.out.println(path+file.getOriginalFilename());
        File convertFile = new File(path+file.getOriginalFilename());
        System.out.println("\n\n\nJJJJJJJJJJ\n\n\n");
        convertFile.createNewFile();
        System.out.println("\n\n\nJJJJJJJJJJ\n\n\n");
        FileOutputStream fout = new FileOutputStream(convertFile);
        System.out.println("\n\n\nJJJJJJJJJJ\n\n\n");
        fout.write(file.getBytes());
        System.out.println("\n\n\nJJJJJJJJJJ\n\n\n");
        fout.close();
        System.out.println("\n\n\nJJJJJJJJJJ\n\n\n");
        return true;
    }

    @Override
    public ResponseEntity<Object> download(String type, String path) throws FileNotFoundException {
        File file = new File(path);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        if (type.equals("application/pdf")){
            headers.setContentType(MediaType.APPLICATION_PDF);
        }
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(
                file.length()).body(resource);

        return responseEntity;
    }


}
