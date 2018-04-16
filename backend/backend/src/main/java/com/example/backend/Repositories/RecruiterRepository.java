package com.example.backend.Repositories;

import com.example.backend.Connect;
import com.example.backend.Core.Recruiter;
import com.example.backend.Core.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecruiterRepository {
    public static Recruiter insertRecruiter(String f_name, String l_name, String title, String session_key, String username, String p_word, String email, String position_level, String company_name,
                                          String company_location, String langs_used, String website_url) {
        try {
            Connection con = Connect.connectDB();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO student(f_name, l_name, " +
                    "title, session_key, username, p_word, email, position_level, company_name, company_location, langs_used, website_url" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;");
            preparedStatement.setString(1, f_name);
            preparedStatement.setString(2, l_name);
            preparedStatement.setString(3, title);
            preparedStatement.setString(4, session_key);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, p_word);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, position_level);
            preparedStatement.setString(9, company_name);
            preparedStatement.setString(10, company_location);
            preparedStatement.setString(11, langs_used);
            preparedStatement.setString(12, website_url);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Recruiter(resultSet.getInt("id") ,f_name,l_name, title, session_key, username, p_word, email, position_level, company_name, company_location, langs_used, website_url);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
