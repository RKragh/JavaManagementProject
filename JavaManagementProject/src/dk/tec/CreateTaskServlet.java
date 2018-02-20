package dk.tec;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateTaskServlet
 */
@WebServlet("/CreateTaskServlet")
public class CreateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTaskServlet() {
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
		Task t = new Task();
		t.setTaskName(request.getParameter("taskName"));
		t.setTaskDescription(request.getParameter("taskDescription"));
		t.setRoomLocation(request.getParameter("roomLocation"));
		t.setTaskImage(request.getParameter("taskImage"));
		t.setCreatedBy(request.getParameter("createdBy"));
		t.setCompletedBy(null);
		t.setCompletedDate(null);
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		
		try {
			date = df.parse(request.getParameter("deadlineDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Long deadlineLong = date.getTime();
		t.setDeadlineDate(deadlineLong);
		t.setCreateDate(System.currentTimeMillis());
		
		dbTools.insertTaskIntoDB(t);
		
		response.sendRedirect("./jsps/task.jsp");
	}

}
