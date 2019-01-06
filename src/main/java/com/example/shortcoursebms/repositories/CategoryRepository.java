package com.example.shortcoursebms.repositories;

import com.example.shortcoursebms.models.Book;
import com.example.shortcoursebms.models.Category;
import com.example.shortcoursebms.repositories.providers.CategoryProvider;
import com.example.shortcoursebms.utilities.Paginate;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    @SelectProvider(type = CategoryProvider.class, method = "getAllCategoryProvider")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "id", property = "books",
                    many = @Many(select = "getAllBookByCategory"))
})
    List<Category> getAllCategory(String name);


    @SelectProvider(type = CategoryProvider.class, method = "getAllCategoryPaginateProvider")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "id", property = "books",
                    many = @Many(select = "getAllBookByCategory"))
    })
    List<Category> getAllCategoryPaginate(@Param("name") String name,
                                          @Param("paginate") Paginate paginate);


    @Select("select count(*) from tb_category where name ilike '%' || #{name} || '%'")
    int count(String name);


    @Select("SELECT * FROM tb_book where cate_id = #{id}")
    @Results({
            @Result(column = "book_image", property = "bookImage")
    })
    List<Book> getAllBookByCategory(Integer id);



    @SelectProvider(type = CategoryProvider.class, method = "getAllCategoryByIdProvider")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "created_at", property = "createdAt")
    })
    Category getAllCategoryById(Integer id);



    @InsertProvider(type = CategoryProvider.class, method = "saveProvider")
    /*@SelectKey(
            statement = "select currval('tb_category_id_seq') as cur_val",
            before = false,
            keyColumn = "cur_val",
            keyProperty = "category.id",
            resultType = Integer.class,
            statementType = StatementType.PREPARED
    )*/


    @Options(useGeneratedKeys = true, keyProperty = "category.id",
            keyColumn = "id") // for h2 db
    boolean save(@Param("category") Category category);


    @Insert({"<script>" ,
                "insert into tb_category(name) " ,
                "values" ,
                    "<foreach collection='categories' item='category' " ,
                            "index='cate_index' separator=',' >" ,
                            "(" ,
                                "#{category.name}",
                            ")",
                    "</foreach>" ,
            "</script>"})
//    @SelectKey(
//            statement = "select currval('tb_category_id_seq') as cur_val",
//            before = false,
//            keyColumn = "cur_val",
//            keyProperty = "category.id",
//            resultType = Integer.class,
//            statementType = StatementType.PREPARED
//    )
    boolean saveBatch(@Param("categories") List<Category> categories);


    @UpdateProvider(type = CategoryProvider.class, method = "updateCategoryProvider")
    boolean updateCategory(Category category);


    @DeleteProvider(type = CategoryProvider.class, method = "deleteCategoryProvider")
    Integer delete(Integer id);


}
