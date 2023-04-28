package student;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;


@WebServlet(name = "homeServlet", value = "/home")
public class studentList extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	StudentModel model = new StudentModel();
    List<Student> students = model.getAllStudents();
    String sort = req.getParameter("sort");
    String Name = req.getParameter("name");
    SortModel compare = new SortModel();
    if(sort!=null&&Name!=null)
	    if(sort.equals("asc")&&Name.equals("True")) 
	        Collections.sort(students, compare.AscNameStudent());
	    else if(sort.equals("desc")&&Name.equals("True"))
	    	Collections.sort(students,compare.DescNameStudent());
	    else if(sort.equals("asc")&&Name.equals("False"))
	    	Collections.sort(students,compare.AscGrade());
	    else if(sort.equals("desc")&&Name.equals("False"))
	    	Collections.sort(students,compare.DescGrade());
    req.setAttribute("students", students);
    req.setAttribute("Errors", null);
    RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
    dispatcher.forward(req, res);
  }
}
