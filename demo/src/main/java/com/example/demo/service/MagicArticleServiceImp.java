package com.example.demo.service;

import com.example.demo.common.mappers.MagicArticleMapper;
import com.example.demo.domain.request.CreateMagicArticleRequest;
import com.example.demo.domain.request.UpdateMagicArticleRequest;
import com.example.demo.domain.response.MagicArticleResponse;
import com.example.demo.domain.response.MagicProviderResponse;
import com.example.demo.exceptions.BussinessLogicException;
import com.example.demo.exceptions.DuplicateItemsException;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.MagicArticleRepository;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MagicArticleServiceImp implements MagicArticleService{

    private final MagicArticleRepository magicArticleRepository;
    private final MagicArticleMapper magicArticleMapper;


    @Override
    public MagicArticleResponse createMagicArticle(CreateMagicArticleRequest request) {

        if (magicArticleRepository.findByName(request.getName().toLowerCase()).isPresent()){
            throw new DuplicateItemsException("This magic Article already exists");
        }

        if (request.getPrice() == 0){
            throw new BussinessLogicException("Article cannot be free");
        }



        return magicArticleMapper.toDto(
                magicArticleRepository.save(magicArticleMapper.toEntityCreate(request))
        );
    }

    @Override
    public MagicArticleResponse getMagicArticleById(UUID uuid) {
        return magicArticleMapper.toDto(magicArticleRepository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found")));
    }

    @Override
    public MagicArticleResponse updateMagicArticle(UUID id, UpdateMagicArticleRequest request) {
        this.getMagicArticleById(id);
        return magicArticleMapper.toDto(magicArticleRepository.save(magicArticleMapper.toEntityUpdate(id,request)));
    }

    @Override
    public MagicArticleResponse deleteMagicArticle(UUID id) {
        MagicArticleResponse existArticle = this.getMagicArticleById(id);

        magicArticleRepository.deleteById(id);
        return existArticle;
    }
}
