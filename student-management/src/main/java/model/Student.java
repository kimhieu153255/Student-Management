package model;

import java.sql.Date;

public class Student {
  private int Id;
  private String Name;
  private int Grade;
  private Date Birthday;
  private String Address;
  private String Notes;

  public Student(int id, String name, int grade, Date birthday, String address, String notes) {
    super();
    this.Id = id;
    this.Name = name;
    this.Grade = grade;
    this.Birthday = birthday;
    this.Address = address;
    this.Notes = notes;
  }

  public Student() {
    Id = 0;
    Name = "";
    Grade = 0;
    Birthday = null;
    Address = "";
    Notes = "";
  }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    this.Id = id;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

  public int getGrade() {
    return Grade;
  }

  public void setGrade(int grade) {
    this.Grade = grade;
  }

  public Date getBirthday() {
    return Birthday;
  }

  public void setBirthday(Date birthday) {
    this.Birthday = birthday;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    this.Address = address;
  }

  public String getNotes() {
    return Notes;
  }

  public void setNotes(String notes) {
    this.Notes = notes;
  }

}