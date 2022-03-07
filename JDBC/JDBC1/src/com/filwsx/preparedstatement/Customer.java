package com.filwsx.preparedstatement;

import java.sql.Date;

/**
 * @author filwsx
 * @date 2022-03-07 15:57
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private Date birth;

    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
