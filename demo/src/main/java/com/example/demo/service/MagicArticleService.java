package com.example.demo.service;

import com.example.demo.domain.request.CreateMagicArticleRequest;
import com.example.demo.domain.request.UpdateMagicArticleRequest;
import com.example.demo.domain.response.MagicArticleResponse;
import com.example.demo.domain.response.MagicProviderResponse;

import java.util.UUID;

public interface MagicArticleService {
    MagicArticleResponse createMagicArticle(CreateMagicArticleRequest request);
    MagicArticleResponse getMagicArticleById(UUID uuid);
    MagicArticleResponse updateMagicArticle(UUID id, UpdateMagicArticleRequest request);
    MagicArticleResponse deleteMagicArticle(UUID id);
}
