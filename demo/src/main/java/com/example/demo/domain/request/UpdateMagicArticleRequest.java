package com.example.demo.domain.request;

import com.example.demo.common.enums.Type;
import com.example.demo.domain.entites.MagicProvider;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMagicArticleRequest {
    private String name;
    private Type type;
    private Integer price;
    private MagicProvider provider;
}
