package com.example.demo.domain.response;

import com.example.demo.common.enums.Type;
import com.example.demo.domain.entites.MagicProvider;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class MagicArticleResponse {
    private UUID id;
    private String name;
    private Type type;
    private Integer price;
    private MagicProvider provider;
}