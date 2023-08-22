package listenpack;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    ServletContext Context = null;
    
    static int total =0,current =0;
	
	
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
      
    	total++;
    	current++;
    	Context = se.getSession().getServletContext();
    	Context.setAttribute("totalusers", total);
    	Context.setAttribute("currentusers", current);
    	
    	
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	
    	current--;
    	
    	Context.setAttribute("currentusers", current);
    	
    }
	
}
