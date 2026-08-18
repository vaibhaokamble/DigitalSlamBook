package com.vaibhao.vk.digitalslambook.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class FriendResponse {

    private UUID id;

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
