package com.vaibhao.vk.digitalslambook.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    private final RestClient restClient;

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.service-key}")
    private String supabaseServiceKey;

    @Value("${supabase.bucket}")
    private String bucket;

    public FileService() {
        this.restClient = RestClient.create();
    }

    public String uploadFile(MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File cannot be empty");
        }

        String originalFileName = file.getOriginalFilename();

        String extension = "";

        if (originalFileName != null && originalFileName.contains(".")) {
            extension = originalFileName.substring(
                    originalFileName.lastIndexOf(".")
            );
        }

        String fileName = UUID.randomUUID() + extension;

        String storagePath = "images/" + fileName;

        String uploadUrl = supabaseUrl
                + "/storage/v1/object/"
                + bucket
                + "/"
                + storagePath;

        restClient.post()
                .uri(uploadUrl)
                .header(
                        HttpHeaders.AUTHORIZATION,
                        "Bearer " + supabaseServiceKey
                )
                .header(
                        "apikey",
                        supabaseServiceKey
                )
                .header(
                        HttpHeaders.CONTENT_TYPE,
                        file.getContentType() != null
                                ? file.getContentType()
                                : MediaType.APPLICATION_OCTET_STREAM_VALUE
                )
                .body(file.getBytes())
                .retrieve()
                .toBodilessEntity();

        return storagePath;
    }
}