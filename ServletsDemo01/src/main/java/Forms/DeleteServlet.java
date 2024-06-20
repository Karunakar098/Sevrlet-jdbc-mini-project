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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String roll = req.getParameter("roll");
		PrintWriter pw = resp.getWriter();
		int r = Integer.parseInt(roll);
		try {
			Connection con = DbConnection.connect();
			PreparedStatement pst = con.prepareStatement("delete from register where roll=?");
			pst.setInt(1, r);
			int x = pst.executeUpdate();
			if (x > 0) {
				pw.print(x + " data deleted successfully");
			} else {
				pw.print("data not found");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
