package dk.tec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateDeviceServlet
 */
@WebServlet("/CreateDeviceServlet")
public class CreateDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDeviceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Device d = new Device();
		d.setBrandStr(request.getParameter("deviceBrand"));
		d.setModelStr(request.getParameter("model"));
		d.setRoomLocationStr(request.getParameter("roomLocation"));
		d.setDeviceTypeStr(request.getParameter("deviceType"));
		
		dbTools.insertDevice(d);
		
		response.sendRedirect("./jsps/device.jsp");
	}

}
