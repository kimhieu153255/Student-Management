package model;

public class Course {
	private int Id;
	private String Name;
	private String Lecturer;
	private float Year;
	private String Notes;
	public Course() {
		this.Id = 0;
		this.Name = "";
		this.Lecturer = "";
		this.Year = 1999;
		this.Notes = "";
	}
	public Course(int id,String name,String lecturer,float year,String notes) {
		this.Id = id;
		this.Name = name;
		this.Lecturer = lecturer;
		this.Year = year;
		this.Notes = notes;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public int getId() {
		return Id;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getName() {
		return Name;
	}
	public void setLecturer(String lecturer) {
		this.Lecturer = lecturer;
	}
	public String getLecturer() {
		return Lecturer;
	}
	public void setYear(float year) {
		this.Year = year;
	}
	public float getYear() {
		return Year;
	}
	public void setNotes(String notes) {
		this.Notes = notes;
	}
	public String getNotes() {
		return Notes;
	}
}
