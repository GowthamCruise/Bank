package packone;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ChangePin")
public class ChangePin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("cif")==null){
			response.sendRedirect("index.jsp");
		}
		String error,user=null ,oldPin=request.getParameter("oldpin");
		String cif=(String) session.getAttribute("cif");
		String newPassowrd=request.getParameter("newpin");
		CallableStatement cs=Uses.tPinProcedure();
		
		//copy paste
		try {
			cs.setString(1, cif);
			cs.setString(2, oldPin);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.execute();
			user=cs.getString(3);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if (user==null) {
			 error = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
					+ "<strong>WARNING!</strong> Incorrect old Pin </div>";

			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("changePin.jsp");
			rd.include(request, response);
			return;
		}else {
			Connection connection=Uses.getConnection();
			try {
				Statement statement=connection.createStatement();
				String qString="update users set tpin ='"+newPassowrd+"' where id ='"+cif+"';";
				statement.executeUpdate(qString);
				error = "<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
						+ "<strong>SUCCESS!</strong> Pin changed successfully </div>";

				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("changePin.jsp");
				rd.include(request, response);
				return;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
