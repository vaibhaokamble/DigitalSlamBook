package com.vaibhao.vk.digitalslambook.controller;

import com.vaibhao.vk.digitalslambook.dto.request.SlamBookRequest;
import com.vaibhao.vk.digitalslambook.dto.response.ApiResponse;
import com.vaibhao.vk.digitalslambook.dto.response.SlamBookResponse;
import com.vaibhao.vk.digitalslambook.service.SlamBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/slambook")
public class SlamBookController {

    private final SlamBookService slamBookService;

    @PostMapping
    public ResponseEntity<ApiResponse<SlamBookResponse>> createSlamBook(@RequestBody SlamBookRequest slamBookRequest) {

        SlamBookResponse slamBookResponse = slamBookService.createSlamBook(slamBookRequest);

        ApiResponse<SlamBookResponse> apiResponse = ApiResponse.<SlamBookResponse>builder()
                        .status(HttpStatus.CREATED.value())
                        .message("SlamBook created successfully")
                        .data(slamBookResponse)
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/{slamBookId}")
    public ResponseEntity<ApiResponse<SlamBookResponse>> getSlamBookById(@PathVariable UUID slamBookId) {

        SlamBookResponse slamBookResponse = slamBookService.getSlamBookById(slamBookId);

        ApiResponse<SlamBookResponse> apiResponse = ApiResponse.<SlamBookResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("SlamBook retrieved successfully")
                        .data(slamBookResponse)
                        .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{slamBookId}")
    public ResponseEntity<ApiResponse<SlamBookResponse>> updateSlamBook(@PathVariable UUID slamBookId, @RequestBody SlamBookRequest slamBookRequest) {

        SlamBookResponse slamBookResponse = slamBookService.updateSlamBook(slamBookId, slamBookRequest);

        ApiResponse<SlamBookResponse> apiResponse = ApiResponse.<SlamBookResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("SlamBook updated successfully")
                        .data(slamBookResponse)
                        .build();

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{slamBookId}")
    public ResponseEntity<ApiResponse<Void>> deleteSlamBook(@PathVariable UUID slamBookId) {

        slamBookService.deleteSlamBook(slamBookId);

        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                        .status(HttpStatus.OK.value())
                        .message("SlamBook deleted successfully")
                        .data(null)
                        .build();

        return ResponseEntity.ok(apiResponse);
    }
}