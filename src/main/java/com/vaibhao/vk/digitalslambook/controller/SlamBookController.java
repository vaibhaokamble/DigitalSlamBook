package com.vaibhao.vk.digitalslambook.controller;

import com.vaibhao.vk.digitalslambook.dto.request.SlamBookRequest;
import com.vaibhao.vk.digitalslambook.dto.response.ApiResponse;
import com.vaibhao.vk.digitalslambook.dto.response.SlamBookResponse;
import com.vaibhao.vk.digitalslambook.service.SlamBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/slambook")
public class SlamBookController {

    private final SlamBookService slamBookService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<SlamBookResponse>> createSlamBook(@RequestBody SlamBookRequest slamBookRequest) {
        SlamBookResponse slamBookResponse = slamBookService.createSlamBook(slamBookRequest);

        ApiResponse<SlamBookResponse> apiResponse = ApiResponse.<SlamBookResponse>builder()
                .status(HttpStatus.CREATED.value())
                .message("SlamBook created successfully")
                .data(slamBookResponse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse<List<SlamBookResponse>>> getAllSlamBook() {

        List<SlamBookResponse> slamBookResponses = slamBookService.getAllSlamBooks();

        ApiResponse<List<SlamBookResponse>> apiResponse = ApiResponse.<List<SlamBookResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("SlamBooks retrieved successfully")
                .data(slamBookResponses)
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<SlamBookResponse>> getSlamBookById(@PathVariable UUID id) {
        if (id == null) {
            ApiResponse<SlamBookResponse> apiResponse = ApiResponse.<SlamBookResponse>builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("Invalid ID provided")
                    .data(null)
                    .build();
            return ResponseEntity.badRequest().body(apiResponse);

        }
        SlamBookResponse slamBookResponse = slamBookService.getSlamBookById(id);
        ApiResponse<SlamBookResponse> apiResponse = ApiResponse.<SlamBookResponse>builder()
                .status(HttpStatus.OK.value())
                .message("SlamBook retrieved successfully")
                .data(slamBookResponse)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<SlamBookResponse>> updateSlamBook(@PathVariable UUID id, @RequestBody SlamBookRequest slamBookRequest) {
        if (id == null) {
            ApiResponse<SlamBookResponse> apiResponse = ApiResponse.<SlamBookResponse>builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("Invalid ID provided")
                    .data(null)
                    .build();
            return ResponseEntity.badRequest().body(apiResponse);
        }
        SlamBookResponse slamBookResponse = slamBookService.updateSlamBook(id, slamBookRequest);
        ApiResponse<SlamBookResponse> apiResponse = ApiResponse.<SlamBookResponse>builder()
                .status(HttpStatus.OK.value())
                .message("SlamBook updated successfully")
                .data(slamBookResponse)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSlamBook(@PathVariable UUID id) {
        if (id == null) {
            ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message("Invalid ID provided")
                    .data(null)
                    .build();
            return ResponseEntity.badRequest().body(apiResponse);
        }
        slamBookService.deleteSlamBook(id);
        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                .status(HttpStatus.OK.value())
                .message("SlamBook deleted successfully")
                .data(null)
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}