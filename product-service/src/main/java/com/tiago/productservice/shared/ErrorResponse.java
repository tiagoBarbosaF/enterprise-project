package com.tiago.productservice.shared;

import java.util.Map;

public record ErrorResponse(
        int status,
        Map<String, String> errors
) {
}
