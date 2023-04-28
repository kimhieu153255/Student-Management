package student;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

public class CourseOfStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String Year = req.getParameter("Year");
		String StudentId = req.getParameter("StudentId");
		if(Year!=null&&StudentId!=null) {
			doPost(req, res);
			return;
		}
		req.setAttribute("courses", null);
		req.getRequestDispatcher("CourseListOfStudent.jsp").forward(req, res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String Year = req.getParameter("Year");
		String StudentId = req.getParameter("StudentId");
		if(Year==""&&StudentId=="") {
			req.setAttribute("error", "Please fill out all fields!");
			req.getRequestDispatcher("CourseListOfStudent.jsp").forward(req, res);
			return;
		}
		CourseModel model = new CourseModel();
		List<Course> courses = model.searchBySId(StudentId,Year);
		if(courses==null||courses.size()==0) {
			req.setAttribute("error", "Student doesn't have any courses in this year!!");
			req.getRequestDispatcher("CourseListOfStudent.jsp").forward(req, res);
			return;
		}
		SortModel  compare = new SortModel();
		String sort = req.getParameter("sort");
		if(sort!=null&&sort.equals("asc"))
	    	Collections.sort(courses,compare.AscNameCourse());
	    else Collections.sort(courses,compare.DescNameCourse());
		req.setAttribute("courses", courses);
		req.setAttribute("Year", Year);
		req.setAttribute("StudentId", StudentId);
		req.getRequestDispatcher("CourseListOfStudent.jsp").forward(req, res);
	}

}
