package com.example.demo.common.mappers;

import com.example.demo.domain.entites.MagicProvider;
import com.example.demo.domain.request.CreateMagicProviderRequest;
import com.example.demo.domain.request.UpdateMagicProviderRequest;
import com.example.demo.domain.response.MagicProviderResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MagicProviderMapper {

    public MagicProvider toEntityCreate(CreateMagicProviderRequest request){
        return MagicProvider.builder()
                .name(request.getName())
                .type(request.getType())
                .build();
    }

    public MagicProvider toEntityUpdate(UUID uuid, UpdateMagicProviderRequest request){
        return MagicProvider.builder()
                .id(uuid)
                .name(request.getName())
                .type(request.getType())
                .build();
    }

    public MagicProviderResponse toDto(MagicProvider magicProvider){
        return MagicProviderResponse.builder()
                .name(magicProvider.getName())
                .type(magicProvider.getType())
                .build();
    }

}
