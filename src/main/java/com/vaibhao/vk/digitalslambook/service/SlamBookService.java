package com.vaibhao.vk.digitalslambook.service;

import com.vaibhao.vk.digitalslambook.dto.request.SlamBookRequest;
import com.vaibhao.vk.digitalslambook.dto.response.SlamBookResponse;
import com.vaibhao.vk.digitalslambook.entity.SlamBook;
import com.vaibhao.vk.digitalslambook.exception.ResourceNotFoundException;
import com.vaibhao.vk.digitalslambook.mapper.SlamBookMapper;
import com.vaibhao.vk.digitalslambook.repository.SlamBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class SlamBookService {

    private final SlamBookRepository slamBookRepository;
    private final SlamBookMapper slamBookMapper;

    public SlamBookResponse createSlamBook(SlamBookRequest request) {

        SlamBook slamBook = SlamBook.builder()
                .fullName(request.getFullName())
                .nickName(request.getNickName())
                .profilePhotoUrl(request.getProfilePhotoUrl())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .favoriteColor(request.getFavoriteColor())
                .hobbies(request.getHobbies())
                .aboutMe(request.getAboutMe())
                .shareToken(UUID.randomUUID().toString())
                .build();

        SlamBook savedSlamBook = slamBookRepository.save(slamBook);

        return slamBookMapper.mapToResponse(savedSlamBook);
    }

    public java.util.List<SlamBookResponse> getAllSlamBooks() {
        return slamBookRepository.findAll().stream()
                .map(slamBookMapper::mapToResponse)
                .toList();
    }

    public SlamBookResponse getSlamBookByShareToken(String shareToken) {
        SlamBook slamBook = slamBookRepository.findByShareToken(shareToken)
                .orElseThrow(() -> new ResourceNotFoundException("SlamBook not found with share token: " + shareToken));
        return slamBookMapper.mapToResponse(slamBook);
    }

    public SlamBookResponse getSlamBookById(UUID slamBookId) {

        SlamBook slamBook = slamBookRepository.findById(slamBookId).orElseThrow(() -> new ResourceNotFoundException("SlamBook not found with id: " + slamBookId));

        return slamBookMapper.mapToResponse(slamBook);
    }

    public SlamBookResponse updateSlamBook(UUID slamBookId, SlamBookRequest request) {

        SlamBook slamBook = slamBookRepository.findById(slamBookId).orElseThrow(() -> new ResourceNotFoundException("SlamBook not found with id: " + slamBookId));

        slamBook.setFullName(request.getFullName());
        slamBook.setNickName(request.getNickName());
        slamBook.setProfilePhotoUrl(request.getProfilePhotoUrl());
        slamBook.setDateOfBirth(request.getDateOfBirth());
        slamBook.setGender(request.getGender());
        slamBook.setFavoriteColor(request.getFavoriteColor());
        slamBook.setHobbies(request.getHobbies());
        slamBook.setAboutMe(request.getAboutMe());

        SlamBook updatedSlamBook = slamBookRepository.save(slamBook);

        return slamBookMapper.mapToResponse(updatedSlamBook);
    }

    public void deleteSlamBook(UUID slamBookId) {

        SlamBook slamBook = slamBookRepository.findById(slamBookId).orElseThrow(() -> new ResourceNotFoundException("SlamBook not found with id: " + slamBookId));

        slamBookRepository.delete(slamBook);
    }
}