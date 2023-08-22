package listenpack;

import java.sql.Connection;
import java.sql.*;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Mylistener
 *
 */
@WebListener
public class Mylistener implements ServletContextListener {

	Connection con;
    public Mylistener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	
    	try 
    	{
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		
    		
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sam?userSSL=false","root","nitr@123");
    		 
    			ServletContext context = sce.getServletContext();
    			
    			context.setAttribute("connect",con);
                
                PreparedStatement ps = con.prepareStatement("create table emplogs (name char(30),password char(10))");
                
                ps.executeUpdate();
                
    	}catch(ClassNotFoundException e) 
    	{
    	e.printStackTrace();
    	}catch(SQLException e) {
    		e.printStackTrace();
         }
    	
    	
    }
}
