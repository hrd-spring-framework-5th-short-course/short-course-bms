package com.example.shortcoursebms.repositories;

import com.example.shortcoursebms.models.Author;
import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.Category;
import com.example.shortcoursebms.models.forms.BookForm;
import com.example.shortcoursebms.models.responses.BookResponse;
import com.example.shortcoursebms.utilities.Paginate;
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

    @Select("select * from tb_book where status is true AND id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "cate_id", property = "category.id"),
            @Result(column = "isbn", property = "ISBN"),
            @Result(column = "book_image", property = "bookImage"),
            @Result(column = "publish_date", property = "publishDate"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "title", property = "title"),

            @Result(column = "cate_id", property = "category", one = @One(select = "getCategoryById")),
            @Result(column = "id", property = "authors", many = @Many(select = "getAuthorsByBookId"))

    })
    Book getOneBook(Integer id);



    @Select("select * from tb_book where status is true order by id desc limit #{limit} offset #{offset}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "cate_id", property = "category.id"),
            @Result(column = "isbn", property = "ISBN"),
            @Result(column = "book_image", property = "bookImage"),
            @Result(column = "publish_date", property = "publishDate"),
            @Result(column = "created_at", property = "createdAt"),

            @Result(column = "cate_id", property = "category", one = @One(select = "getCategoryById")),
            @Result(column = "id", property = "authors", many = @Many(select = "getAuthorsByBookId"))

    })
    List<Book> getAllBook(Paginate paginate);

    @Select("select count(*) from tb_book where status is true")
    int count();

    @Select("select * from tb_category where id = #{cate_id}")
    @Results({
            @Result(column = "created_at", property = "createdAt")
    })
    Category getCategoryById(@Param("cate_id") Integer id);

    @Select("select * from tb_author a inner join tb_book_author " +
            "tba on a.id = tba.author_id where book_id = #{id} ")
    @Results({
            @Result(property = "createdAt", column = "created_at")
    })
    List<Author> getAuthorsByBookId(@Param("id") Integer id);


    @Select("select b.id, b.title, b.book_image as bookImage, " +
            "b.isbn as ISBN, c.name as categoryName" +

            " from tb_book b inner join tb_category c" +
            " on b.cate_id = c.id")
    List<BookResponse> getAllBookResponse();


    @Insert("insert into tb_book(title, isbn, book_image, cate_id, publish_date)" +
            "values(#{title}, #{ISBN}, #{bookImage}, #{category.id}, #{publishDate})")
    @Options(useGeneratedKeys = true)
    boolean save(BookForm bookForm);

    @Insert({"<script>" ,
            "insert into tb_book_author(book_id, author_id) " ,
            "values" ,
            "<foreach collection='authors' item='author' " ,
            "index='index' separator=',' >" ,
            "(" ,
            "#{id}, #{author}",
            ")",
            "</foreach>" ,
            "</script>"})
    boolean saveBookAuthor(BookForm bookForm);


    @Update("update tb_book set title = #{title}, " +
            "isbn=#{ISBN}, " +
            "cate_id=#{category.id}, " +
            "book_image=#{bookImage}, "+
            "publish_date=#{publishDate} where id = #{id}")
    boolean update(BookForm bookForm);

    @Delete("delete from tb_book_author where book_id = #{id}")
    boolean deleteBookAuthor(Integer id);

    @Update("update tb_book_author set author_id = #{new_author_id} where book_id=#{book_id} and author_id=#{old_author_id}")
    boolean updateBookAuthor(@Param("new_author_id") Integer newAuthorId,@Param("old_author_id") Integer oldAuthorId,@Param("book_id") Integer bookId);

    @Delete("update tb_book set status=false where id = #{id}")
    boolean delete(Integer id);

}
