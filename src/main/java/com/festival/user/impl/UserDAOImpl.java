package com.festival.user.impl;

import com.festival.user.dao.UserDAO;
import com.festival.user.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private JdbcTemplate template;

    public UserDAOImpl (DataSource dataSource){
        template = new JdbcTemplate(dataSource);
    }


    @Override
    public User getUser(String login) {

        String sql = "SELECT * FROM users WHERE user_login = '" + login + "'";

        return template.query(sql, resultSet -> {
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setLogin(resultSet.getString("user_login"));
                user.setPassword(resultSet.getString("user_password"));
                user.setFirstName(resultSet.getString("user_firstname"));
                user.setSecondName(resultSet.getString("user_secondname"));
                user.setEmail(resultSet.getString("user_email"));
                user.setPhone(resultSet.getString("user_phone"));
                return user;
            }

            return null;
        });
    }

    @Override
    public List<User> listUsers() {
        String sql = "SELECT * FROM users";

        return template.query(sql, (resultSet, i) -> {
            User aUser = new User();
            aUser.setId(resultSet.getInt("user_id"));
            aUser.setLogin(resultSet.getString("user_login"));
            aUser.setPassword(resultSet.getString("user_password"));
            aUser.setFirstName(resultSet.getString("user_firstname"));
            aUser.setSecondName(resultSet.getString("user_secondname"));
            aUser.setEmail(resultSet.getString("user_email"));
            aUser.setPhone(resultSet.getString("user_phone"));
            return aUser;
        });
    }

    @Override
    public void createUpdate(String login, String password, String firstName, String secondName, String email, String phone) {



        if (getUser(login)==null){

            String sql = "INSERT INTO users (user_login, user_password, user_firstname, user_secondname, user_email, user_phone)" +
                    "VALUES ('"+login+"','"+password+"','"+firstName+"','"+secondName+"','"+email+"','"+phone+"')";
            template.update(sql);

        }else{
            String sql = "UPDATE users " +
                    "SET user_login = '"+login+"', user_password = '"+password+"', user_firstname = '"+firstName+"', user_secondname = '"+secondName+"', user_email = '"+email+"', user_phone = '"+phone+"'" +
                    "WHERE user_login = '"+login+"'";
            template.update(sql);
            }

    }

    @Override
    public void deleteUser(String login) {
        String sql = "DELETE FROM users WHERE user_login = '" + login + "'";
        template.update(sql);
    }
}
