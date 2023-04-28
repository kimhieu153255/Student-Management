package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
	private Connection connection;
	public StudentModel() {
		initDB init = new initDB();
		connection = init.getConnection();
	}
	public boolean insert(String Name,String Grade,String Birdthday, String Address, String Notes) {
		try {
			if(Name==""||Address==""||Birdthday==""||Grade=="") {
				return false;
			}
			PreparedStatement stm = connection.prepareStatement("INSERT INTO SYS.STUDENT VALUES(NULL,?,TO_NUMBER(?),TO_DATE(?,'YYYY-MM-DD'),?,?)");
			stm.setString(1, Name);
			stm.setString(2, Grade);
			stm.setString(3, Birdthday);
			stm.setString(4, Address);
			stm.setString(5, Notes);
			ResultSet rs = stm.executeQuery();
			boolean flag = false;
			if(rs.next()) flag = true;
			rs.close();
			stm.close();
			connection.close();
			return flag;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Student search(String Id) {
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM SYS.STUDENT WHERE Id = TO_NUMBER(?)");
			stm.setString(1, Id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()==false) return null;
			Student student = new Student();
	        student.setId(rs.getInt("id"));
	        student.setName(rs.getString("name"));
	        student.setGrade(rs.getInt("grade"));
	        student.setBirthday(rs.getDate("birthday"));
	        student.setAddress(rs.getString("address"));
	        student.setNotes(rs.getString("notes"));
	        rs.close();
	        stm.close();
	        connection.close();
	        return student;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Student> searchName(String Name) {
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM SYS.STUDENT WHERE UPPER(NAME) like '%'||UPPER(?)||'%'");
			stm.setString(1, Name);
			ResultSet rs = stm.executeQuery();
			List<Student> list = new ArrayList<>();
			while(rs.next()) {
				Student student = new Student();
		        student.setId(rs.getInt("id"));
		        student.setName(rs.getString("name"));
		        student.setGrade(rs.getInt("grade"));
		        student.setBirthday(rs.getDate("birthday"));
		        student.setAddress(rs.getString("address"));
		        student.setNotes(rs.getString("notes"));
		        list.add(student);
	        }
	        rs.close();
	        stm.close();
	        connection.close();
	        return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Student> getAllStudents() {
	    try {
	    	List<Student> students = new ArrayList<Student>();
		    Statement statement = connection.createStatement();
		    ResultSet rs = statement.executeQuery("select * from sys.student");
		    while (rs.next()) {
		        Student student = new Student();
		        student.setId(rs.getInt("id"));
		        student.setName(rs.getString("name"));
		        student.setGrade(rs.getInt("grade"));
		        student.setBirthday(rs.getDate("birthday"));
		        student.setAddress(rs.getString("address"));
		        student.setNotes(rs.getString("notes"));
		        students.add(student);
		    }
		    rs.close();
			statement.close();
			connection.close();
			return students;
	    } catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    }
	}
	public boolean Edit(String Id, String Name,String Address,String Birdthday, String Grade, String Notes) {
		try {
			if(Id==""||Name==""||Address==""||Birdthday==""||Grade=="") {
				return false;
			}
			PreparedStatement stm = connection.prepareStatement("UPDATE SYS.STUDENT SET Name=?, Address=?, Birthday=TO_DATE(?,'YYYY-MM-DD'), Grade=TO_NUMBER(?), Notes=? WHERE Id=TO_NUMBER(?)");
			stm.setString(1, Name);
			stm.setString(2, Address);
			stm.setString(3, Birdthday);
			stm.setString(4, Grade);
			stm.setString(5, Notes);
			stm.setString(6, Id);
			ResultSet rs = stm.executeQuery();
			boolean flag = false;
			if(rs.next()) flag = true;
			rs.close();
			stm.close();
			connection.close();
			return flag;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(String sId) {
		try {		
			PreparedStatement stm = connection.prepareStatement("DELETE FROM SYS.STUDENT WHERE Id=TO_NUMBER(?)");
			stm.setString(1, sId);
			ResultSet rs = stm.executeQuery();
			boolean flag = false;
			if(rs.next()) flag = true;
			rs.close();
			stm.close();
			connection.close();
			return flag;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
