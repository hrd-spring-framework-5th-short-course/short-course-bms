package com.example.shortcoursebms.repositories;

import com.example.shortcoursebms.models.User;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryJDBC {

    private DataSource dataSource;

    public UserRepositoryJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> getAllUsers() {

        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()) {

            String sql = "select * from tb_user where status is true";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getBoolean(6),
                        resultSet.getTimestamp(7)
                );

                users.add(user);
            }

            return users;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return null;
        }
    }


    public int save(User user) {

        try (Connection connection = dataSource.getConnection()) {

            String sql = "insert into tb_user(username, " +
                    "fullname,gender,email) values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getEmail());

            int status = preparedStatement.executeUpdate();

            return status;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return 0;
        }
    }

    public int update(User user) {
        try (Connection connection = dataSource.getConnection()) {

            String sql = "update tb_user set username = ?, fullname = ?, gender=?, email=?" +
                    "where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getId());

            int status = preparedStatement.executeUpdate();

            return status;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return 0;
        }
    }

    public int delete(Integer id) {

        try (Connection connection = dataSource.getConnection()) {
            String sql = "update tb_user set status = false where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int status = preparedStatement.executeUpdate();

            return status;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return 0;
        }
    }

    /*public int delete(Integer id) {
        try (Connection connection = dataSource.getConnection()) {

            String sql = "delete from tb_user where id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int status = preparedStatement.executeUpdate();

            return status;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

            return 0;
        }
    }*/

}
