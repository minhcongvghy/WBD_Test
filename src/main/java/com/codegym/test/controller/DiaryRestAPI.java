package com.codegym.test.controller;

import com.codegym.test.message.request.SearchDiaryByTitleForm;
import com.codegym.test.model.Diary;
import com.codegym.test.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class DiaryRestAPI {

    @Autowired
    private IDiaryService diaryService;

    @GetMapping("/diary")
    public ResponseEntity<?> getListDiary() {
        List<Diary> diaries = (List<Diary>) diaryService.findAll();
        if(diaries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(diaries,HttpStatus.OK);
    }

    @GetMapping("/diary/{id}")
    public ResponseEntity<?> getDiary(@PathVariable Long id) {
        Optional<Diary> diary = diaryService.findById(id);

        if (!diary.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(diary, HttpStatus.OK);
    }

    @PostMapping("/diary")
    public ResponseEntity<?> createDiary(@Valid @RequestBody Diary diary) {

        LocalDate date = LocalDate.now();

        diary.setDate(date);
        diary.setUpdate(false);
        diaryService.save(diary);

        return new ResponseEntity<>(diary, HttpStatus.CREATED);
    }

    @PutMapping("/diary/{id}")
    public ResponseEntity<?> updateDiary(@Valid @RequestBody Diary diary, @PathVariable Long id) {
        Optional<Diary> diary1 = diaryService.findById(id);

        if (!diary1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LocalDate date = LocalDate.now();
        diary1.get().setDate(date);
        diary1.get().setTitle(diary.getTitle());
        diary1.get().setDescription(diary.getDescription());
        diary1.get().setContent(diary.getContent());
        diary1.get().setUpdate(true);
        diary1.get().setTag(diary.getTag());

        diaryService.save(diary1.get());

        return new ResponseEntity<>(diary1, HttpStatus.OK);
    }

    @DeleteMapping("/diary/{id}")
    public ResponseEntity<?> deleteDiary(@PathVariable Long id) {
        Optional<Diary> diary = diaryService.findById(id);

        if (!diary.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        diaryService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/diary/search-by-title")
    public ResponseEntity<?> getListDiaryByTitle(@RequestBody SearchDiaryByTitleForm titleForm) {
        if (titleForm.getTitle() == "" || titleForm.getTitle() == null ) {
            List<Diary> diaries = (List<Diary>) diaryService.findAll();

            if(diaries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(diaries,HttpStatus.OK);
            }
        }

        List<Diary> diaries = (List<Diary>) diaryService.findDiariesByTitleContaining(titleForm.getTitle());
        if(diaries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(diaries,HttpStatus.OK);
        }
    }

}
