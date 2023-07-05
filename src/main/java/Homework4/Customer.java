package Homework4;

// Класс представляющий покупателя
public class Customer {
    private String fullName;
    private int age;
    private String phoneNumber;
    private Gender gender;

    public Customer(String fullName, int age, String phoneNumber, Gender gender) {
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    // Геттеры и сеттеры

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}