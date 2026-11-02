package com.example.practice.Controller;

import com.example.practice.Dto.CategoryDto;
import com.example.practice.Dto.CommentDto;
import com.example.practice.Dto.NewsDto;
import com.example.practice.Exception.DuplicateException;
import com.example.practice.Services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories() {
        try {
            List<CategoryDto> categories = newsService.getAllCategories();
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/categories")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
        try {
            String response = newsService.addCategory(categoryDto);
            return ResponseEntity.ok(response);
        } catch (DuplicateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred while adding category.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<?> getNewsByCategory(@PathVariable int categoryId) {
        try {
            List<NewsDto> newsList = newsService.getNewsByCategory(categoryId);
            return ResponseEntity.ok(newsList);
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{newsId}")
    public ResponseEntity<?> getNewsById(@PathVariable int newsId) {
        try {
            NewsDto newsDto = newsService.getNewsById(newsId);
            return ResponseEntity.ok(newsDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{newsId}/comment")
    public ResponseEntity<?> addComment(@PathVariable int newsId, @RequestBody CommentDto commentDto) {
        try {
            String response = newsService.addComment(newsId, commentDto);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}