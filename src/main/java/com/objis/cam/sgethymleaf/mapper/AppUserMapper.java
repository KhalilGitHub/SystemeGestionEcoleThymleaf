package com.objis.cam.sgethymleaf.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
 

import org.springframework.jdbc.core.RowMapper;

import com.objis.cam.sgethymleaf.model.App_User;
 
public class AppUserMapper implements RowMapper<App_User> {
 
  //  public static final String BASE_SQL //
   //         = "Select u.User_Id, u.User_Name, u.Encryted_Password From App_User u ";
    
    public static final String BASE_SQL //
    = "Select u.USER_ID, u.USER_NAME, u.ENCRYTED_PASSWORD From app_user u ";
 
    @Override
    public App_User mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        Long userId = rs.getLong("USER_ID");
        String userName = rs.getString("USER_NAME");
        String encrytedPassword = rs.getString("ENCRYTED_PASSWORD");
 
        return new App_User(userId, userName, encrytedPassword);
    }
 
}
