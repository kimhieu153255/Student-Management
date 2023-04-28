package student;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

@WebServlet(name="SearchStudentServlet",value="/search-student")
public class searchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		req.setAttribute("error", null);
		RequestDispatcher dispatcher = req.getRequestDispatcher("searchStudent.jsp");
		dispatcher.forward(req, res);
	}
		
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		String Id = req.getParameter("Id");
		StudentModel model = new StudentModel();
		Student student = model.search(Id);
		if(student==null) {
			req.setAttribute("error", "Student doesn't exists!!");
			req.getRequestDispatcher("searchStudent.jsp").forward(req, res);
		}
		else {
			req.setAttribute("Student", student);
	        req.setAttribute("error", null);
			req.getRequestDispatcher("editStudent.jsp").forward(req, res);
		}
	}
}
