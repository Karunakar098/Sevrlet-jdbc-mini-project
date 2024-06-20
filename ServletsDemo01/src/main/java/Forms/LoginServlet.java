package Forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		PrintWriter pw = resp.getWriter();
		try {
			Connection con = DbConnection.connect();
			PreparedStatement pst = con.prepareStatement("select *from register where name=? and roll=?");
			pst.setString(1, uname);
			pst.setInt(2, Integer.parseInt(pwd));
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				pw.print("valid login details");
			} else {
				pw.print("invalid login details");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
