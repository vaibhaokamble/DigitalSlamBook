package com.vaibhao.vk.digitalslambook.dto.request;

import com.vaibhao.vk.digitalslambook.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Full name is required")
    private String fullName;

    private String nickName;

    private String profilePhotoUrl;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    private Gender gender;

    @Size(max = 50, message = "Favorite color must not exceed 50 characters")
    private String favoriteColor;

    @Size(max = 10, message = "You can select maximum 10 hobbies")
    private List<@Size(max = 30, message = "Each hobby must not exceed 30 characters") String> hobbies;

    @Size(max = 500, message = "About me must not exceed 500 characters")
    private String aboutMe;
}