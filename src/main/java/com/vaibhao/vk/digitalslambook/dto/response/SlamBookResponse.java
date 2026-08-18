package com.vaibhao.vk.digitalslambook.dto.response;

import com.vaibhao.vk.digitalslambook.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlamBookResponse {

    private UUID slamBookId;

    private String fullName;

    private String nickName;

    private String profilePhotoUrl;

    private LocalDate dateOfBirth;

    private Gender gender;

    private String favoriteColor;

    private List<String> hobbies;

    private String aboutMe;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<FriendResponse> friends;
}