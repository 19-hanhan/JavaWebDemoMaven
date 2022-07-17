package test;

import hanhan.Dao.UserDao;
import hanhan.Entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class jdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        User ur = new User("9", "9");

        UserDao dao = new UserDao();

    	int result = dao.insertUser(ur);
//    	int result = dao.insertStudent(stu);
//        int result = dao.updateStudent(stu);
        ArrayList<User> urs = dao.findAllUser();

    	if (result == 1) {
			System.out.println("成功！");
		} else {
			System.out.println("失败！");
		}

        for (User item : urs) {

            System.out.println(item);

        }

    }
}






