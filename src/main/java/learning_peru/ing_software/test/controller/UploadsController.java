package learning_peru.ing_software.test.controller;

import learning_peru.ing_software.test.beans.ZipFilesBean;
import learning_peru.ing_software.test.service.UploadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;



@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/uploads")
public class UploadsController {
    private String src="/home/lusho/Documents/Eduardo/5tociclo/SOFTWARE/proyecto_final/LearningPeruBD/src/main/java/learning_peru/ing_software/test/userFiles/";
    private String simplesrc="/home/lusho/Documents/Eduardo/5tociclo/SOFTWARE/proyecto_final/LearningPeruBD/";
    @Autowired
    UploadsService uploadsService;

    @PostMapping(value="/uploads/{id}/{dir}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public HttpEntity<Boolean> upload(@RequestParam("file") MultipartFile file,@PathVariable("id") String id, @PathVariable("dir") String dir) throws IOException {
        String path=src + id+"/"+dir+"/";
        uploadsService.save(path,file);
        HttpHeaders headers= new HttpHeaders();
        headers.add("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        headers.add("Access-Control-Allow-Headers", "X-Requested-With, X-Auth-Token");
        headers.add("Access-Control-Allow-Credentials", "true");
        return new ResponseEntity<>(true,headers, HttpStatus.OK);
    }

    @GetMapping(value="/download/{id}/{dir}/{file}")
    @ResponseBody
    public HttpEntity<Object> download(@PathVariable("id") String id,@PathVariable("dir") String dir,@PathVariable("file") String file) throws FileNotFoundException {
        String format="";
        String path=id+"/"+dir+"/"+file;
        if (path.endsWith(".mp4")){
            format = "video/mp4";
        }else{
            if (path.endsWith(".pdf")){
                format = "application/pdf";
            }
        }
        return uploadsService.download(format, src+path);
    }


    @PostMapping(value="/download/{id}", produces="application/zip")
    @ResponseBody
    public ResponseEntity<Object> download(@PathVariable("id") String id, @RequestBody ZipFilesBean zipFilesBean) throws IOException {
        FileOutputStream fos = new FileOutputStream("material.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (String srcFile : zipFilesBean.getList_of_files()) {
            System.out.println(src+id+"/materiales/"+ srcFile);
            File fileToZip = new File(src+id+"/materiales/"+ srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry (zipEntry);
            byte[] bytes = new byte[15728640];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
        File file = new File(simplesrc+"material.zip");
        InputStreamResource resource= new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/zip");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        return ResponseEntity.ok().headers(headers).contentLength(file.length()
                ).body(resource);
    }

}

