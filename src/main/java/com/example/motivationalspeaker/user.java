package com.example.motivationalspeaker;

public class user {
    private String Email;
    // private String Password;
    private String Fname;
    private String Lname;
    private String Pname;
    private String Pcode;

    public user() {
    }
    public user(String pname,String pcode)
    {
        Pname=pname;
        Pcode=pcode;
    }

    public user( String email,String fname, String lname) {
        Email = email;

        Fname = fname;
        Lname = lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        this.Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        this.Lname = lname;
    }
}
