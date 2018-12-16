package com.example.shortcoursebms.repositories;

import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.Category;
import com.example.shortcoursebms.models.responses.BookResponse;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {


    /*@Select("select b.id as b_id, b.title, b.publish_date, b.book_image, b.isbn," +
            " b.status b_status, b.created_at b_created_at, " +

            "c.id as c_id, c.name, c.created_at c_created_at, c.status c_status" +
            " from tb_book b inner join tb_category c" +
            " on b.cate_id = c.id")
    @Results({

            @Result(column = "b_id", property = "id"),
            @Result(column = "isbn", property = "ISBN"),
            @Result(column = "book_image", property = "bookImage"),
            @Result(column = "publish_date", property = "publishDate"),
            @Result(column = "b_created_at", property = "createdAt"),
            @Result(column = "b_status", property = "status"),

            @Result(column = "c_id", property = "category.id"),
            @Result(column = "name", property = "category.name"),
            @Result(column = "c_created_at", property = "category.createdAt"),
            @Result(column = "c_status", property = "category.status"),
    })
    List<Book> getAllBook();*/


    @Select("select * from tb_book")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "cate_id", property = "category.id"),
            @Result(column = "isbn", property = "ISBN"),
            @Result(column = "book_image", property = "bookImage"),
            @Result(column = "publish_date", property = "publishDate"),
            @Result(column = "created_at", property = "createdAt"),

            @Result(column = "cate_id", property = "category", one = @One(select = "getCategoryById"))

    })
    List<Book> getAllBook();


    @Select("select * from tb_category where id = #{cate_id}")
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    Category getCategoryById(@Param("cate_id") Integer id);


    @Select("select b.id, b.title, b.book_image as bookImage, " +
            "b.isbn as ISBN, c.name as categoryName" +

            " from tb_book b inner join tb_category c" +
            " on b.cate_id = c.id")
    List<BookResponse> getAllBookResponse();


}
