package com.company;

public class Account {
    private String name;
    private String birth;
    private String email;
    private String pass;
    private boolean blocked;

    public Account(String name, String birth, String email, String pass, boolean blocked){
        setBirth(birth);
        setName(name);
        setEmail(email);
        setPass(pass);
        setBlocked(blocked);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBirth(String birth){
        this.birth = birth;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public void setBlocked(boolean blocked){
        this.blocked = blocked;
    }

    public String getEmail(){
        return this.email;
    }

    @Override
    public String toString(){
        return this.name +", "+ this.birth +", "+ this.email +", "+ this.pass +", "+ this.blocked;
    }
}
