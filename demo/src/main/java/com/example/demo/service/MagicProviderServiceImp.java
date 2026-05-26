package com.example.demo.service;

import com.example.demo.common.mappers.MagicProviderMapper;
import com.example.demo.domain.entites.MagicProvider;
import com.example.demo.domain.request.CreateMagicProviderRequest;
import com.example.demo.domain.request.UpdateMagicProviderRequest;
import com.example.demo.domain.response.MagicProviderResponse;
import com.example.demo.exceptions.BussinessLogicException;
import com.example.demo.exceptions.DuplicateItemsException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.MagicProviderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MagicProviderServiceImp implements MagicProviderService {
    private final MagicProviderRepository magicProviderRepository;
    private final MagicProviderMapper magicProviderMapper;

    @Override
    public MagicProviderResponse createMagicProvider(CreateMagicProviderRequest request) {
        if (magicProviderRepository.findByName(request.getName()).isPresent()){
            throw new DuplicateItemsException("This magic provider already exists");
        }

        return magicProviderMapper.toDto(
                magicProviderRepository.save(magicProviderMapper.toEntityCreate(request))
        );
    }

    @Override
    public List<MagicProviderResponse> getAllMagicProvider() {
        List<MagicProvider> providers = magicProviderRepository.findAll();

        if (providers.isEmpty()){
            throw new ResourceNotFoundException("magic providers not found");
        }

        return providers.stream()
                .map(magicProviderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MagicProviderResponse updateMagicProvider(UUID id, UpdateMagicProviderRequest request) {
            this.getMagicProviderById(id);
            return magicProviderMapper.toDto(magicProviderRepository.save(magicProviderMapper.toEntityUpdate(id,request)));
    }

    @Override
    public MagicProviderResponse deleteMagicProvider(UUID uuid) {
        MagicProviderResponse existProvider = this.getMagicProviderById(uuid);

        if (existProvider.getType() != null){
            throw new BussinessLogicException("Is not possible to delete provider with type");
        }
        magicProviderRepository.deleteById(uuid);
        return existProvider;
    }

    @Override
    public MagicProviderResponse getMagicProviderById(UUID uuid) {
        return magicProviderMapper.toDto(magicProviderRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Provider not found")));
    }
}
