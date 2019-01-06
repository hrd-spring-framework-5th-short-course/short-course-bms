package com.example.shortcoursebms.repositories.providers;

import com.example.shortcoursebms.models.Category;
import com.example.shortcoursebms.utilities.Paginate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class CategoryProvider {

    public String getAllCategoryProvider(String name) {
        return new SQL() {{

            SELECT("*");
            FROM("tb_category c");

            if (name != null && !name.isEmpty()){
                System.out.println("ok check!");
                WHERE("c.name ilike '%' || #{name} || '%' ");
            }
            ORDER_BY("id");

//            WHERE("c.status is TRUE");

        }}.toString();
    }


    public String getAllCategoryPaginateProvider(@Param("name") String name,
                                                 @Param("paginate") Paginate paginate) {
        return new SQL() {{

            SELECT("*");
            FROM("tb_category c");

            if (name != null && !name.isEmpty()){
                WHERE("c.name ilike '%' || #{name} || '%' ");
            }
            ORDER_BY("id desc LIMIT #{paginate.limit} OFFSET #{paginate.offset}");
//            WHERE("c.status is TRUE");
        }}.toString();
    }



    public String getAllCategoryByIdProvider(Integer id) {

        return new SQL(){{

            SELECT("*");
            FROM("tb_category");
            WHERE("id = #{id}");

        }}.toString();
    }

    public String saveProvider(@Param("category") Category category) {
        return new SQL() {{

            INSERT_INTO("tb_category");
            VALUES("name", "#{category.name}");

        }}.toString();
    }


    public String updateCategoryProvider(Category category) {

        return new SQL(){{
            UPDATE("tb_category");
            SET("name=#{name}");
            SET("status=#{status}");
            WHERE("id=#{id}");
        }}.toString();
    }


    public String deleteCategoryProvider(Integer id) {
        return new SQL(){{

            DELETE_FROM("tb_category");
            WHERE("id=#{id}");

        }}.toString();
    }
}
