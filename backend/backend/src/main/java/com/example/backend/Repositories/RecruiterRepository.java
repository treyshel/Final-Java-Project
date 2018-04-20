package com.example.backend.Repositories;

import com.example.backend.Connect;
import com.example.backend.Core.Recruiter;
import com.example.backend.Core.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecruiterRepository {
    public static Recruiter insertRecruiter(String f_name, String l_name, String title, String session_key, String username, String p_word, String email, String position_level, String company_name,
                                          String company_location, String langs_used, String website_url) {
        try {
            Connection con = Connect.connectDB();
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO recruiter (f_name, l_name, " +
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

    public static Recruiter RecruiterExists(String sessionKey, String username, String password) {
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE recruiter SET session_key = ? WHERE username = ? and p_word = ? RETURNING *");
            preparedStatement.setString(1, sessionKey);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            conn.close();
            return new Recruiter(resultSet.getInt("id"),
                    resultSet.getString("f_name"),
                    resultSet.getString("l_name"),
                    resultSet.getString("title"),
                    resultSet.getString("sessionKey"),
                    resultSet.getString("username"),
                    resultSet.getString("p_word"),
                    resultSet.getString("email"),
                    resultSet.getString("position_level"),
                    resultSet.getString("company_name"),
                    resultSet.getString("company_location"),
                    resultSet.getString("langs_used"),
                    resultSet.getString("website_url"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static Recruiter byUsername(String username){
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM recruiter WHERE username = ?" );
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new Recruiter(resultSet.getInt("id"),
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
                    resultSet.getString("website_url"));
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList<Student> sameLocation(){
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM student ON JOIN WHERE recruiter.company_location = student.desired_location");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Student> sameLocation = new ArrayList<Student>();
            while (resultSet.next()){
                sameLocation.add(new
                        Student(resultSet.getInt("id"),
                        resultSet.getString("f_name"),
                        resultSet.getString("l_name"),
                        resultSet.getString("session_key"),
                        resultSet.getString("username"),
                        resultSet.getString("p_word"),
                        resultSet.getString("email"),
                        resultSet.getString("programming_langs"),
                        resultSet.getString("desired_location"),
                        resultSet.getString("linkedin_url"),
                        resultSet.getString("resume_url"),
                        resultSet.getString("github_url"),
                        resultSet.getString("portfolio_url")));
            }
            conn.close();
            return sameLocation;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

//    public static ArrayList<Student> sameLanguage() {
//        try {
//            Connection conn = Connect.connectDB();
//            PreparedStatement preparedStatement = conn.prepareStatement(
//                    "SELECT * FROM student ON JOIN WHERE recruiter.langs_used = student.programming_langs")
//
//        }
//    }

    public static ArrayList<Recruiter> allRecruiters(){
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "SELECT * FROM recruiter");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Recruiter> allRecruiters = new ArrayList<Recruiter>();
            while (resultSet.next()){
                allRecruiters.add(new
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
            return allRecruiters;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean byeByeSessionKey(String username) {
        try {
            Connection conn = Connect.connectDB();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE recruiter SET session_key = null WHERE username = ? RETURNING *");
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
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM recruiter WHERE username = ?");
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
