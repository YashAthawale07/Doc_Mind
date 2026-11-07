package com.project.doc_mind.dto;


import com.project.doc_mind.entity.Role;

public record UserDto(
        Long id,
        String username,
        String email,
        Role role
) {
}
