package student;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Course;
import model.ScoreModel;

public class ScoreStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		req.setAttribute("scores", null);
		req.getRequestDispatcher("ScoreStudent.jsp").forward(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		String Year = req.getParameter("Year");
		String StudentId = req.getParameter("StudentId");
		System.out.println(Year+StudentId);
		if(Year==""&&StudentId=="") {
			req.setAttribute("error", "Please fill out all fields!");
			req.getRequestDispatcher("ScoreStudent.jsp").forward(req, res);
			return;
		}
		ScoreModel model = new ScoreModel();
		List<Course> courses = model.searchScore(StudentId,Year);
		if(courses==null||courses.size()==0) {
			req.setAttribute("error", "Student doesn't have any courses in this year!!");
			req.getRequestDispatcher("ScoreStudent.jsp").forward(req, res);
			return;
		}
		req.setAttribute("scores", courses);
		req.setAttribute("Year", Year);
		req.setAttribute("StudentId", StudentId);
		req.getRequestDispatcher("ScoreStudent.jsp").forward(req, res);
	}
}
