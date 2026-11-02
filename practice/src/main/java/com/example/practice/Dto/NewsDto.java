package com.example.practice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
    private int id;
    private String title;
    private String content;
    private List<CategoryDto> categories;
    private List<CommentDto> comments;
}