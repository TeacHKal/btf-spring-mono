package com.teachkal.btf.spring.mono.service.impl;

import com.teachkal.btf.spring.mono.model.entity.File;
import com.teachkal.btf.spring.mono.repository.FileRepository;
import com.teachkal.btf.spring.mono.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    final FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public File addFile(File file) {
        return fileRepository.save(file);
    }
}
