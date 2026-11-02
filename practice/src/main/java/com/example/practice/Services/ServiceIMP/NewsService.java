package com.example.practice.Services.ServiceIMP;

import com.example.practice.Dto.CategoryDto;
import com.example.practice.Dto.CommentDto;
import com.example.practice.Dto.NewsDto;
import com.example.practice.Entity.Category;
import com.example.practice.Entity.Comment;
import com.example.practice.Entity.News;
import com.example.practice.Exception.DuplicateException;
import com.example.practice.Exception.NotFoundException;
import com.example.practice.Repository.CategoryRepository;
import com.example.practice.Repository.CommentRepository;
import com.example.practice.Repository.NewsRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements com.example.practice.Services.NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.getAllCategories();
        return modelMapper.map(categories, new TypeToken<List<CategoryDto>>() {}.getType());
    }



    @Override
    public String addCategory(CategoryDto categoryDto) {
        // Check if category already exists
        if (categoryRepository.existsByName(categoryDto.getName())) {
            throw new DuplicateException("Category with name '" + categoryDto.getName() + "' already exists.");
        }

        Category category = modelMapper.map(categoryDto, Category.class);
        categoryRepository.save(category);
        return "Category added successfully with name : " + categoryDto.getName();
    }

    @Override
    public List<NewsDto> getNewsByCategory(int categoryId) {
        List<News> newsList = newsRepository.getNewsByCategoryId(categoryId);
        return modelMapper.map(newsList, new TypeToken<List<NewsDto>>() {}.getType());
    }

    @Override
    public NewsDto getNewsById(int newsId) {
        News news = newsRepository.getNewsById(newsId);
        if (news == null) {
            throw new NotFoundException("News item not found with id : " + newsId);
        }
        return modelMapper.map(news, NewsDto.class);
    }

    @Override
    public String addComment(int newsId, CommentDto commentDto) {
        News news = newsRepository.getNewsById(newsId);
        if (news == null) {
            throw new NotFoundException("News item not found with id : " + newsId);
        }

        Comment comment = modelMapper.map(commentDto, Comment.class);
        comment.setNews(news); // Link comment to the specific news item
        commentRepository.save(comment);

        return "Comment added successfully to news id : " + newsId;
    }
}