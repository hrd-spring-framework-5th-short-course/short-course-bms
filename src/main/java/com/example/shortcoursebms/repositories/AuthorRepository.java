package com.example.shortcoursebms.repositories;

import com.example.shortcoursebms.models.Author;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository {

    @Select("select * from tb_author")
    List<Author> getAll();




}
