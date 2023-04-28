package course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CourseModel;
import model.ScoreModel;

public class deleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String[] selectedIds = req.getParameterValues("selectedIds");
		List<String> listError = new ArrayList<>();
		if (selectedIds != null) {
		    for (String cId : selectedIds) {
		    	CourseModel model = new CourseModel();
		    	ScoreModel modelScore = new ScoreModel();
		    	modelScore.deleteByCId(cId);
		        boolean result = model.delete(cId);
		        if(result==false) {
		        	listError.add("Can't delete Course " + cId);
		        	req.setAttribute("Errors", "SUCCESS!");
			    	req.getRequestDispatcher("courseList.jsp").forward(req, res);
		        }
		    }
		    if(listError.size()==0) 
		    	res.sendRedirect("course-list");
		}
		else {
			req.setAttribute("Errors", "Unselected Course!!");
			res.sendRedirect("course-list");
		}
	}

}
