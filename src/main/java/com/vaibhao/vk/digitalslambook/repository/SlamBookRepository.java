package com.vaibhao.vk.digitalslambook.repository;

import com.vaibhao.vk.digitalslambook.entity.SlamBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SlamBookRepository extends JpaRepository<SlamBook, UUID> {
    Optional<SlamBook> findByShareToken(String shareToken);
}
