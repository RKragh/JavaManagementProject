package dk.tec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateDeviceServlet
 */
@WebServlet("/UpdateDeviceServlet")
public class UpdateDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDeviceServlet() {
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
		if (request.getParameter("btnDelDevice") != null)
		{
			try {
				dbTools.deleteDeviceById(Integer.parseInt(request.getParameter("idOfDevice")));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./jsps/device.jsp");
		}
		else
		{
			Device d = new Device();
			int pId = Integer.parseInt(request.getParameter("pID"));
			d.setBrandStr(request.getParameter("deviceBrand"));
			d.setModelStr(request.getParameter("model"));
			d.setRoomLocationStr(request.getParameter("roomLocation"));
			d.setDeviceTypeStr(request.getParameter("deviceType"));
			
			try {
				dbTools.updateDeviceById(pId, d);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./jsps/device.jsp");
		}

		
		
	}

}
