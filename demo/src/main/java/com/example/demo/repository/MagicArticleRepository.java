package com.example.demo.repository;

import com.example.demo.domain.entites.MagicArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MagicArticleRepository extends JpaRepository<MagicArticle, UUID> {
    Optional<MagicArticle> findByName(String name);
}
