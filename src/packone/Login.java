package packone;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cif=request.getParameter("cif");
		String Password=request.getParameter("password");
		String userType=null;
		CallableStatement cs=Uses.loginProcedure();
		HttpSession session=request.getSession();
		try {
			cs.setString(1, cif);
			cs.setString(2, Password);
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.execute();
			userType=cs.getString(3);	
		} catch (SQLException e) {e.printStackTrace();}
		if (userType==null){
			PrintWriter pw=response.getWriter();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Invalid user or password');");
			pw.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			return;
		}
		if (userType.equalsIgnoreCase("user")) {
			session.setAttribute("cif",cif) ;
			session.removeAttribute("eid");
		}else {
			 session.setAttribute("eid",cif);
			 session.removeAttribute("cif");
		}
		if (userType.equalsIgnoreCase("user")) {
			try {
				Connection connection=Uses.getConnection();
				Statement statement=connection.createStatement();
				ResultSet rs=statement.executeQuery("select * from userinfo where cif="+cif);
				while (rs.next()) {
					session.setAttribute("name",rs.getString(3));
					session.setAttribute("fatherName",rs.getString(4));
					session.setAttribute("email",rs.getString(8));	
					session.setAttribute("phone",rs.getString(9));
					session.setAttribute("accountNumber",rs.getString(2));
					session.setAttribute("PANNumber",rs.getString(6));
					session.setAttribute("balance",rs.getString(5));
					session.setAttribute("aadhaarNumber",rs.getString(7));
					session.setAttribute("IFSCCode","YBIB000T150");
					session.setAttribute("accountType",rs.getString(10));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		RequestDispatcher rd=userType.equalsIgnoreCase("user")?request.getRequestDispatcher("home.jsp"):request.getRequestDispatcher("employeeHome.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
