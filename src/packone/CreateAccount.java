package packone;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/createAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
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
		String accountNumber,cif,name,fatherName,email,phone,aadhaarNumber,PANNumbar,accountType,line1,line2,city,state,zipcode;
		name=request.getParameter("name").trim();
		fatherName=request.getParameter("fatherName").trim();
		email=request.getParameter("email").trim();
		phone=request.getParameter("phone").trim();
		aadhaarNumber=request.getParameter("aadhaarNumber").trim();
		PANNumbar=request.getParameter("panNumber").trim();
		PANNumbar=PANNumbar==null?"null":PANNumbar;
		accountType=request.getParameter("accountType").trim();
		line1=request.getParameter("line1").trim();
		line2=request.getParameter("line2").trim();
		city=request.getParameter("city").trim();
		state=request.getParameter("state").trim();
		zipcode=request.getParameter("zipcode").trim();
		if (Uses.isEmailAlreadyAvailable(email)) {
			String error = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
					+ "<strong>WARNING!</strong> Account not created...Mail id " + email
					+ " is already registred with some account.</div>";

			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("createAccount.jsp");
			rd.include(request, response);
			return;
		}
		if (Uses.isAadhaarAlreadyAvailable(aadhaarNumber)) {
			String error = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
					+ "<strong>WARNING!</strong> Account not created...Aadhaar numbar " + aadhaarNumber
					+ " is already registred  with some account.</div>";

			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("createAccount.jsp");
			rd.include(request, response);
			return;
		}
		accountNumber=Uses.tenDigit();
		boolean b=Uses.checkAccountNumber(accountNumber);
		while(!b) {
			accountNumber=Uses.tenDigit();
			b=Uses.checkAccountNumber(accountNumber);
		}
		cif=Uses.tenDigit();
		 b=Uses.checkcif(accountNumber);
		while(!b) {
			cif=Uses.tenDigit();
			b=Uses.checkcif(accountNumber);
		}
		Connection connection=Uses.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, cif);
			ps.setString(2, accountNumber);
			ps.setString(3, name);
			ps.setString(4, fatherName);
			ps.setInt(5, 0);
			ps.setString(6, PANNumbar);
			ps.setString(7, aadhaarNumber);
			ps.setString(8, email);
			ps.setString(9, phone);
			ps.setString(10,accountType);
			ps.setString(11, zipcode);
			ps.execute();
			String error = "<div class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
					+ "<strong>Success!</strong> Account created successfully... Account number is "+accountNumber+" and CIF number is "+cif+".</div>";

			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("createAccount.jsp");
			rd.include(request, response);
		} catch (Exception e) {
			String error = "<div class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button>"
					+ "<strong>WARNING!</strong> Somethigs Went worng try after some time.</div>";

			request.setAttribute("error", error);
			RequestDispatcher rd = request.getRequestDispatcher("createAccount.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
