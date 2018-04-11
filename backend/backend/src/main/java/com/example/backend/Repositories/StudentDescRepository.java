package com.example.backend.Repositories;

import com.example.backend.Connect;
import com.example.backend.Core.Student;
import com.example.backend.Core.StudentDesc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDescRepository {

    public static StudentDesc insertStudentDesc(String programming_langs, String academics, String desired_location) {
        try {
            Connection con = Connect.connectDB();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO student_desc(programming_langs, academics, desired_location)" +
                    "VALUES (?, ?, ?) RETURNING id;");
            preparedStatement.setString(1, programming_langs);
            preparedStatement.setString(2, academics);
            preparedStatement.setString(3, desired_location);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new StudentDesc(resultSet.getInt("id"), resultSet.getInt("student_id"), programming_langs, academics, desired_location);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
