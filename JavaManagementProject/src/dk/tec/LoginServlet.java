package dk.tec;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        PrintWriter out = response.getWriter();
        out.println("<font color=red>Please make sure you enter the right UserID/Pass");
        rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
		String user = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
 
        if (dbTools.checkUser(user, password)) {
            Cookie loginCookie = new Cookie("loginUser", user);
            // setting cookie to expiry in 60 mins
            loginCookie.setMaxAge(60 * 60);
            response.addCookie(loginCookie);
            response.sendRedirect("./jsps/index.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("./jsps/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Please make sure you enter the right UserID/Pass");
            rd.include(request, response);
        }
	}
}
