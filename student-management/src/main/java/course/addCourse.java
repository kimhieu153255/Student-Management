package course;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CourseModel;

public class addCourse extends HttpServlet {
	public static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		req.setAttribute("error", null);
		req.getRequestDispatcher("addCourse.jsp").forward(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		try {
			String Name = req.getParameter("Name");
			String Lecturer = req.getParameter("Lecturer");
			String Year = req.getParameter("Year");
			String Notes = req.getParameter("Notes");
			CourseModel  model = new CourseModel();
			boolean result = model.insert(Name, Lecturer, Year, Notes);
			if(result)	
				res.sendRedirect("course-list");
			else {
				req.setAttribute("error", "Can't insert!!");
				req.getRequestDispatcher("addCourse.jsp").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error of Oracle!!");
			req.getRequestDispatcher("addCourse.jsp").forward(req, res);
		}
	}
}
