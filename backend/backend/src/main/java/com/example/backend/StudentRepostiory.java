package com.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRepostiory {


    public static ArrayList<Student> returnAllUsers() {
        try {
            Connection con = Connect.connectDB();
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM students;");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Student> students = new ArrayList<Student>();
            while(resultSet.next()){
                students.add(new Student(resultSet.getInt("id"),resultSet.getString("f_name"), resultSet.getString("l_name"), resultSet.getString("email")));
            }
            return students;
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
