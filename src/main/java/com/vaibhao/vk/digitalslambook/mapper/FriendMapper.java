package com.vaibhao.vk.digitalslambook.mapper;

import com.vaibhao.vk.digitalslambook.dto.response.FriendResponse;
import com.vaibhao.vk.digitalslambook.entity.Friend;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class FriendMapper {

    public FriendResponse mapToResponse(Friend friend) {

        return FriendResponse.builder()
                .id(friend.getId())
                .friendName(friend.getFriendName())
                .relationship(friend.getRelationship())
                .friendshipRating(friend.getFriendshipRating())
                .bestFriend(friend.getBestFriend())
                .friendshipDate(friend.getFriendshipDate() != null ? LocalDate.parse(friend.getFriendshipDate().toString()) : null)
                .message(friend.getMessage())
                .songName(friend.getSongName())
                .songArtist(friend.getSongArtist())
                .songUrl(friend.getSongUrl())
                .songDedication(friend.getSongDedication())
                .memoryPhotoUrl(friend.getMemoryPhotoUrl())
                .memoryText(friend.getMemoryText())
                .build();
    }
}