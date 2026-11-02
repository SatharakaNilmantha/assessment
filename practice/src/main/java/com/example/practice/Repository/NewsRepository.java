package com.example.practice.Repository;

import com.example.practice.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {


    @Query(value = "SELECT n.* FROM news n JOIN news_category nc ON n.id = nc.news_id WHERE nc.category_id = ?1", nativeQuery = true)
    List<News> getNewsByCategoryId(int categoryId);


    @Query(value = "SELECT * FROM news WHERE id = ?1", nativeQuery = true)
    News getNewsById(int newsId);
}