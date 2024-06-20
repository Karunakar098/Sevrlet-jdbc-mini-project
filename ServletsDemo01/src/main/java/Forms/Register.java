package Forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String roll = req.getParameter("roll");
		String course = req.getParameter("course");
		PrintWriter pw = resp.getWriter();

		try {
			Connection con = DbConnection.connect();
			PreparedStatement pst = con.prepareStatement("insert into register values(?,?,?)");
			pst.setString(1, name);
			pst.setInt(2, Integer.parseInt(roll));
			pst.setString(3, course);
			int x = pst.executeUpdate();
			pw.println(x + " row inserted  successfully");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
