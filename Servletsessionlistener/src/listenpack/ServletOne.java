package listenpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletOne
 */
@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param uname 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, Object uname) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("tex/html");
		 
		 PrintWriter out = response.getWriter();
	     String name = request.getParameter("username");
		 HttpSession session =request.getSession();
		 session.setAttribute("name",uname);
		 ServletContext context = getServletContext();
		 
		 int total= (Integer) context.getAttribute("totalusers");
		 int current= (Integer) context.getAttribute("currentusers");
		out.println("The Total users Visited ="+total+"<br>");
		out.println("The no of current users Visited ="+current+"<br>");
		out.println("<a href ='SecondServlet'> Click Here To Logout</a>");
		out.close();
		
		
	}

}
