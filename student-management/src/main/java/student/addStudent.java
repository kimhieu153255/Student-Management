package student;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentModel;

@WebServlet(name="AddStudentServlet",value="/add-student")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		req.setAttribute("error", null);
		RequestDispatcher dispatcher = req.getRequestDispatcher("addStudent.jsp");
		dispatcher.forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String Name = req.getParameter("Name");
		String Address = req.getParameter("Address");
		String Birdthday = req.getParameter("Birdthday");
		String Grade = req.getParameter("Grade");
		String Notes = req.getParameter("Notes");

		StudentModel model = new StudentModel();
		boolean result = model.insert(Name, Grade, Birdthday, Address, Notes);
		if(result)
			res.sendRedirect("home");
		else
		{
			req.setAttribute("error", "Can't insert!!");
			req.getRequestDispatcher("addStudent.jsp").forward(req, res);
		}
	}
}
