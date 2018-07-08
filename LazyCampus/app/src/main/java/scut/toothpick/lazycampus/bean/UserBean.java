package scut.toothpick.lazycampus.bean;

/**
 * Created by dgliang on 2018/7/7.
 */

public class UserBean {

    /**
     * id : 1
     * name : 马大头
     * password : 123456
     * credit : 5
     * sex : 1
     * phone_number : 13112345678
     * email : 132456@123.com
     * school : 华南理工大学
     * college : 软件学院
     * student_id : 201566612138
     * image_path : null
     */

    private String id;
    private String name;
    private String password;
    private String credit;
    private String sex;
    private String phone_number;
    private String email;
    private String school;
    private String college;
    private String student_id;
    private String image_path;

    public UserBean(String id, String name, String password, String credit, String sex,
                    String phone_number, String email, String school, String college,
                    String student_id, String image_path) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.credit = credit;
        this.sex = sex;
        this.phone_number = phone_number;
        this.email = email;
        this.school = school;
        this.college = college;
        this.student_id = student_id;
        this.image_path = image_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
