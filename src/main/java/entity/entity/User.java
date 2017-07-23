package entity.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * lixin
 * 2014-12-25
 */
public class User implements Serializable {
    private String name;
    private String age;
    private transient int money;
    private Date date;

    public User() {

    }

    public User(String name, String age, int money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
