package com.vaibhao.vk.digitalslambook.dto.response;

import com.vaibhao.vk.digitalslambook.enums.Gender;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SlamBookResponse {
    private UUID id;
    private String fullName;
    private String nickName;
    private String profilePhotoUrl;
    private String dateOfBirth;
    private Gender gender;
    private String favoriteColor;
    private String hobbies;
    private String aboutMe;
    private int rating;
    private Boolean bestFriend;
    private String friendshipDate;
    private String songName;
    private String songArtist;
    private String songUrl;
    private String songDedication;
    private String memoryPhotoUrl;
    private String memoryText;
}
