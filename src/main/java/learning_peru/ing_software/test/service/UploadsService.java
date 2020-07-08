package learning_peru.ing_software.test.service;

import org.springframework.http.HttpEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface UploadsService {

    Boolean save(String path, MultipartFile file) throws IOException;


    HttpEntity<Object> download(String type, String path) throws FileNotFoundException;
}
