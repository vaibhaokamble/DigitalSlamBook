package com.vaibhao.vk.digitalslambook.service;

import com.vaibhao.vk.digitalslambook.dto.request.SlamBookRequest;
import com.vaibhao.vk.digitalslambook.dto.response.SlamBookResponse;
import com.vaibhao.vk.digitalslambook.entity.SlamBook;
import com.vaibhao.vk.digitalslambook.mapper.SlamBookMapper;
import com.vaibhao.vk.digitalslambook.repository.SlamBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SlamBookService {

    private final SlamBookRepository slamBookRepository;
    private final SlamBookMapper slamBookMapper;

    //SlamBook Service method create
    public SlamBookResponse createSlamBook(SlamBookRequest slamBookRequest) {
        SlamBook slamBook = SlamBook.builder()
                .fullName(slamBookRequest.getFullName())
                .nickName(slamBookRequest.getNickName())
                .profilePhotoUrl(slamBookRequest.getProfilePhotoUrl())
                .dateOfBirth(LocalDate.parse(slamBookRequest.getDateOfBirth()))
                .gender(slamBookRequest.getGender())
                .favoriteColor(slamBookRequest.getFavoriteColor())
                .hobbies(Collections.singletonList(slamBookRequest.getHobbies()))
                .aboutMe(slamBookRequest.getAboutMe())
                .rating(slamBookRequest.getRating())
                .bestFriend(slamBookRequest.getBestFriend())
                .friendshipDate(LocalDate.parse(slamBookRequest.getFriendshipDate()))
                .songName(slamBookRequest.getSongName())
                .songArtist(slamBookRequest.getSongArtist())
                .songUrl(slamBookRequest.getSongUrl())
                .songDedication(slamBookRequest.getSongDedication())
                .memoryPhotoUrl(slamBookRequest.getMemoryPhotoUrl())
                .memoryText(slamBookRequest.getMemoryText())
                .build();
        SlamBook savedSlamBook = slamBookRepository.save(slamBook);

        return slamBookMapper.mapToResponse(savedSlamBook);
    }

    //SlamBook Service method get all
    public List<SlamBookResponse> getAllSlamBooks() {
        List<SlamBook> slamBooks = slamBookRepository.findAll();

        return slamBooks.stream().map(slamBookMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    //SlamBook Service method get by id
    public SlamBookResponse getSlamBookById(UUID id) {
        SlamBook slamBook = slamBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SlamBook not found with id: " + id));

        return slamBookMapper.mapToResponse(slamBook);
    }

    //SlamBook Service method update
    public SlamBookResponse updateSlamBook(UUID id, SlamBookRequest slamBookRequest) {
        SlamBook slamBook = slamBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SlamBook not found with id: " + id));

        slamBook.setFullName(slamBookRequest.getFullName());
        slamBook.setNickName(slamBookRequest.getNickName());
        slamBook.setProfilePhotoUrl(slamBookRequest.getProfilePhotoUrl());
        slamBook.setDateOfBirth(LocalDate.parse(slamBookRequest.getDateOfBirth()));
        slamBook.setGender(slamBookRequest.getGender());
        slamBook.setFavoriteColor(slamBookRequest.getFavoriteColor());
        slamBook.setHobbies(Collections.singletonList(slamBookRequest.getHobbies()));
        slamBook.setAboutMe(slamBookRequest.getAboutMe());
        slamBook.setRating(slamBookRequest.getRating());
        slamBook.setBestFriend(slamBookRequest.getBestFriend());
        slamBook.setFriendshipDate(LocalDate.parse(slamBookRequest.getFriendshipDate()));
        slamBook.setSongName(slamBookRequest.getSongName());
        slamBook.setSongArtist(slamBookRequest.getSongArtist());
        slamBook.setSongUrl(slamBookRequest.getSongUrl());
        slamBook.setSongDedication(slamBookRequest.getSongDedication());
        slamBook.setMemoryPhotoUrl(slamBookRequest.getMemoryPhotoUrl());
        slamBook.setMemoryText(slamBookRequest.getMemoryText());

        SlamBook updatedSlamBook = slamBookRepository.save(slamBook);
        return slamBookMapper.mapToResponse(updatedSlamBook);
    }

    //SlamBook Service method delete
    public void deleteSlamBook(UUID id) {
        SlamBook slamBook = slamBookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SlamBook not found with id: " + id));

        slamBookRepository.delete(slamBook);
    }
}