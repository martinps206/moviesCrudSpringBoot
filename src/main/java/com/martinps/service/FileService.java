package com.martinps.service;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService implements IFileService{
    @Override
    public void save(String file, InputStream bytes) {
        try {
            delete(file);
            Files.copy(bytes, resolvePath(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path resolvePath(String file) {
        return Paths.get("files").resolve(file).toAbsolutePath();
    }

    @Override
    public ResponseEntity<Resource> get(String file) {
        Resource resource = null;
        try {
            resource = new UrlResource(resolvePath(file).toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename\"" + resource.getFilename() + "\"").body(resource);
    }

    @Override
    public void delete(String file) {
        try {
            Files.deleteIfExists(resolvePath(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
