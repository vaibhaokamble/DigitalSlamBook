package com.vaibhao.vk.digitalslambook.dto.request;

import com.vaibhao.vk.digitalslambook.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlamBookRequest {

    private String fullName;

    private String nickName;

    private String profilePhotoUrl;

    private LocalDate dateOfBirth;

    private Gender gender;

    private String favoriteColor;

    private List<String> hobbies;

    private String aboutMe;
}