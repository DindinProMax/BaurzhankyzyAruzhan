package com.example.baurzhankyzy_aruzhan.AruzhanService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Slf4j
@Service
public class BaurzhankyzyAruzhanFileService {

    private final Path root = Paths.get("uploads");

    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            log.error("Baurzhankyzy Aruzhan: Could not initialize folder for uploads");
        }
    }

    public String save(MultipartFile file) {
        try {
            if (!Files.exists(root)) init();
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Files.copy(file.getInputStream(), this.root.resolve(filename));
            log.info("Baurzhankyzy Aruzhan: File uploaded successfully: {}", filename);
            return filename;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Path load(String filename) {
        return root.resolve(filename);
    }
}