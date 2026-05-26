package com.example.demo.domain.request;

import com.example.demo.common.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMagicProviderRequest {
    private String name;
    private Type type;
}
