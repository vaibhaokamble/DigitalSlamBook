package com.vaibhao.vk.degitalslambook.entity;

import com.vaibhao.vk.degitalslambook.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class SlamBook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fullName;

    private String nickName;

    private String profilePhotoUrl;

    private LocalDate dateOfBirth;

    private Gender gender;

    private String favoriteColor;

    private String hobbies;

    private String aboutMe;

    private int rating;

    private Boolean bestFriend;

    private LocalDate friendshipDate;

    private String songName;

    private String songArtist;

    private String songUrl;

    private String songDedication;

    private String memoryPhoto;

    private String memoriesText;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
