package in.cutm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.cutm.model.Student;

public class StudentDao {
//	Create an field of Connection class;
	private Connection con;
	
//	Create a field constructor;
	public StudentDao(Connection con) {
		super();
		this.con = con;
	}
	
//	Create a boolean method which will return either true or false.
//	Take the parameter of a student class object;
	
	public boolean isStudentAdded(Student student) {
//		Create a boolean variable which will return true or false after the operation;
		boolean studentAdded = false;
		
		try {
			String addStudentQuery = "insert into student(fullname, dob, address, qualification, email) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(addStudentQuery);

//			Set the positional parameter by getting the student object property;
			ps.setString(1, student.getFullName());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getQualification());
			ps.setString(5, student.getEmail());
			
			int i = ps.executeUpdate();
			
			if (i == 1) {
				studentAdded = true;
			} else {
				studentAdded = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return studentAdded;
	}
	
	public List<Student> displayAllStudent() {
		List<Student> list = new ArrayList<Student>();
		Student  st = null;
		
		try {
			String displayAllStudentQuery = "select * from student";
			PreparedStatement ps = con.prepareStatement(displayAllStudentQuery);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				st = new Student();
				
				st.setId(rs.getInt(1));
				st.setFullName(rs.getString(2));
				st.setDob(rs.getString(3));
				st.setAddress(rs.getString(4));
				st.setQualification(rs.getString(5));
				st.setEmail(rs.getString(6));
				list.add(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Student getStudentById(int id) {
		Student st = null;
		try {
			String byIdQuery = "select * from student where id=?";
			PreparedStatement ps = con.prepareStatement(byIdQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				st = new Student();
				
				st.setId(rs.getInt(1));
				st.setFullName(rs.getString(2));
				st.setDob(rs.getString(3));
				st.setAddress(rs.getString(4));
				st.setQualification(rs.getString(5));
				st.setEmail(rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return st;
	}
	
	public boolean isUpdateStudent(Student student) {
		boolean isStudentUpdate = false;
		
		try {
			String updateStudentQuery = "update student set fullname=?, dob=?, address=?, qualification=?, email=? where id=?";
			PreparedStatement ps = con.prepareStatement(updateStudentQuery);

//			Set the positional parameter by getting the student object property;
			ps.setString(1, student.getFullName());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getQualification());
			ps.setString(5, student.getEmail());
			ps.setInt(6, student.getId());
			
			int i = ps.executeUpdate();
			
			if (i == 1) {
				isStudentUpdate = true;
			} else {
				isStudentUpdate = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return isStudentUpdate;
	}
	
	public boolean isDeleteStudent(int id) {
		boolean deleteStudent= false;
		
		try {
			String deleteStudentQuery = "delete from student where id=?";
			PreparedStatement ps = con.prepareStatement(deleteStudentQuery);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if (i == 1) {
				deleteStudent = true;
			} else {
				deleteStudent = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return deleteStudent;
	}
}
