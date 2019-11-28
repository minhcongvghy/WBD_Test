package com.codegym.test.service;

import com.codegym.test.model.Diary;

import java.util.Optional;

public interface IDiaryService {
    Optional<Diary> findById(Long id);

    Iterable<Diary> findAll();

    Diary save(Diary diary);

    void delete(Long id);

    Iterable<Diary> findDiariesByTitleContaining(String title);

    Iterable<Diary> findDiariesByTagId(Long tag_id);
}
