package com.deafolio.Service;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileServices {

    String uploadImage(MultipartFile file) throws IOException;
    @Async
    void deleteFiles(String imageUrl);
}
