package com.example.kanaye.repository;

import com.example.kanaye.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CommentRepo extends JpaRepository<CommentEntity, Long> {
    Set<CommentEntity> findAllByOrderByIdAsc();
}
