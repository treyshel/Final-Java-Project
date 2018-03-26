package com.example.backend.Repositories;

import com.example.backend.Connect;
import com.example.backend.Core.Student;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRepostiory {


    public static Student insertStudent(String f_name, String l_name, String session_key, String username, String p_word, String email) {
        try {
            System.out.println("hey...work!! PLEASE");
            Connection con = Connect.connectDB();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO student(f_name, l_name, session_key, username, p_word, email)" +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING id;");
            preparedStatement.setString(1, f_name);
            preparedStatement.setString(2, l_name);
            preparedStatement.setString(3, session_key);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, p_word);
            preparedStatement.setString(6, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            System.out.print(new Student(resultSet.getInt("id") ,f_name,l_name, session_key, username,p_word,email).f_name);
            return new Student(resultSet.getInt("id") ,f_name,l_name, session_key,username,p_word,email);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }


    public static ArrayList<Student> allStudents(){
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM student");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Student> allMember = new ArrayList<Student>();
            while (resultSet.next()){
                allMember.add(new
                        Student(resultSet.getInt("id"),
                        resultSet.getString("f_name"),
                        resultSet.getString("l_name"),
                        resultSet.getString("session_key"),
                        resultSet.getString("username"),
                        resultSet.getString("p_word"),
                        resultSet.getString("email")));
            }
            conn.close();
            return allStudents();
        }
        catch (SQLException e){
            return null;
        }
    }
}
