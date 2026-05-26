package com.example.demo.domain.entites;

import com.example.demo.common.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "magic article")
@Builder
public class MagicArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Type type;
    private Integer price;
    @OneToOne(mappedBy = "magic provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private MagicProvider provider;
}
