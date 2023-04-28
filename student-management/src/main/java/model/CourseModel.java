package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseModel {
	private Connection connection;
	public CourseModel() {
		initDB init = new initDB();
		connection = init.getConnection();
	}
	public List<Course> getAll(){
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM SYS.COURSE");
			ResultSet rs = stm.executeQuery();
			List<Course> list = new ArrayList<>();
			while(rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("Id"));
				course.setName(rs.getString("Name"));
				course.setLecturer(rs.getString("Lecturer"));
				course.setYear(rs.getInt("Year"));
				course.setNotes(rs.getString("Notes"));
				list.add(course);
			}
			rs.close();
			stm.close();
			connection.close();
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insert(String Name,String Lecturer,String Year, String Notes) {
		try {
			if(Name==""||Lecturer==""||Year=="") {
				return false;
			}
			PreparedStatement stm = connection.prepareStatement("INSERT INTO SYS.COURSE VALUES(NULL,?,?,TO_NUMBER(?),?)");
			stm.setString(1, Name);
			stm.setString(2, Lecturer);
			stm.setString(3, Year);
			stm.setString(4, Notes);
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
	
	public Course search(String Id) {
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM SYS.COURSE WHERE Id = TO_NUMBER(?)");
			stm.setString(1, Id);
			ResultSet rs = stm.executeQuery();
			if(rs.next()==false) return null;
			Course course = new Course();
	        course.setId(rs.getInt("id"));
	        course.setName(rs.getString("name"));
	        course.setLecturer(rs.getString("lecturer"));
	        course.setYear(rs.getInt("year"));
	        course.setNotes(rs.getString("notes"));
	        rs.close();
	        stm.close();
	        connection.close();
	        return course;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Course> searchCourses(String Id) {
		try {
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM SYS.COURSE WHERE UPPER(NAME) like '%'||UPPER(?)||'%'");
			stm.setString(1, Id);
			ResultSet rs = stm.executeQuery();
			List<Course> list = new ArrayList<>();
			while(rs.next()) {
				Course course = new Course();
		        course.setId(rs.getInt("id"));
		        course.setName(rs.getString("name"));
		        course.setLecturer(rs.getString("lecturer"));
		        course.setYear(rs.getInt("year"));
		        course.setNotes(rs.getString("notes"));
		        list.add(course);
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
	public List<Course> searchBySId(String sId,String year) {
		try {
			PreparedStatement stm = connection.prepareStatement("select c.id,c.year, c.name, c.lecturer, c.notes "
					+ "from sys.student s, sys.course c, sys.score_board b where s.id=b.student_id and b.course_id = c.id "
					+ "and c.year =TO_NUMBER(?) and s.id=TO_NUMBER(?) ");
			stm.setString(1, year);
			stm.setString(2, sId);
			ResultSet rs = stm.executeQuery();
			List<Course> list = new ArrayList<>();
			while(rs.next()) {
				Course course = new Course();
		        course.setId(rs.getInt("id"));
		        course.setName(rs.getString("name"));
		        course.setLecturer(rs.getString("lecturer"));
		        course.setYear(rs.getInt("year"));
		        course.setNotes(rs.getString("notes"));
		        list.add(course);
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
	public boolean Edit(String Id, String Name,String Lecturer,String Year, String Notes) {
		try {
			if(Id==""||Name==""||Lecturer==""||Year==""||Notes=="") {
				return false;
			}
			PreparedStatement stm = connection.prepareStatement("UPDATE SYS.COURSE SET Name=?, Lecturer=?, Year=TO_NUMBER(?), Notes=? WHERE Id=TO_NUMBER(?)");
			stm.setString(1, Name);
			stm.setString(2, Lecturer);
			stm.setString(3, Year);
			stm.setString(4, Notes);
			stm.setString(5, Id);
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
			PreparedStatement stm = connection.prepareStatement("DELETE FROM SYS.COURSE WHERE Id=TO_NUMBER(?)");
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
	public List<Student> searchStudent(String Id){
		try {		
			PreparedStatement stm = connection.prepareStatement("SELECT S.ID, S.NAME, S.GRADE, S.BIRTHDAY, S.ADDRESS,"
			+ "S.NOTES FROM SYS.STUDENT S, SYS.COURSE C , SYS.SCORE_BOARD B WHERE S.ID = B.STUDENT_ID AND B.COURSE_ID = C.ID AND C.ID = TO_NUMBER(?)");
			stm.setString(1, Id);
			ResultSet rs = stm.executeQuery();
			List<Student> list = new ArrayList<>();
			while(rs.next()) {
				int ID = rs.getInt("ID");
				String Name = rs.getString("NAME");
				int Grade = rs.getInt("GRADE");
				Date Birthday = rs.getDate("BIRTHDAY");
				String Address = rs.getString("ADDRESS");
				String Notes = rs.getString("NOTES");
				Student student = new Student(ID, Name, Grade, Birthday, Address, Notes);
				list.add(student);
			}
			rs.close();
			stm.close();
			connection.close();
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
