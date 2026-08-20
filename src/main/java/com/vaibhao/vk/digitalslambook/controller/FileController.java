package com.vaibhao.vk.digitalslambook.controller;

import com.vaibhao.vk.digitalslambook.dto.response.ApiResponse;
import com.vaibhao.vk.digitalslambook.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponse<String>> uploadFile(
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        String storagePath = fileService.uploadFile(file);

        ApiResponse<String> response = ApiResponse.<String>builder()
                .status(HttpStatus.OK.value())
                .message("File uploaded successfully")
                .data(storagePath)
                .build();

        return ResponseEntity.ok(response);
    }
}