package hanhan.Util;

import hanhan.Entity.User;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UserProcessor implements ResultSetHandler<ArrayList<User>>{

    @Override
    public ArrayList<User> getData(ResultSet resSet) {

        ArrayList<User> ls = new ArrayList<User>();

        try {

            while (resSet.next()) { // 将结果集信息录入待办对象
                User item = new User();
                item.setUsername(resSet.getString("username"));
                item.setPassword(resSet.getString("password"));
                item.setStudentId(resSet.getString("studentID"));
                item.setAge(resSet.getInt("age"));
                item.setPhoneNumber(resSet.getString("phoneNumber"));

                ls.add(item);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return ls;

    }

}
