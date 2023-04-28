package student;

import java.util.*;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

@WebServlet(name="AddStudentServlet",value="/add-student")
public class deleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String[] selectedIds = req.getParameterValues("selectedIds");
		List<String> listError = new ArrayList<>();
		if (selectedIds != null) {
		    for (String sId : selectedIds) {
		    	StudentModel model = new StudentModel();
		    	ScoreModel modelScore = new ScoreModel();
		    	modelScore.deleteBySId(sId);
		        boolean result = model.delete(sId);
		        if(result==false) {
		        	listError.add("Can't delete student "+sId);
		        	req.setAttribute("Errors", listError);
			    	req.getRequestDispatcher("home.jsp").forward(req, res);
		        }
		    }
		    if(listError.size()==0) 
		    	res.sendRedirect("home");
		}
		else {
			req.setAttribute("Errors", "Unselected Students!!");
			res.sendRedirect("home");
		}
	}
}
