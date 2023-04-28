package student;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentModel;

@WebServlet(name="AddStudentServlet",value="/add-student")
public class editStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String Id = req.getParameter("Id");
		String Name = req.getParameter("Name");
		String Address = req.getParameter("Address");
		String Birdthday = req.getParameter("Birdthday");
		String Grade = req.getParameter("Grade");
		String Notes = req.getParameter("Notes");
		StudentModel model = new StudentModel();
		boolean result = model.Edit(Id, Name, Address, Birdthday, Grade, Notes);
		if(result)
			res.sendRedirect("home");
		else
		{
			req.setAttribute("error", "Can't update!!");
			req.getRequestDispatcher("editStudent.jsp").forward(req, res);
		}
	}
}
