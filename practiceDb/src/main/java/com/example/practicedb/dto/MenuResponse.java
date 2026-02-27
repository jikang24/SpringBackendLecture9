package com.example.practicedb.dto;

public record MenuResponse(
    Long id,
    String name,
    int price,
    String categoryName
) {}