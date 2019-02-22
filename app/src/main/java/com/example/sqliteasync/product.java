package com.example.sqliteasync;

public class product {

    private String name,dept;
    private int id;

    public product(int id,String name,String dept){

        this.setId(id);
        this.setName(name);
        this.setDept(dept);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
