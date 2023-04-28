package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreModel {
	private Connection connection;
	public ScoreModel() {
		initDB init = new initDB();
		connection = init.getConnection();
	}
	public boolean delete(String sId, String cId) {
		try {		
			PreparedStatement stm = connection.prepareStatement("DELETE FROM SYS.SCORE_BOARD WHERE STUDENT_ID=TO_NUMBER(?) and COURSE_ID=TO_NUMBER(?)");
			stm.setString(1, sId);
			stm.setString(2, cId);
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
	public boolean deleteBySId(String sId) {
		try {		
			PreparedStatement stm = connection.prepareStatement("DELETE FROM SYS.SCORE_BOARD WHERE STUDENT_ID=TO_NUMBER(?)");
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
	public boolean deleteByCId(String cId) {
		try {		
			PreparedStatement stm = connection.prepareStatement("DELETE FROM SYS.SCORE_BOARD WHERE COURSE_ID=TO_NUMBER(?)");
			stm.setString(1, cId);
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
	public boolean insert(String sId,String cId,String score) {
		try {
			if(cId==""||sId=="") 
				return false;
			PreparedStatement stm = connection.prepareStatement("INSERT INTO SYS.SCORE_BOARD VALUES(TO_NUMBER(?),TO_NUMBER(?),TO_NUMBER(?))");
			stm.setString(1, sId);
			stm.setString(2, cId);
			stm.setString(3, score);
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
	public List<Course> searchScore(String sId,String year) {
		try {
			PreparedStatement stm = connection.prepareStatement("select c.id, b.score, c.name, c.lecturer, c.notes "
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
		        course.setYear(rs.getFloat("score"));
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
}
