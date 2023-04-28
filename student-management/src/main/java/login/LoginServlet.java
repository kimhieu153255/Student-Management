package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet",value="/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {    
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "153255");
      String username = request.getParameter("Username");
      String password = request.getParameter("Password");
      PreparedStatement preparedStatement = connection
          .prepareStatement("SELECT * FROM sys.USERADMIN WHERE username=? AND password=?");
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        response.sendRedirect("home");
      } else {
        response.sendRedirect("failure.jsp");
      }
      result.close();
      preparedStatement.close();
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
