<%@page import="in.cutm.dbConnection.ConnectDB"%>
<%@page import="in.cutm.dao.StudentDao"%>
<%@page import="in.cutm.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="component/bootStrapLink.jsp" %>
</head>
<body class="bg-light">

<%@include file="component/navBar.jsp" %>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Student<p/>
						
						<%
						
						int id = Integer.parseInt(request.getParameter("id"));
						StudentDao dao = new StudentDao(ConnectDB.dbconnect());
						Student st = dao.getStudentById(id);
						
						%>
						
						<form action="updateStudent" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label>
								<input value="<%= st.getFullName() %>" type="text" class="form-control" name="studentName">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Date of Birth</label>
								<input value="<%=st.getDob() %>" type="date" class="form-control" name="studentDob">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Address</label>
								<input value="<%=st.getAddress() %>" type="text" class="form-control" name="studentAddress">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Qualification</label>
								<input value="<%=st.getQualification() %>" type="text" class="form-control" name="studentQul">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email Id</label>
								<input value="<%=st.getEmail() %>" type="email" class="form-control" name="studentEmail">
							</div>
							
							<input type="hidden" name="id" value="<%= st.getId()%>">
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>