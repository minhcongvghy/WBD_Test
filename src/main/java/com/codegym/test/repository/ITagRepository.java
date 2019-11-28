package com.codegym.test.repository;

import com.codegym.test.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {
    Iterable<Tag> findTagsByNameContaining(String tag_name);
}
