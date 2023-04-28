package course;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

public class listStudentOfCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		if(req.getParameter("CourseId")!=null) {			
			doPost(req, res);
			return;
		}
		req.setAttribute("Students", null);
		req.setAttribute("error", null);
		req.getRequestDispatcher("searchStudentCourse.jsp").forward(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		String Id = req.getParameter("CourseId");
		CourseModel model = new CourseModel();
		List<Student> list = model.searchStudent(Id);
		if(list.size()==0) {
			req.setAttribute("Students", null);
			req.setAttribute("error", "Course Id not exists!!");
			req.getRequestDispatcher("searchStudentCourse.jsp").forward(req, res);
			return;
		}
		String sort = req.getParameter("sort");
	    String Name = req.getParameter("name");
	    SortModel compare = new SortModel();
	    if(sort!=null&&Name!=null)
		    if(sort.equals("asc")&&Name.equals("True")) 
		        Collections.sort(list, compare.AscNameStudent());
		    else if(sort.equals("desc")&&Name.equals("True"))
		    	Collections.sort(list,compare.DescNameStudent());
		    else if(sort.equals("asc")&&Name.equals("False"))
		    	Collections.sort(list,compare.AscGrade());
		    else if(sort.equals("desc")&&Name.equals("False"))
		    	Collections.sort(list,compare.DescGrade());
		req.setAttribute("Students", list);
		req.setAttribute("CourseId", Id);
		req.setAttribute("error", null);
		req.getRequestDispatcher("searchStudentCourse.jsp").forward(req, res);
	}

}
