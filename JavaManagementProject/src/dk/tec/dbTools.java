package dk.tec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dbTools {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static void main(String[] args) {
		System.out.println(checkUser("rkr", "password"));
	}

	private static String conStr = "jdbc:sqlserver://localhost:1433; databasename=JAVAOPGAVE; User=sa; Password=1234";

	public static void insertDevice(Device d) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(conStr);
			stmt = con.createStatement();

			stmt.executeUpdate("Insert into Devices (brand, model, roomLocation, deviceType) values " + "('"
					+ d.getBrandStr() + "','" + d.getModelStr() + "','" + d.getRoomLocationStr() + "','"
					+ d.getDeviceTypeStr() + "')");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void searchDevices(String s, String c) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(conStr);
			stmt = con.createStatement();

			rs = stmt.executeQuery("Select * from Devices where " + s + " = '" + c + "'");
			ResultSetMetaData rsmd = rs.getMetaData();
			// querying SELECT * FROM XXX
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(rsmd.getColumnName(i) + " " + columnValue);
				}
				System.out.println("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void listAllDevices() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(conStr);
			stmt = con.createStatement();

			rs = stmt.executeQuery("Select * from Devices");
			ResultSetMetaData rsmd = rs.getMetaData();
			// querying SELECT * FROM XXX
			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					if (i > 1)
						System.out.print(",  ");
					String columnValue = rs.getString(i);
					System.out.print(columnValue + " " + rsmd.getColumnName(i));
				}
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void insertTaskIntoDB(Task t) {
		try {

			con = DriverManager.getConnection(conStr);
			stmt = con.createStatement();

			String queryString = String.format(
					"Insert into tasks(taskName,taskDescription, taskImage, roomLocation, createdBy, completedBy, dateDone, dateCreated, deadlineDate)"
							+ " values ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
					t.getTaskName(), t.getTaskDescription(), t.getTaskImage(), t.getRoomLocation(), t.getCreatedBy(),
					t.getCompletedBy(), t.getCompletedDate(), t.getCreateDate(), t.getDeadlineDate());

			int updateSuccess = stmt.executeUpdate(queryString);
			if (updateSuccess > 0) {
				System.out.println("Succesfully updated " + updateSuccess + " rows");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	// ------------------ Task dbTools ------------------

	/**
	 * 
	 * @param search
	 *            search for the "where taskName = search"
	 * @return The top task found during search
	 * 
	 */
	public static Task selectTaskFromDB(Task t, String search) {

		try {
			Connection con = DriverManager.getConnection(conStr);
			Statement stmt = con.createStatement();

			String sQuery = "Select TOP 1 * FROM tasks WHERE taskName ='" + search + "'";
			ResultSet rs = stmt.executeQuery(sQuery);

			while (rs.next()) {
				t = fillClassWithDataResult(rs, t);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		}

		return t;
	}

	/**
	 * 
	 * @param search
	 *            search for the "where column = search"
	 * @param column
	 *            search for the "where column = search"
	 * @return The top task found during search
	 * 
	 */
	public static Task selectTaskFromDB(Task t, String search, String column) {

		try {

			Connection con = DriverManager.getConnection(conStr);
			Statement stmt = con.createStatement();

			String sQuery = "Select TOP 1 * from Tasks WHERE " + column + " ='" + search + "'";
			ResultSet rs = stmt.executeQuery(sQuery);

			while (rs.next()) {
				t = fillClassWithDataResult(rs, t);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return t;
	}

	public static List<Task> returnList() throws SQLException {

		List<Task> tasks = new ArrayList<Task>();
		Task t = new Task();
		try {
			con = DriverManager.getConnection(conStr);
			stmt = con.createStatement();

			String sQuery = "Select * FROM tasks";
			rs = stmt.executeQuery(sQuery);

			while (rs.next()) {
				t = fillClassWithDataResult(rs, t);
				tasks.add(t);
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ignore) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ignore) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ignore) {
				}
		}

		return tasks;

	}

	private static Task fillClassWithDataResult(ResultSet rs, Task t) {
		try {
			t.setTaskName(rs.getString("taskName"));
			t.setTaskDescription(rs.getString("taskDescription"));
			t.setTaskImage(rs.getString("taskImage"));
			t.setCreatedBy(rs.getString("createdBy"));
			t.setCreateDate(rs.getLong("dateCreated"));
			t.setRoomLocation(rs.getString("roomLocatioN"));
			t.setDeadlineDate(rs.getLong("deadlineDate"));
			t.setCompletedDate(rs.getLong("dateDone"));
			t.setCompletedBy(rs.getString("completedBy"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return t;
	}

	public static boolean checkUser(String u, String p) {
		boolean ok = false;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(conStr);
			Statement stmt = con.createStatement();

			String sQuery = "Select  * from userDB WHERE userName ='" + u + "'";
			ResultSet rs = stmt.executeQuery(sQuery);

			while (rs.next()) {
				if (p.equals(rs.getString("userPassword")))
					ok = true;
			}
		}

		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ok;

	}

	public static List<Device> deviceList() throws SQLException {
		List<Device> list = new ArrayList<Device>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(conStr);
			stmt = con.createStatement();

			rs = stmt.executeQuery("Select * from Devices");
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				list.add(fillDeviceWithDataResult(rs));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ignore) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ignore) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ignore) {
				}
		}

		return list;
	}

	private static Device fillDeviceWithDataResult(ResultSet rs) {
		Device d = new Device();
		try {
			d.setBrandStr(rs.getString("brand"));
			d.setDeviceTypeStr(rs.getString("deviceType"));
			d.setModelStr(rs.getString("model"));
			d.setRoomLocationStr(rs.getString("roomLocation"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return d;
	}

}
