package student;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

public class findStudentByName extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		String StudentName = req.getParameter("StudentName");
		if(StudentName!=""&&StudentName!=null) {
			StudentModel model = new StudentModel();
			List<Student> list = model.searchName(StudentName);
			if(list==null||list.size()==0) {
				req.setAttribute("Students", null);
				req.setAttribute("error", "Student isn't exists!!");
				req.getRequestDispatcher("findStudentByName.jsp").forward(req, res);
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
		    req.setAttribute("StudentName",StudentName);
			req.setAttribute("Students", list);
			req.setAttribute("error", null);
			req.getRequestDispatcher("findStudentByName.jsp").forward(req, res);
			return;
		}
		req.getRequestDispatcher("findStudentByName.jsp").forward(req, res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		doGet(req, res);
	}
}
