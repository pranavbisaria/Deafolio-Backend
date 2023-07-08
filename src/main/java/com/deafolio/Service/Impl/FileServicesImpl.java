package com.deafolio.Service.Impl;
import com.deafolio.Service.FileServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class FileServicesImpl implements FileServices {
    @Value("${project.image}")
    private String path;
    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        String  filename = file.getOriginalFilename();
        String randomID = UUID.randomUUID().toString();
        assert filename != null;
        String newFileName =  randomID.concat(filename.substring(filename.lastIndexOf(".")));
        String filepath = path + File.separator + newFileName;
        File newFile = new File(path);
        if(!newFile.exists()){
            newFile.mkdirs();
        }
        Files.copy(file.getInputStream(), Paths.get(filepath));
        return newFileName;
    }
    @Async
    @Override
    public void deleteFiles(String imageUrl) {
        Path filePath = Paths.get(path, imageUrl);
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
