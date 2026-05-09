package com.example.baurzhankyzy_aruzhan.AruzhanController;

import com.example.baurzhankyzy_aruzhan.AruzhanService.BaurzhankyzyAruzhanFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RestController
@RequestMapping("/api/aruzhan/files")
@RequiredArgsConstructor
public class BaurzhankyzyAruzhanFileController {

    private final BaurzhankyzyAruzhanFileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = fileService.save(file);
        return ResponseEntity.ok("File uploaded by Baurzhankyzy Aruzhan: " + message);
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        try {
            Path file = fileService.load(filename);
            Resource resource = new UrlResource(file.toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}