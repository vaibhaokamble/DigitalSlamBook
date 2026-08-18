package com.vaibhao.vk.digitalslambook.dto.request;

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

    private String friendName;

    private String relationship;

    private int friendshipRating;

    private Boolean bestFriend;

    private LocalDate friendshipDate;

    private String message;

    private String songName;

    private String songArtist;

    private String songUrl;

    private String songDedication;

    private String memoryPhotoUrl;

    private String memoryText;
}