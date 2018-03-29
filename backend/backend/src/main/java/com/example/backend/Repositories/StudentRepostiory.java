package com.example.backend.Repositories;

import com.example.backend.Connect;
import com.example.backend.Core.Student;
import org.mindrot.jbcrypt.BCrypt;
import org.postgresql.core.SqlCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.springframework.http.HttpHeaders.FROM;

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
            System.out.println(allStudents());
            return allStudents();
        }
        catch (SQLException e){
            return null;
        }
    }

    public static Student byUsername(String username){
        try {
            System.out.println("1");
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM student WHERE username = ?" );
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Student(resultSet.getInt("id"),
                    resultSet.getString("f_name"),
                    resultSet.getString("l_name"),
                    resultSet.getString("session_key"),
                    resultSet.getString("username"),
                    resultSet.getString("p_word"),
                    resultSet.getString("email"));
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean byeByeSessionKey(String username) {
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE student SET session_key = null WHERE username = ? RETURNING *");
            preparedStatement.setString(1, username);
            preparedStatement.execute();
            conn.close();
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }

    public static Student existingMember(String sessionKey, String username, String password) {
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE student SET session_key = ? WHERE student = ? and password = ? RETURNING *");
            preparedStatement.setString(1, sessionKey);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            conn.close();
            return new Student(resultSet.getInt("id"),
                    resultSet.getString("f_name"),
                    resultSet.getString("l_name"),
                    resultSet.getString("session_key"),
                    resultSet.getString("username"),
                    resultSet.getString("p_word"),
                    resultSet.getString("email"));
        } catch (SQLException e) {
            return null;
        }
    }
}
