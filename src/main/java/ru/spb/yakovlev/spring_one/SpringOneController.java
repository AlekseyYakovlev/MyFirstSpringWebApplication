package ru.spb.yakovlev.spring_one;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Aleksey Yakovlev on 06.02.2018
 * @project spring_one
 */
@Controller
public class SpringOneController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    public String index( Model model ) {

        model.addAttribute("users", getUsers());
        return "index";
    }

    private List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM testTable", new RowMapper<User>() {
            @Override
            public User mapRow( ResultSet rs, int i ) throws SQLException {
                return new User(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"));
            }
        });

    }

    @AllArgsConstructor
    @Data
    public class User {
        public int id;
        public String name;
        public int age;
    }

}
