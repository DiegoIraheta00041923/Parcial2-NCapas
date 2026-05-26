package com.example.demo.repository;

import com.example.demo.domain.entites.MagicProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MagicProviderRepository extends JpaRepository<MagicProvider, UUID> {
    Optional<MagicProvider> findByName(String name);

}
