package course;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

public class courseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CourseModel model = new CourseModel();
	    List<Course> courses = model.getAll();
	    String sort = req.getParameter("sort");
	    SortModel compare = new SortModel();
	    if(sort!=null&&sort.equals("asc"))
	    	Collections.sort(courses,compare.AscNameCourse());
	    else Collections.sort(courses,compare.DescNameCourse());
	    	
	    req.setAttribute("courses", courses);
	    req.setAttribute("Errors", null);
	    RequestDispatcher dispatcher = req.getRequestDispatcher("courseList.jsp");
	    dispatcher.forward(req, res);
	}
}
