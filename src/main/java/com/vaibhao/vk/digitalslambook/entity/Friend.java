package com.vaibhao.vk.digitalslambook.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "friends")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID friendId;

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

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}