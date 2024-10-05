package in.cutm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.cutm.dao.StudentDao;
import in.cutm.dbConnection.ConnectDB;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		StudentDao dao = new StudentDao(ConnectDB.dbconnect());
		
		boolean isStudentDelete = dao.isDeleteStudent(id);
		
		javax.servlet.http.HttpSession session =  req.getSession();
		if (isStudentDelete) {
			session.setAttribute("deleteStudentMsg", "Student deleted successfully....");
			resp.sendRedirect("allStudent.jsp");
		} else {
			session.setAttribute("deleteStudentError", "Student deletion fail due to server problem.....");
			resp.sendRedirect("allStudent.jsp");
		}
	}
}
