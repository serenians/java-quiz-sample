package service;

import data.entity.User;
import service.model.ResponseObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService extends BaseService {
    public ResponseObject<User> Login(String username, String password) throws SQLException, ClassNotFoundException {
        ResponseObject<User> result = null;

//        String query = "select UserId, UserName, LastLoginDate from public.\"User\" where UserName = '"+username+"' and Password = '"+password+"'";
//        String query = "SELECT \"UserId\",\"UserName\",\"LastLoginDate\" FROM \"User\"";
        String query = "select userid, username, lastlogindate, firstname, lastname from user where username = '"+username+"' and password = '"+password+"'";
        System.out.println(query);
        ResultSet resultSet = context.executeQuery(query);

        int count = 0;
        User user = null;
        while(resultSet.next()){
            user = new User();
            user.setUserId(resultSet.getInt("UserId"));
            user.setUsername(resultSet.getString("UserName"));
            user.setLastLoginDate(resultSet.getDate("LastLoginDate"));
            user.setFirstName(resultSet.getString("FirstName"));
            user.setLastName(resultSet.getString("LastName"));
            count ++;
        }

        if(count == 1){
            result = new ResponseObject<>(true, "User authenticated successfully.", user);
        }
        else{
            result = new ResponseObject<>(false, "User authentication failed.");
        }

        return result;
    }
}

