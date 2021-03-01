package packone;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Map<Integer, Person> map= new TreeMap<Integer,Person>();
			Connection connection=DriverManager.getConnection("jdbc:mysql:///learn?user=root&password=");
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from mock");
			while (rs.next()) {
				int id=rs.getInt(2);
				String name=rs.getString(1);
				String email=rs.getString(3);
				String password=rs.getString(4);
				map.put(id, new Person(id, name, email, password));
			}
			HttpSession session=request.getSession();
			session.setAttribute("list", map);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("pagenation");
			requestDispatcher.include(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
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
