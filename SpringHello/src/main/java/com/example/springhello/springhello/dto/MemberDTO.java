package com.example.springhello.springhello.dto;

public record MemberDTO(
        long id,
        String email,
        String name,
        String phone
) { }
