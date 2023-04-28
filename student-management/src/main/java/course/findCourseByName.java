package course;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

public class findCourseByName extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		String CourseName = req.getParameter("CourseName");
		if(CourseName!=""&&CourseName!=null) {
			CourseModel model = new CourseModel();
			List<Course> list = model.searchCourses(CourseName);
			if(list==null||list.size()==0) {
				req.setAttribute("courses", null);
				req.setAttribute("error", "Course isn't exists!!");
				req.getRequestDispatcher("findCourseByName.jsp").forward(req, res);
				return;
			}
			String sort = req.getParameter("sort");
		    String Name = req.getParameter("name");
		    SortModel compare = new SortModel();
		    if(sort!=null&&Name!=null)
			    if(sort.equals("asc")&&Name.equals("True")) 
			        Collections.sort(list, compare.AscNameCourse());
			    else Collections.sort(list,compare.DescNameCourse());
		    req.setAttribute("CourseName",CourseName);
			req.setAttribute("courses", list);
			req.setAttribute("error", null);
			req.getRequestDispatcher("findCourseByName.jsp").forward(req, res);
			return;
		}
		req.getRequestDispatcher("findCourseByName.jsp").forward(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		doGet(req, res);
	}
}
