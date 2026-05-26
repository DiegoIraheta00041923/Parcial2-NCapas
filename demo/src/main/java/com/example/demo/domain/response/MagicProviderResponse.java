package com.example.demo.domain.response;

import com.example.demo.common.enums.Type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MagicProviderResponse {
    private String name;
    private Type type;
}
