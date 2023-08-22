package listenpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.*;



/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int status=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("tex/html");
		PrintWriter out = response.getWriter();
	     String name = request.getParameter("username");
	     String password = request.getParameter("password");
		ServletContext context = getServletContext();
		
		try {
		Connection con = (Connection)context.getAttribute("connect");
		PreparedStatement pu = con.prepareStatement("insert into emplogs (name char(30),password char(10))value(?,?)");
		
		pu.setString(1, name);

		pu.setString(2, password);
		
		int status =pu.executeUpdate();
		
		}catch(Exception e)
		
		{
			e.printStackTrace();
		}
		if(status>0)
		{
			out.println(" value inserted");
			
		}
		else
		{
			out.println(" Check Your Code");

		}
	} 

}
