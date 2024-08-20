package com.cotuca.models;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String name;
    @Column()
    private String address;
    @Column()
    private String city;
    @Column()
    private String state;
    @Column
    private String postalcode;


    public Customer(Integer id, String name, String address, String customerCity, String customerState, String customerPostalCode) {
        this.id = id;
        this.name = name;
        this.city = customerCity;
        this.address = address;
        this.state = customerState;
        this.postalcode = customerPostalCode;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getPostalcode() {
        return postalcode;
    }


    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((postalcode == null) ? 0 : postalcode.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductCategory other = (ProductCategory) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (postalcode == null) {
            if (other.postalcode != null)
                return false;
        } else if (!postalcode.equals(other.postalcode))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", state=" + state
                + ", postalcode=" + postalcode + "]";
    }


    
}
