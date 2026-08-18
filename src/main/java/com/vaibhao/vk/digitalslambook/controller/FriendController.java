package com.vaibhao.vk.digitalslambook.controller;

import com.vaibhao.vk.digitalslambook.dto.request.FriendRequest;
import com.vaibhao.vk.digitalslambook.dto.response.ApiResponse;
import com.vaibhao.vk.digitalslambook.dto.response.FriendResponse;
import com.vaibhao.vk.digitalslambook.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {

    private final FriendService friendService;

    @PostMapping("/slambook/{slamBookId}")
    public ResponseEntity<ApiResponse<FriendResponse>> addFriend(@PathVariable UUID slamBookId, @RequestBody FriendRequest friendRequest) {

        FriendResponse friendResponse = friendService.addFriend(slamBookId, friendRequest);

        ApiResponse<FriendResponse> apiResponse = ApiResponse.<FriendResponse>builder()
                        .status(HttpStatus.CREATED.value())
                        .message("Friend added successfully")
                        .data(friendResponse)
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/slambook/{slamBookId}")
    public ResponseEntity<ApiResponse<List<FriendResponse>>> getFriendsBySlamBook(
            @PathVariable UUID slamBookId) {

        List<FriendResponse> friendResponses = friendService.getFriendsBySlamBook(slamBookId);

        ApiResponse<List<FriendResponse>> apiResponse =
                ApiResponse.<List<FriendResponse>>builder()
                        .status(HttpStatus.OK.value())
                        .message("Friends retrieved successfully")
                        .data(friendResponses)
                        .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{friendId}")
    public ResponseEntity<ApiResponse<FriendResponse>> getFriendById(@PathVariable UUID friendId) {

        FriendResponse friendResponse =
                friendService.getFriendById(friendId);

        ApiResponse<FriendResponse> apiResponse =
                ApiResponse.<FriendResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Friend retrieved successfully")
                        .data(friendResponse)
                        .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{friendId}")
    public ResponseEntity<ApiResponse<FriendResponse>> updateFriend(@PathVariable UUID friendId, @RequestBody FriendRequest friendRequest) {

        FriendResponse friendResponse = friendService.updateFriend(friendId, friendRequest);

        ApiResponse<FriendResponse> apiResponse = ApiResponse.<FriendResponse>builder()
                        .status(HttpStatus.OK.value())
                        .message("Friend updated successfully")
                        .data(friendResponse)
                        .build();

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{friendId}")
    public ResponseEntity<ApiResponse<Void>> deleteFriend(@PathVariable UUID friendId) {

        friendService.deleteFriend(friendId);

        ApiResponse<Void> apiResponse = ApiResponse.<Void>builder()
                        .status(HttpStatus.NO_CONTENT.value())
                        .message("Friend deleted successfully")
                        .data(null)
                        .build();

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(apiResponse);
    }
}