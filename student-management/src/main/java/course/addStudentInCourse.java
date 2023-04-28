package course;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ScoreModel;

public class addStudentInCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String Id = req.getParameter("CourseId");
		req.setAttribute("CourseId", Id);
		req.getRequestDispatcher("addStudentInCourse.jsp").forward(req, res);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String cId = req.getParameter("CourseId");
		String sId = req.getParameter("Id");
		String score = req.getParameter("Score");
		if(score=="") score = null;
		ScoreModel model = new ScoreModel();
		boolean result = model.insert(sId, cId, score);
		if(result) {
			res.sendRedirect("course-student?CourseId="+cId);
			return;
		}else {
			req.setAttribute("CourseId", cId);
			req.setAttribute("error", "Can't add student to course!!");
			req.getRequestDispatcher("addStudenInCourse.jsp").forward(req, res);
		}
	}
}
