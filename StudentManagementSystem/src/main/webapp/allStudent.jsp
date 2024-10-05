<%@page import="in.cutm.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="in.cutm.dbConnection.ConnectDB"%>
<%@page import="in.cutm.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="component/jstlTag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="component/bootStrapLink.jsp" %>
</head>
<body>
		<%@ include file="component/navBar.jsp" %>

	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
					
							<c:if test="${not empty updateStudentMsg }">
								<p class="text-center text-success">${updateStudentMsg}</p>
								<c:remove var="updateStudentMsg"/>
							</c:if>
							
							<c:if test="${not empty updateStudentError }">
								<p class="text-center text-success">${updateStudentError}</p>
								<c:remove var="updateStudentError"/>
							</c:if>
							
							<c:if test="${not empty deleteStudentMsg }">
								<p class="text-center text-success">${deleteStudentMsg}</p>
								<c:remove var="deleteStudentMsg"/>
							</c:if>
							
							<c:if test="${not empty updateStudentError }">
								<p class="text-center text-success">${updateStudentError}</p>
								<c:remove var="deleteStudentError"/>
							</c:if>
						<table class="table">
							  <thead>
							    <tr>
							      <th scope="col">Full Name</th>
							      <th scope="col">DOB</th>
							      <th scope="col">Address</th>
							      <th scope="col">Qualification</th>
							      <th scope="col">Email</th>
							      <th scope="col">Action</th>
							    </tr>
							  </thead>
							  <tbody>
							  
							  
							 <%
							  	StudentDao dao = new StudentDao(ConnectDB.dbconnect());
							  	List<Student> list = dao.displayAllStudent();
							  	
							  	for(Student st : list){ %>
							  	<tr>
							      <th scope="row"><%= st.getFullName() %></th>
							      <td><%= st.getDob() %></td>
							      <td><%= st.getAddress() %></td>
							      <td><%= st.getQualification() %></td>
							      <td><%= st.getEmail() %></td>
							      <td>
							      	<a href="editStudent.jsp?id=<%= st.getId() %>" class="btn btn-sm btn-primary">Edit</a>
							      	<a href="delete?id=<%= st.getId() %>" class="btn btn-sm btn-danger">Delete</a>
							      <td/>
							    </tr>
							  	
							  	<%
							  	}						  		
							 %>
							    
<!-- 
								<tr>
							      <th scope="row">2</th>
							      <td>Jacob</td>
							      <td>Thornton</td>
							      <td>@fat</td>
							      <td>@mdo</td>
							    </tr>
							    <tr>
							      <th scope="row">3</th>
							      <td>Larry the Bird</td>
							      <td>@twitter</td>
							      <td>@mdo</td>
							      <td>@mdo</td>
							    </tr>


 -->
							  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>