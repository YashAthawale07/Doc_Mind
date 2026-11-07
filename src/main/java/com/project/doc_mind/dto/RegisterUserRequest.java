package com.project.doc_mind.dto;



public record RegisterUserRequest(
        String username,
        String email,
        String password
) {
}
