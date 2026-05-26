package com.example.demo.controller;

import com.example.demo.domain.request.CreateMagicProviderRequest;
import com.example.demo.domain.request.UpdateMagicProviderRequest;
import com.example.demo.domain.response.GeneralResponse;
import com.example.demo.service.MagicProviderServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/providers")
@AllArgsConstructor
public class MagicProviderController {
    private final MagicProviderServiceImp magicProviderServiceImp;

    @PostMapping
    public ResponseEntity<GeneralResponse> createMagicProvider(@RequestBody CreateMagicProviderRequest request){
        return buildResponse(
                "New Magic provider was created",
                HttpStatus.OK,
                magicProviderServiceImp.createMagicProvider(request)
        );
    }

    @GetMapping
    public ResponseEntity<GeneralResponse> getAllMagicProvider(){
        return buildResponse(
                "Magic Providers found!",
                HttpStatus.OK,
                magicProviderServiceImp.getAllMagicProvider()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getMagicProvider(@PathVariable UUID id){
        return buildResponse("Magic provider found!",
                HttpStatus.OK,
                magicProviderServiceImp.getMagicProviderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateProvider(@PathVariable UUID id, @RequestBody UpdateMagicProviderRequest request){
        return buildResponse(
                "Magic Provider updated!",
                HttpStatus.OK,
                magicProviderServiceImp.updateMagicProvider(id,request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteProvider(@PathVariable UUID id){
        return buildResponse("Magic provider deleted!",
                HttpStatus.OK,
                magicProviderServiceImp.deleteMagicProvider(id));
    }

    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }
}
