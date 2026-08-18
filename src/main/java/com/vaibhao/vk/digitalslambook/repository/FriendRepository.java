package com.vaibhao.vk.digitalslambook.repository;

import com.vaibhao.vk.digitalslambook.entity.Friend;
import com.vaibhao.vk.digitalslambook.entity.SlamBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface FriendRepository extends JpaRepository<Friend, UUID> {
    List<Friend> findBySlamBook(SlamBook slamBook);
}
