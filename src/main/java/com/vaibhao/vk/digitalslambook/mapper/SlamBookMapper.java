package com.vaibhao.vk.digitalslambook.mapper;

import com.vaibhao.vk.digitalslambook.dto.response.SlamBookResponse;
import com.vaibhao.vk.digitalslambook.entity.SlamBook;
import org.springframework.stereotype.Component;

@Component
public class SlamBookMapper {

    public SlamBookResponse mapToResponse(SlamBook slamBook) {

        return SlamBookResponse.builder()
                .slamBookId(slamBook.getSlamBookId())
                .fullName(slamBook.getFullName())
                .nickName(slamBook.getNickName())
                .profilePhotoUrl(slamBook.getProfilePhotoUrl())
                .dateOfBirth(slamBook.getDateOfBirth())
                .gender(slamBook.getGender())
                .favoriteColor(slamBook.getFavoriteColor())
                .hobbies(slamBook.getHobbies() != null ? new java.util.ArrayList<>(slamBook.getHobbies()) : null)
                .aboutMe(slamBook.getAboutMe())
                .shareToken(slamBook.getShareToken())
                .createdAt(slamBook.getCreatedAt())
                .updatedAt(slamBook.getUpdatedAt())
                .build();
    }
}