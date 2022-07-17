package hanhan.Entity;

public class User {

    private String username; // 用户账号
    private String password; // 用户密码
    private String studentId; // 学号
    private int age; // 年龄
    private String phoneNumber; // 电话号码

    // 构造方法
    public User() {
        username = "empty";
        password = "empty";
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "[username: " + username + ", password: " + password + ", studentId: "
                + studentId + ", age: " + age + ", phoneNumber: " + phoneNumber + "]";
    }


    // get/set函数
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    // 表单get获取
//    public String getFirst() { return username; }
//    public String getSecond() { return password; }
//    public String getThird() { return studentId; }
//    public int getFourth() { return age; }
//    public String getFifth() { return phoneNumber; }
}