package com.Lisiwu.dao;

import com.Lisiwu.model.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
//have all jdbc methods u need -select -update -delete -insert
public interface IUserDao {
    public boolean saveUser(Connection con, user user) throws SQLException;
    public int deleteUser(Connection con, user user) throws SQLException;
    public int updateUser(Connection con, user user) throws SQLException;

    //select
    public user findById(Connection con, Integer id) throws SQLException;
    public user findByUsernamePassword(Connection con, String username,String password) throws SQLException;
    public List<user> findByUsername(Connection con, String username) throws SQLException;
    public List<user> findByPassword(Connection con, String password) throws SQLException;
    public List<user> findByEmail(Connection con,String email) throws SQLException;
    public List<user> findByGender(Connection con,String gender) throws SQLException;
    public List<user> findByBirthdate(Connection con, String birthDate) throws SQLException;
    public List<user> findAllUser(Connection con) throws SQLException;


}
