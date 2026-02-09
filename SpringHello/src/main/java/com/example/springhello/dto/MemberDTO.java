package com.example.springhello.dto;

public record MemberDTO(
        long id,
        String email,
        String name,
        String phone
) { }
