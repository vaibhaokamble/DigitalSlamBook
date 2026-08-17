package com.vaibhao.vk.degitalslambook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "friends")
@RequiredArgsConstructor
@AllArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String friendName;

    private String relationship;

    private int friendshipRating;

    private Boolean bestFriend;

    private LocalDate friendshipDate;

    @Column(length = 500)
    private String message;

    private String songName;

    private String songArtist;

    private String songUrl;

    private String songDedication;

    private String memoryPhotoUrl;

    @Column(length = 500)
    private String memoryText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slam_book_id", nullable = false)
    private SlamBook slamBook;
}
