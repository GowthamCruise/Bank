package packone;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class AddMoney
 */
@WebServlet("/addMoney")
public class AddMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMoney() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("eid")==null){
			response.sendRedirect("index.jsp");
		}
		
		long amount=Long.parseLong(request.getParameter("amount"));
		String error, accountNumber=request.getParameter("accountNumber");
		error=null;
		if (Uses.checkAccountNumber(accountNumber)) {
			 error = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
					+ "<strong>WARNING!</strong> Unable to find account  " + accountNumber 
					+ " .</div>";

			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("addMoney.jsp");
			rd.include(request, response);
			return;
		}
		long currentBalance=Uses.getBalance(accountNumber);
		long newBalance=currentBalance+amount;
		Connection connection=Uses.getConnection();
		try {
			Statement st=connection.createStatement();
			st.executeUpdate("update userinfo set balance="+newBalance+" where accountNumber="+accountNumber+" ;");
			String q="insert into transaction values("+Uses.generateTransactionId()+","+accountNumber+",'credit',"+amount+",CURRENT_TIMESTAMP,'Amount credited via bank' ) ";
			st.execute(q);
			 error = "<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
						+ "<strong>SUCCESS!</strong> Amount added successfully ... new balance is " + newBalance 
						+ " .</div>";

				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("addMoney.jsp");
				rd.include(request, response);
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//response.getWriter().append("Served at: " +request.getParameter("accountNumber")+" "+request.getParameter("amount")).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
