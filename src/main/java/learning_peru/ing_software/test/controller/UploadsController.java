package learning_peru.ing_software.test.controller;

import learning_peru.ing_software.test.service.UploadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/uploads")
public class UploadsController {
    private String src="/home/lusho/Documents/Eduardo/5tociclo/SOFTWARE/proyecto_final/LearningPeruBD/src/main/java/learning_peru/ing_software/test/userFiles/";

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
}
