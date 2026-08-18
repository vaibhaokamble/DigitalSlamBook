package com.vaibhao.vk.digitalslambook.service;

import com.vaibhao.vk.digitalslambook.dto.request.FriendRequest;
import com.vaibhao.vk.digitalslambook.dto.response.FriendResponse;
import com.vaibhao.vk.digitalslambook.entity.Friend;
import com.vaibhao.vk.digitalslambook.entity.SlamBook;
import com.vaibhao.vk.digitalslambook.mapper.FriendMapper;
import com.vaibhao.vk.digitalslambook.repository.FriendRepository;
import com.vaibhao.vk.digitalslambook.repository.SlamBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final SlamBookRepository slamBookRepository;
    private final FriendRepository friendRepository;
    private final FriendMapper friendMapper;

    //Friend Service method create

    public FriendResponse addFriend(UUID slamBookId, FriendRequest friendRequest) {

        SlamBook slamBook = slamBookRepository.findById(slamBookId)
                .orElseThrow(() -> new RuntimeException("SlamBook not found with id: " + slamBookId));

        Friend friend = Friend.builder()
                .friendName(friendRequest.getFriendName())
                .relationship(friendRequest.getRelationship())
                .friendshipRating(friendRequest.getFriendshipRating())
                .bestFriend(friendRequest.getBestFriend())
                .friendshipDate(friendRequest.getFriendshipDate())
                .message(friendRequest.getMessage())
                .songName(friendRequest.getSongName())
                .songArtist(friendRequest.getSongArtist())
                .songUrl(friendRequest.getSongUrl())
                .songDedication(friendRequest.getSongDedication())
                .memoryPhotoUrl(friendRequest.getMemoryPhotoUrl())
                .memoryText(friendRequest.getMemoryText())
                .build();

        Friend friendSaved = friendRepository.save(friend);

        return friendMapper.mapToResponse(friendSaved);
    }

    //Friend Service method get all
    public List<FriendResponse> getAllFriends() {
        List<Friend> friends = friendRepository.findAll();
        return friendRepository.findAll().stream().map(friendMapper::mapToResponse)
                .toList();
    }

    //SlamBook Service method get by id
    public FriendResponse getFriendById(UUID id) {

        Friend friend = friendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friend not found with id: " + id));

        return friendMapper.mapToResponse(friend);
    }

    //Friend Service method update
    public FriendResponse updateFriend(UUID id, FriendRequest friendRequest) {

        Friend friend = friendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friend not found with id: " + id));

        friend.setFriendName(friendRequest.getFriendName());
        friend.setRelationship(friendRequest.getRelationship());
        friend.setFriendshipRating(friendRequest.getFriendshipRating());
        friend.setBestFriend(friendRequest.getBestFriend());
        friend.setFriendshipDate(friendRequest.getFriendshipDate());
        friend.setMessage(friendRequest.getMessage());
        friend.setSongName(friendRequest.getSongName());
        friend.setSongArtist(friendRequest.getSongArtist());
        friend.setSongUrl(friendRequest.getSongUrl());
        friend.setSongDedication(friendRequest.getSongDedication());
        friend.setMemoryPhotoUrl(friendRequest.getMemoryPhotoUrl());
        friend.setMemoryText(friendRequest.getMemoryText());

        Friend updatedFriend = friendRepository.save(friend);

        return friendMapper.mapToResponse(updatedFriend);
    }

    //Friend Service method update by slamBookId
    public FriendResponse updateFriendBySlamBookId(UUID slamBookId, UUID friendId, FriendRequest friendRequest) {
        SlamBook slamBook = slamBookRepository.findById(slamBookId)
                .orElseThrow(() -> new RuntimeException("SlamBook not found with id: " + slamBookId));

        Friend friend = friendRepository.findById(friendId)
                .orElseThrow(() -> new RuntimeException("Friend not found with id: " + friendId));

        if (!friend.getSlamBook().getId().equals(slamBook.getId())) {
            throw new RuntimeException("Friend does not belong to the specified SlamBook");
        }

        friend.setFriendName(friendRequest.getFriendName());
        friend.setRelationship(friendRequest.getRelationship());
        friend.setFriendshipRating(friendRequest.getFriendshipRating());
        friend.setBestFriend(friendRequest.getBestFriend());
        friend.setFriendshipDate(friendRequest.getFriendshipDate());
        friend.setMessage(friendRequest.getMessage());
        friend.setSongName(friendRequest.getSongName());
        friend.setSongArtist(friendRequest.getSongArtist());
        friend.setSongUrl(friendRequest.getSongUrl());
        friend.setSongDedication(friendRequest.getSongDedication());
        friend.setMemoryPhotoUrl(friendRequest.getMemoryPhotoUrl());
        friend.setMemoryText(friendRequest.getMemoryText());

        Friend updatedFriend = friendRepository.save(friend);

        return friendMapper.mapToResponse(updatedFriend);
    }

    //Friend Service method delete
    public void deleteFriend(UUID id) {
        Friend friend = friendRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Friend not found with id: " + id));
        friendRepository.delete(friend);
    }
}
