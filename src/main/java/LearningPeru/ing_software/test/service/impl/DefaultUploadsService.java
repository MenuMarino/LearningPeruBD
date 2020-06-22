package LearningPeru.ing_software.test.service.impl;

import LearningPeru.ing_software.test.service.UploadsService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class DefaultUploadsService implements UploadsService {

    @Override
    public Boolean save(String path, MultipartFile file) throws IOException {
        System.out.println(path+file.getOriginalFilename());
        File convertFile = new File(path+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return true;
    }

    @Override
    public ResponseEntity<Object> download(String type, String path) throws FileNotFoundException {
        File file = new File(path);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(
                file.length()).contentType(MediaType.parseMediaType(type)).body(resource);

        return responseEntity;
    }


}
