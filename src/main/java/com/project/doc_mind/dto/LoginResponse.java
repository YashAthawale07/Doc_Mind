package com.project.doc_mind.dto;

public record LoginResponse(
        String accessToken,
        UserDto user
) {
}
