package com.example.demo.service;

import com.example.demo.domain.request.CreateMagicProviderRequest;
import com.example.demo.domain.request.UpdateMagicProviderRequest;
import com.example.demo.domain.response.MagicProviderResponse;

import java.util.List;
import java.util.UUID;

public interface MagicProviderService {
    MagicProviderResponse createMagicProvider(CreateMagicProviderRequest request);
    List<MagicProviderResponse> getAllMagicProvider();
    MagicProviderResponse updateMagicProvider(UUID id, UpdateMagicProviderRequest request);
    MagicProviderResponse deleteMagicProvider(UUID uuid);
    MagicProviderResponse getMagicProviderById(UUID uuid);
}
