package com.vaibhao.vk.digitalslambook.entity;

import com.vaibhao.vk.digitalslambook.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "slam_book")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class SlamBook {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID slamBookId;

    @Column(nullable = false)
    private String fullName;

    private String nickName;

    private String profilePhotoUrl;

    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String favoriteColor;

    @ElementCollection
    private List<String> hobbies;

    @Column(length = 500)
    private String aboutMe;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "slamBook", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Friend> friends = new ArrayList<>();
}