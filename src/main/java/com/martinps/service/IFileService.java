package com.martinps.service;



import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.InputStream;

public interface IFileService {

    public void save(String file, InputStream bytes);
    public ResponseEntity<Resource> get(String file);
    public void delete(String file);
}
