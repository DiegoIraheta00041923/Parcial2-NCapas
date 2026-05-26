package com.example.demo.common.mappers;

import com.example.demo.domain.entites.MagicArticle;
import com.example.demo.domain.entites.MagicProvider;
import com.example.demo.domain.request.CreateMagicArticleRequest;
import com.example.demo.domain.request.CreateMagicProviderRequest;
import com.example.demo.domain.request.UpdateMagicArticleRequest;
import com.example.demo.domain.request.UpdateMagicProviderRequest;
import com.example.demo.domain.response.MagicArticleResponse;
import com.example.demo.domain.response.MagicProviderResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MagicArticleMapper {
    public MagicArticle toEntityCreate(CreateMagicArticleRequest request){
        return MagicArticle.builder()
                .name(request.getName())
                .price(request.getPrice())
                .provider(request.getProvider())
                .type(request.getType())
                .build();
    }

    public MagicArticle toEntityUpdate(UUID uuid, UpdateMagicArticleRequest request){
        return MagicArticle.builder()
                .id(uuid)
                .name(request.getName())
                .price(request.getPrice())
                .provider(request.getProvider())
                .type(request.getType())
                .build();
    }

    public MagicArticleResponse toDto(MagicArticle magicArticle){
        return MagicArticleResponse.builder()
                .name(magicArticle.getName())
                .price(magicArticle.getPrice())
                .provider(magicArticle.getProvider())
                .type(magicArticle.getType())
                .build();
    }
}
