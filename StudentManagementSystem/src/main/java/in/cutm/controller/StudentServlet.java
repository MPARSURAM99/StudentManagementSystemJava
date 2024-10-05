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

@SuppressWarnings("serial")
@WebServlet("/register")
public class StudentServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Get the name attribute and store it inside a variable of same data kind;
		String fullName = req.getParameter("studentName");
		String dob = req.getParameter("studentDob");
		String address = req.getParameter("studentAddress");
		String qualification = req.getParameter("studentQul");
		String email = req.getParameter("studentEmail");
		
		
		
		
//		Create an object of student class and and pass the corresponding variables;
		Student student = new Student(fullName, dob, address, qualification, email); // Now the student object property is set;

//		Then create a student dao class. Go to dao;
		
//		Create a dao class object by the constructor method and pass the connection method of connection class;
		StudentDao dao = new StudentDao(ConnectDB.dbconnect());
		
//		Then check dao object can return the true or false & store it inside a variable;
		boolean studentAdded = dao.isStudentAdded(student);
		
//		According to the variable write your corresponding code;
		
		javax.servlet.http.HttpSession session =  req.getSession(); 
		
		if (studentAdded) {
			session.setAttribute("addStudentMsg", "Student added successfully....");
			resp.sendRedirect("addStudent.jsp");
		} else {
			session.setAttribute("addStudentError", "Student registration fail due to server problem.....");
			resp.sendRedirect("addStudent.jsp");
		}		
	}
}
