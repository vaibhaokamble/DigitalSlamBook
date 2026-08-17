package com.vaibhao.vk.degitalslambook.entity;

import com.vaibhao.vk.degitalslambook.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "slam_book")
@AllArgsConstructor
@RequiredArgsConstructor
public class SlamBook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String fullName;

    private String nickName;

    private String profilePhotoUrl;

    @Enumerated(EnumType.STRING)
    private LocalDate dateOfBirth;

    private Gender gender;

    private String favoriteColor;

    private List<String> hobbies;

    @Column(length = 500)
    private String aboutMe;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private Boolean bestFriend;

    private LocalDate friendshipDate;

    private String songName;

    private String songArtist;

    private String songUrl;

    private String songDedication;

    private String memoryPhotoUrl;

    @Column(length = 500)
    private String memoryText;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
