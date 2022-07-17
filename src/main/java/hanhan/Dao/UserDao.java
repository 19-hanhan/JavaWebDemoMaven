package hanhan.Dao;

import hanhan.Entity.User;
import hanhan.Util.JDBCUtil;
import hanhan.Util.UserProcessor;

import java.util.ArrayList;

public class UserDao {

    // 功能函数
    public int createUser() {
        String sql = "CREATE TABLE webUser(" +
                "username varchar(19) primary key," +
                "password varchar(19) not null," +
                "studentId varchar(19)," +
                "age int," +
                "phoneNumber char(11)" +
                ")";
        int numOfColumn = JDBCUtil.update(sql);

        return numOfColumn;
    }

    public int insertUser(User item) { // 插入用户

        String sql = "insert into webUser(username, password, studentId, age, phoneNumber) value(?,?,null,null,null)";
        int numOfColumn = JDBCUtil.update(sql, item.getUsername(), item.getPassword());

        return numOfColumn;

    }

    public int updatePasswordByUsername(String username, String password) { // 更新用户信息

        String sql = "update webUser set password = ? where username = ?";
        int numOfColumn = JDBCUtil.update(sql, password, username);

        return numOfColumn;

    }

    public int updateUserMessage(User ur) { // 更新用户信息

        String sql = "update webUser set password = ?, studentId = ?, age = ?, phoneNumber = ? where username = ?";
        int numOfColumn = JDBCUtil.update(sql, ur.getPassword(), ur.getStudentId(), ur.getAge(), ur.getPhoneNumber(), ur.getUsername());

        return numOfColumn;

    }

    public int deleteUserByUsername(String username) { // 删除用户信息

        String sql = "delete from webUser where username = ?";
        int numOfColumn = JDBCUtil.update(sql, username);

        return numOfColumn;

    }

    public ArrayList<User> findUserByUsername(String username) { // 查询账号

        String sql = "select * from webUser where username = ?";

        ArrayList<User> ls = JDBCUtil.query(sql, new UserProcessor(), username);

        return ls;

    }

    public ArrayList<User> findAllUser() { // 查询所有用户

        String sql = "select * from webUser";

        ArrayList<User> ls = JDBCUtil.query(sql, new UserProcessor());

        return ls;

    }

}
