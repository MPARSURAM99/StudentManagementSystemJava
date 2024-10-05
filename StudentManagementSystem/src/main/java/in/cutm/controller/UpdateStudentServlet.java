package in.cutm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.cutm.dao.StudentDao;
import in.cutm.dbConnection.ConnectDB;
import in.cutm.model.Student;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fullName = req.getParameter("studentName");
		String dob = req.getParameter("studentDob");
		String address = req.getParameter("studentAddress");
		String qualification = req.getParameter("studentQul");
		String email = req.getParameter("studentEmail");
		int id = Integer.parseInt(req.getParameter("id"));
		
		Student student = new Student(id, fullName, dob, address, qualification, email);
		
		StudentDao dao = new StudentDao(ConnectDB.dbconnect());
		
		boolean isStudentUpdate = dao.isUpdateStudent(student);
		
		javax.servlet.http.HttpSession session =  req.getSession(); 
		
		if (isStudentUpdate) {
			session.setAttribute("updateStudentMsg", "Student updated successfully....");
			resp.sendRedirect("allStudent.jsp");
		} else {
			session.setAttribute("updateStudentError", "Student updation fail due to server problem.....");
			resp.sendRedirect("allStudent.jsp");
		}
	}
}
