package com.Lisiwu.dao;

import com.Lisiwu.model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class userDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, user user) throws SQLException {
        //insert ... into usertable --- write code yourself
        String sql = "insert into usertable values(?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        st.setString(5,user.getBirthdate());
        int rs = st.executeUpdate();
        if(rs == 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public int deleteUser(Connection con, user user) throws SQLException {
        //delete ... where id-?--- write jdbc code yourself
        String sql = "delete from usertable where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,user.getId());
        int rs = st.executeUpdate();
        return rs;
    }

    @Override
    public int updateUser(Connection con, user user) throws SQLException {
        //update ... where id=?--- write jdbc code yourself
        String sql = "update usertable set username=?,password=?,email=?,gender=?,birthDate=? where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,user.getUsername());
        st.setString(2,user.getPassword());
        st.setString(3,user.getEmail());
        st.setString(4,user.getGender());
        st.setString(5,user.getBirthdate());
        st.setInt(6,user.getId());
        int rs = st.executeUpdate();
        return rs;
    }

    @Override
    public user findById(Connection con, Integer id) throws SQLException {
        //select --- where id=?--- write jdbc code yourself
        String sql = "select * from usertable where id=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs = st.executeQuery();
        user user = null;
        while (rs.next()){
            user = new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthDate"));
        }
        return user;
    }

    @Override
    public user findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //use for login
        //select --- where username=? and password=?---i will show you now
        String sql="select * from usertable where  username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs= st.executeQuery();
        user user=null;
        while (rs.next()){
            //get from rs and set into user model
            user=new user();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthdate"));
        }

        return user;
    }

    @Override
    public List<user> findByUsername(Connection con, String username) throws SQLException {
        //select --- where username=?--- write jdbc code yourself
        String sql = "select * from usertable where username=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs = st.executeQuery();
        user user = new user();
        List<user> list = new ArrayList<user>();
        while (rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthDate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<user> findByPassword(Connection con, String password) throws SQLException {
        //select --- where password=?--- write jdbc code yourself
        String sql = "select * from usertable where password=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs = st.executeQuery();
        user user = new user();
        List<user> list = new ArrayList<user>();
        while (rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthDate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<user> findByEmail(Connection con, String email) throws SQLException {
        //select --- where email=?--- write jdbc code yourself
        String sql = "select * from usertable where email=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs = st.executeQuery();
        user user = new user();
        List<user> list = new ArrayList<user>();
        while (rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthDate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<user> findByGender(Connection con, String gender) throws SQLException {
        //select --- where gender=?--- write jdbc code yourself
        String sql = "select * from usertable where gender=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs = st.executeQuery();
        user user = new user();
        List<user> list = new ArrayList<user>();
        while (rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthDate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<user> findByBirthdate(Connection con, String birthDate) throws SQLException {
        //select --- where birthdate=?--- write jdbc code yourself
        String sql = "select * from usertable where birthDate=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,birthDate);
        ResultSet rs = st.executeQuery();
        user user = new user();
        List<user> list = new ArrayList<user>();
        while (rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthDate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<user> findAllUser(Connection con) throws SQLException {
        String sql = "select * from usertable";
        ResultSet rs = con.createStatement().executeQuery(sql);
        user user = new user();
        List<user> list = new ArrayList<user>();
        while (rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("birthDate"));
            list.add(user);
        }
        return list;
    }
}
