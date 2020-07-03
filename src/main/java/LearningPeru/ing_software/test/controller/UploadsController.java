package LearningPeru.ing_software.test.controller;

import LearningPeru.ing_software.test.service.UploadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/uploads")
public class UploadsController {
    private String path="/home/cesar21456/Desktop/git/LearningPeruBD/src/main/java/LearningPeru/ing_software/test/userFiles/";

    @Autowired
    UploadsService uploadsService;

    @PostMapping(value="/uploads/{path}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    HttpEntity<Boolean> upload(@RequestParam("file") MultipartFile file, @PathVariable("path") String path) throws IOException {
        uploadsService.save(path,file);
        //return uploadsService.download("application/png",path+file.getOriginalFilename());
        HttpHeaders headers= new HttpHeaders();
        headers.add("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        headers.add("Access-Control-Allow-Headers", "X-Requested-With, X-Auth-Token");
        headers.add("Access-Control-Allow-Credentials", "true");
        return new ResponseEntity<>(true,headers, HttpStatus.OK);

    }

    @GetMapping(value="/download/{path}")
    @ResponseBody
    HttpEntity<Object> download(@PathVariable("type") Integer type,@PathVariable("path") String path) throws FileNotFoundException {
        String format="";
        if (path.endsWith(".mp4")){
            format = "video/mp4";
        }else{
            if (path.endsWith(".pdf")){
                format = "application/pdf";
            }
        }
        return uploadsService.download(format, path);
    }


}
