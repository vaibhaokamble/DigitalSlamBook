package com.vaibhao.vk.digitalslambook.service;

import com.vaibhao.vk.digitalslambook.dto.request.FriendRequest;
import com.vaibhao.vk.digitalslambook.dto.response.FriendResponse;
import com.vaibhao.vk.digitalslambook.entity.Friend;
import com.vaibhao.vk.digitalslambook.entity.SlamBook;
import com.vaibhao.vk.digitalslambook.exception.ResourceNotFoundException;
import com.vaibhao.vk.digitalslambook.mapper.FriendMapper;
import com.vaibhao.vk.digitalslambook.repository.FriendRepository;
import com.vaibhao.vk.digitalslambook.repository.SlamBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class FriendService {

    private final FriendRepository friendRepository;
    private final SlamBookRepository slamBookRepository;
    private final FriendMapper friendMapper;

    public FriendResponse addFriend(UUID slamBookId, FriendRequest request) {

        SlamBook slamBook = slamBookRepository.findById(slamBookId)
                .orElseThrow(() -> new ResourceNotFoundException("SlamBook not found with id: " + slamBookId));

        Friend friend = Friend.builder()
                .friendName(request.getFriendName())
                .relationship(request.getRelationship())
                .friendshipRating(request.getFriendshipRating())
                .bestFriend(request.getBestFriend())
                .friendshipDate(request.getFriendshipDate())
                .message(request.getMessage())
                .songName(request.getSongName())
                .songArtist(request.getSongArtist())
                .songUrl(request.getSongUrl())
                .songDedication(request.getSongDedication())
                .memoryPhotoUrl(request.getMemoryPhotoUrl())
                .memoryText(request.getMemoryText())
                .slamBook(slamBook)
                .build();

        Friend savedFriend = friendRepository.save(friend);

        return friendMapper.mapToResponse(savedFriend);
    }


    public List<FriendResponse> getFriendsBySlamBook(UUID slamBookId) {

        SlamBook slamBook = slamBookRepository.findById(slamBookId).orElseThrow(() -> new ResourceNotFoundException("SlamBook not found with id: " + slamBookId));

        return friendRepository.findBySlamBook(slamBook)
                .stream()
                .map(friendMapper::mapToResponse)
                .toList();
    }

    public FriendResponse getFriendById(UUID friendId) {

        Friend friend = friendRepository.findById(friendId).orElseThrow(() -> new ResourceNotFoundException("Friend not found with id: " + friendId));

        return friendMapper.mapToResponse(friend);
    }


    public FriendResponse updateFriend(UUID friendId, FriendRequest request) {

        Friend friend = friendRepository.findById(friendId).orElseThrow(() -> new ResourceNotFoundException("Friend not found with id: " + friendId));

        friend.setFriendName(request.getFriendName());
        friend.setRelationship(request.getRelationship());
        friend.setFriendshipRating(request.getFriendshipRating());
        friend.setBestFriend(request.getBestFriend());
        friend.setFriendshipDate(request.getFriendshipDate());
        friend.setMessage(request.getMessage());
        friend.setSongName(request.getSongName());
        friend.setSongArtist(request.getSongArtist());
        friend.setSongUrl(request.getSongUrl());
        friend.setSongDedication(request.getSongDedication());
        friend.setMemoryPhotoUrl(request.getMemoryPhotoUrl());
        friend.setMemoryText(request.getMemoryText());

        Friend updatedFriend = friendRepository.save(friend);

        return friendMapper.mapToResponse(updatedFriend);
    }

    public void deleteFriend(UUID friendId) {

        Friend friend = friendRepository.findById(friendId).orElseThrow(() -> new ResourceNotFoundException("Friend not found with id: " + friendId));

        friendRepository.delete(friend);
    }
}