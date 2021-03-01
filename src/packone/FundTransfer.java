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

@WebServlet("/FundTransfer")
public class FundTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("cif")==null){
			response.sendRedirect("index.jsp");
		}
		String ifsc,senderacountNumber,reciveraccountNumber=request.getParameter("anum");
		String accountNumber=(String) session.getAttribute("accountNumber");
		senderacountNumber=request.getParameter("anum");
		long amount=Long.parseLong(request.getParameter("amount"));
		if(accountNumber.equals(senderacountNumber)) {
			String error = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
					+ "<strong>WARNING!</strong> Invalid Account Number </div>";

			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("fundTransfer.jsp");
			rd.include(request, response);
			return;
		}
		long currentBalance=Uses.getBalance(accountNumber);
		long reciverCurrentBalance=Uses.getBalance(reciveraccountNumber);
		if (amount>currentBalance) {
			 String error = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
					+ "<strong>WARNING!</strong> Unable to process request due to insufficient fund  " 
					+ " .</div>";

			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("fundTransfer.jsp");
			rd.include(request, response);
			return;
		}
		ifsc=request.getParameter("ifsc");
		if(!ifsc.equals("YBIB000T150") || Uses.checkAccountNumber(reciveraccountNumber)) {
			 String error = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
						+ "<strong>WARNING!</strong> Unable To Find Account With Given Information " 
						+ " .</div>";

				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("fundTransfer.jsp");
				rd.include(request, response);
				return;
		}
		String cif=(String) session.getAttribute("cif");
		String tpin=request.getParameter("tpin");
		String otpin=Uses.getotpin(cif);
		if(!tpin.equals(otpin)) {
			 String error = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
						+ "<strong>WARNING!</strong> Incorrect Transaction Pin " 
						+ " .</div>";

				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("fundTransfer.jsp");
				rd.include(request, response);
				return;
		}
		//statrt 
		long newBalance =currentBalance-amount;
		long newReciverBalance=Uses.getBalance(reciveraccountNumber) +amount;
		Connection connection=Uses.getConnection();
		try {
			Statement st=connection.createStatement();
			st.executeUpdate("update userinfo set balance="+newBalance+" where accountNumber="+accountNumber+" ;");
			String q="insert into transaction values("+Uses.generateTransactionId()+","+accountNumber+",'Debit',"+amount+",CURRENT_TIMESTAMP,'Amount debited for Fund transfer' ) ";
			st.execute(q);

			st.executeUpdate("update userinfo set balance="+newReciverBalance+" where accountNumber="+reciveraccountNumber+" ;");
			q="insert into transaction values("+Uses.generateTransactionId()+","+reciveraccountNumber+",'Credit',"+amount+",CURRENT_TIMESTAMP,'Amount credited by Fund transfer' ) ";
			st.execute(q);
			
			 String error = "<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
						+ "<strong>SUCCESS!</strong> Amount Transfered successfully ... new balance is " + newBalance 
						+ " .</div>";

				request.setAttribute("error", error);
				RequestDispatcher rd = request.getRequestDispatcher("fundTransfer.jsp");
				rd.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
