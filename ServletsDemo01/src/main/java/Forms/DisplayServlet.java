package Forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/display")
public class DisplayServlet extends HttpServlet{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			resp.setContentType("text/html");
			Connection con = DbConnection.connect();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from register");
			PrintWriter pw=resp.getWriter();
			pw.print("<h2>myData<h2>");
			pw.print("<html><head><link rel=\"stylesheet\" type=\"text/css\" href= \"style.css\"</head>");
			pw.print("<body><table border=1>");
			pw.print("<tr><th>Name</th><th>Roll</th><th>Course</th></tr>");
			while(rs.next()) {
				pw.print("<tr>");
				pw.print("<td>"+rs.getString(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("</tr>");
			}
				pw.print("</table></body></html>");	
			
			
					
		}
		catch(Exception e) {
			System.out.println(e);
		}

}
}
