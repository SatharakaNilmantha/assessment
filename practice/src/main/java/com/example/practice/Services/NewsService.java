package com.example.practice.Services;

import com.example.practice.Dto.CategoryDto;
import com.example.practice.Dto.CommentDto;
import com.example.practice.Dto.NewsDto;

import java.util.List;

public interface NewsService {
    List<CategoryDto> getAllCategories();
    String addCategory(CategoryDto categoryDto);

    List<NewsDto> getNewsByCategory(int categoryId);
    NewsDto getNewsById(int newsId);
    String addComment(int newsId, CommentDto commentDto);
}