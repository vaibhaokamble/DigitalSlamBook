package com.vaibhao.vk.digitalslambook.mapper;

import com.vaibhao.vk.digitalslambook.dto.response.SlamBookResponse;
import com.vaibhao.vk.digitalslambook.entity.SlamBook;
import org.springframework.stereotype.Component;

@Component
public class SlamBookMapper {

    public SlamBookResponse mapToResponse(SlamBook slamBook) {

        return SlamBookResponse.builder()
                .id(slamBook.getId())
                .fullName(slamBook.getFullName())
                .nickName(slamBook.getNickName())
                .profilePhotoUrl(slamBook.getProfilePhotoUrl())
                .dateOfBirth(slamBook.getDateOfBirth() != null ? slamBook.getDateOfBirth().toString() : null)
                .gender(slamBook.getGender())
                .favoriteColor(slamBook.getFavoriteColor())
                .hobbies(String.valueOf(slamBook.getHobbies()))
                .aboutMe(slamBook.getAboutMe())
                .rating(slamBook.getRating())
                .bestFriend(slamBook.getBestFriend())
                .friendshipDate(slamBook.getFriendshipDate() != null ? slamBook.getFriendshipDate().toString() : null)
                .songName(slamBook.getSongName())
                .songArtist(slamBook.getSongArtist())
                .songUrl(slamBook.getSongUrl())
                .songDedication(slamBook.getSongDedication())
                .memoryPhotoUrl(slamBook.getMemoryPhotoUrl())
                .memoryText(slamBook.getMemoryText())
                .build();
    }
}