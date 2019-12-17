package com.codegym.test.service.impl;

import com.codegym.test.model.Diary;
import com.codegym.test.repository.IDiaryRepository;
import com.codegym.test.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiaryServiceImpl implements IDiaryService {
    @Autowired
    private IDiaryRepository repository;


    @Override
    public Optional<Diary> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Diary> findAll() {
        return repository.findAll();
    }

    @Override
    public Diary save(Diary diary) {
        return repository.save(diary);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Diary> findDiariesByTitleContaining(String title) {
        return repository.findDiariesByTitleContaining(title);
    }

}
