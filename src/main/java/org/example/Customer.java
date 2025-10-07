package org.example;

public class Customer {
    String name,city;
    int orderValue;

    public Customer(){

    }

    public Customer(String name,String city,int orderValue){
        this.name = name;
        this.city = city;
        this.orderValue = orderValue;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(int orderValue) {
        this.orderValue = orderValue;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", orderValue=" + orderValue +
                '}';
    }
}



