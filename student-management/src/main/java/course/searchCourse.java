package course;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

public class searchCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		req.setAttribute("error", null);
		RequestDispatcher dispatcher = req.getRequestDispatcher("searchCourse.jsp");
		dispatcher.forward(req, res);
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		String Id = req.getParameter("Id");
		CourseModel model = new CourseModel();
		Course course = model.search(Id);
		if(course==null) {
			req.setAttribute("error", "Course doesn't exists!!");
			req.getRequestDispatcher("searchCourse.jsp").forward(req, res);
		}
		else {
			req.setAttribute("Course", course);
	        req.setAttribute("error", null);
			req.getRequestDispatcher("editCourse.jsp").forward(req, res);
		}
	}
}
