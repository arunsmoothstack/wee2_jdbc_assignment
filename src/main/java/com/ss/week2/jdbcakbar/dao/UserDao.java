package com.ss.week2.jdbcakbar.dao;

import com.ss.week2.jdbcakbar.model.User;
import com.ss.week2.jdbcakbar.service.ConnectionService;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao extends BaseDao<User>{

    public UserDao(ConnectionService connService) { super(connService.getConn()); }

    public User getUserById(int id) throws SQLException, ClassNotFoundException {
        List<User> users = read("Select * FROM users WHERE user_id = ?", new Object[] {id});
        if(users.isEmpty())
                return null;
        return users.get(0);
    }

    public int createUser(User user) throws SQLException, ClassNotFoundException {
        return saveWithPk("INSERT INTO users(name, username, password, role) VALUES (?, ?, ?, ?)", new Object[] {user.getName(), user.getUsername(), user.getPassword(), user.getRole()});
    }

    @Override
    public List<User> extractData(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getInt("role"), rs.getInt("user_id")));
        }
        return users;
    }
}
