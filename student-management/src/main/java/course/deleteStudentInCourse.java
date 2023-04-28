package course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ScoreModel;

public class deleteStudentInCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		String[] selectedIds = req.getParameterValues("selectedIds");
		String Id = req.getParameter("CourseId");
		List<String> listError = new ArrayList<>();
		if (selectedIds != null) {
		    for (String sId : selectedIds) {
		    	ScoreModel model = new ScoreModel();
		        boolean result = model.delete(sId,Id);
		        if(result==false) {
		        	listError.add("Can't delete student "+sId);
		        }
		    }
		    if(listError.size()==0) 
		    	res.sendRedirect("course-student?Id="+Id);
		}
		else res.sendRedirect("course-student?Id="+Id);
	}
}
