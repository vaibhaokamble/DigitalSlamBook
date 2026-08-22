package com.vaibhao.vk.digitalslambook.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequest {

    @NotBlank(message = "Friend name is required")
    private String friendName;

    @NotBlank(message = "Relationship is required")
    private String relationship;

    @Min(value = 1, message = "Friendship rating must be at least 1")
    @Max(value = 10, message = "Friendship rating must not exceed 10")
    private int friendshipRating;

    private Boolean bestFriend;

    @Past(message = "Friendship date must be in the past")
    private LocalDate friendshipDate;

    @Size(max = 5000, message = "Message must not exceed 5000 characters")
    private String message;

    @Size(max = 100, message = "Song name must not exceed 100 characters")
    private String songName;

    @Size(max = 100, message = "Song artist must not exceed 100 characters")
    private String songArtist;

    private String songUrl;

    @Size(max = 5000, message = "Song dedication must not exceed 5000 characters")
    private String songDedication;

    private String memoryPhotoUrl;

    @Size(max = 5000, message = "Memory text must not exceed 5000 characters")
    private String memoryText;
}