package com.example.demo.entity;
import javax.persistence.*;
@Entity
@Table(name="bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="price")
    private String price;

    @Column(name="name")
    private String name;

    @Column(name="account_number")
    private String account_number;

    @Column(name="payment")
    private String payment;

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", account_number='" + account_number + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
