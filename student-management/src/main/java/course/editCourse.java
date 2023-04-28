package course;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CourseModel;

public class editCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String Name = req.getParameter("Name");
		String Lecturer = req.getParameter("Lecturer");
		String Year = req.getParameter("Year");
		String Notes = req.getParameter("Notes");
		String Id = req.getParameter("Id");
		CourseModel  model = new CourseModel();
		boolean result = model.Edit(Id, Name, Lecturer, Year, Notes);
		if(result)
			res.sendRedirect("course-list");
		else
		{
			req.setAttribute("error", "Can't update!!");
			req.getRequestDispatcher("editCourse.jsp").forward(req, res);
		}
	}
}
