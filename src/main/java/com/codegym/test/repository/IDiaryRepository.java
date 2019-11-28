package com.codegym.test.repository;

import com.codegym.test.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaryRepository extends JpaRepository<Diary, Long> {
    Iterable<Diary> findDiariesByTitleContaining(String title);
    Iterable<Diary> findDiariesByTagId(Long tag_id);
}
