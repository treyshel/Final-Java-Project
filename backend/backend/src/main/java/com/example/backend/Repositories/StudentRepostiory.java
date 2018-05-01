package com.example.backend.Repositories;

import com.example.backend.Connect;
import com.example.backend.Core.Recruiter;
import com.example.backend.Core.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRepostiory {


    public static Student insertStudent(String f_name, String l_name, String session_key, String username, String p_word, String email, String programming_langs,
                                        String desired_location, String position_level, String resume_url, String github_url, String portfolio_url) {
        try {
            Connection con = Connect.connectDB();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO student(f_name, l_name, " +
                    "session_key, username, p_word, email, programming_langs, desired_location, position_level, resume_url," +
                    "github_url, portfolio_url)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;");
            preparedStatement.setString(1, f_name);
            preparedStatement.setString(2, l_name);
            preparedStatement.setString(3, session_key);
            preparedStatement.setString(4, username);
            preparedStatement.setString(5, p_word);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, programming_langs);
            preparedStatement.setString(8, desired_location);
            preparedStatement.setString(9, position_level);
            preparedStatement.setString(10, resume_url);
            preparedStatement.setString(11, github_url);
            preparedStatement.setString(12, portfolio_url);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Student(resultSet.getInt("id") ,f_name,l_name, session_key, username, p_word, email, programming_langs, desired_location, position_level, resume_url, github_url, portfolio_url);
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
            ArrayList<Student> allStudents = new ArrayList<Student>();
            while (resultSet.next()){
                allStudents.add(new
                        Student(resultSet.getInt("id"),
                        resultSet.getString("f_name"),
                        resultSet.getString("l_name"),
                        resultSet.getString("session_key"),
                        resultSet.getString("username"),
                        resultSet.getString("p_word"),
                        resultSet.getString("email"),
                        resultSet.getString("programming_langs"),
                        resultSet.getString("desired_location"),
                        resultSet.getString("position_level"),
                        resultSet.getString("resume_url"),
                        resultSet.getString("github_url"),
                        resultSet.getString("portfolio_url")));
            }
            conn.close();
            return allStudents;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList<Recruiter> sameLocation(){
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM recruiter JOIN student ON recruiter.company_location = student.desired_location");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Recruiter> sameLocation = new ArrayList<Recruiter>();
            while (resultSet.next()){
                sameLocation.add(new
                        Recruiter(resultSet.getInt("id"),
                        resultSet.getString("f_name"),
                        resultSet.getString("l_name"),
                        resultSet.getString("title"),
                        resultSet.getString("session_key"),
                        resultSet.getString("username"),
                        resultSet.getString("p_word"),
                        resultSet.getString("email"),
                        resultSet.getString("position_level"),
                        resultSet.getString("company_name"),
                        resultSet.getString("company_location"),
                        resultSet.getString("langs_used"),
                        resultSet.getString("website_url")));
            }
            conn.close();
            return sameLocation;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList<Recruiter> samePositionLevel(){
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM recruiter JOIN student ON recruiter.position_level = student.position_level");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Recruiter> sameLocation = new ArrayList<Recruiter>();
            while (resultSet.next()){
                sameLocation.add(new
                        Recruiter(resultSet.getInt("id"),
                        resultSet.getString("f_name"),
                        resultSet.getString("l_name"),
                        resultSet.getString("title"),
                        resultSet.getString("session_key"),
                        resultSet.getString("username"),
                        resultSet.getString("p_word"),
                        resultSet.getString("email"),
                        resultSet.getString("position_level"),
                        resultSet.getString("company_name"),
                        resultSet.getString("company_location"),
                        resultSet.getString("langs_used"),
                        resultSet.getString("website_url")));
            }
            conn.close();
            return sameLocation;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList<Recruiter> sameLanguage(){
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM recruiter JOIN student ON recruiter.langs_used = student.programming_langs");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Recruiter> sameLocation = new ArrayList<Recruiter>();
            while (resultSet.next()){
                sameLocation.add(new
                        Recruiter(resultSet.getInt("id"),
                        resultSet.getString("f_name"),
                        resultSet.getString("l_name"),
                        resultSet.getString("title"),
                        resultSet.getString("session_key"),
                        resultSet.getString("username"),
                        resultSet.getString("p_word"),
                        resultSet.getString("email"),
                        resultSet.getString("position_level"),
                        resultSet.getString("company_name"),
                        resultSet.getString("company_location"),
                        resultSet.getString("langs_used"),
                        resultSet.getString("website_url")));
            }
            conn.close();
            return sameLocation;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Student byUsername(String username){
        try {
            System.out.println(username);
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
                    resultSet.getString("email"),
                    resultSet.getString("programming_langs"),
                    resultSet.getString("desired_location"),
                    resultSet.getString("position_level"),
                    resultSet.getString("resume_url"),
                    resultSet.getString("github_url"),
                    resultSet.getString("portfolio_url"));
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Student StudentExists(String sessionKey, String username, String password) {
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE student SET session_key = ? WHERE username = ? and p_word = ? RETURNING *");
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
                    resultSet.getString("email"),
                    resultSet.getString("programming_langs"),
                    resultSet.getString("desired_location"),
                    resultSet.getString("position_level"),
                    resultSet.getString("resume_url"),
                    resultSet.getString("github_url"),
                    resultSet.getString("portfolio_url"));
        } catch (SQLException e) {
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
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean deleteAccount(String username) {
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM student WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
