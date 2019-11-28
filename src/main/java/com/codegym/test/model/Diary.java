package com.codegym.test.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Lob
    private String title;

    @Lob
    private String description;

    @Lob
    private String file;

    private String typeFile;

    private Boolean isUpdate;

    @Lob
    private String content;

    @ManyToOne
    private Tag tag;


    public Diary(LocalDate date, String title, String description, String file, String typeFile, Boolean isUpdate, String content, Tag tag) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.typeFile = typeFile;
        this.isUpdate = isUpdate;
        this.content = content;
        this.tag = tag;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(String typeFile) {
        this.typeFile = typeFile;
    }

    public String getUpdate() {
        return isUpdate.toString();
    }

    public void setUpdate(Boolean update) {
        isUpdate = update;
    }

    public Diary(LocalDate date, String title, String description, String file, Boolean isUpdate, String content, Tag tag) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.isUpdate = isUpdate;
        this.content = content;
        this.tag = tag;
    }

    public Diary(LocalDate date, String title, String description, String file, String content, Tag tag) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.content = content;
        this.tag = tag;
    }

    public Diary() {
    }

    public Diary(LocalDate date, String title, String description, String file, String content) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.file = file;
        this.content = content;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
