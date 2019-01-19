package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by guagua on 2019/1/14.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public boolean login(String username,String password){
        Connection connection = JdbcPool.getInstance().getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String pw = null;
        try{
            String sql = "select * from studentTable where stuid="+username;
            stmt=connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                pw = rs.getString(5);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                rs.close();
                stmt.close();
                JdbcPool.getInstance().releaseConnection(connection);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        if(pw!=null&&pw.equals(password)){
            System.out.println(pw);
            System.out.println(password);
            return true;
        }
        return false;
    }
}
