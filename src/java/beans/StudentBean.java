/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author aefilms
 */
public class StudentBean {

    private String student_id;
    private String full_name;
    private int age;
    private String gender;
    private String email;
    private String phone_number;
    private String entry_date;

    public StudentBean() {

    }

    public StudentBean(String student_id, String full_name, int age, String gender, String email, String phone_number, String entry_date) {
        this.student_id = student_id;
        this.full_name = full_name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone_number = phone_number;
        this.entry_date = entry_date;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    @Override
    public String toString() {
        return "Student{" + "student_id=" + student_id + ", full_name=" + full_name + ", age=" + age + ", gender=" + gender + ", email=" + email + ", phone_number=" + phone_number + ", entry_date=" + entry_date + '}';
    }

}
