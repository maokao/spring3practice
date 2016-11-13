<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<html>
<script>
function change_action1() {
	document.form1.setAttribute('action', "student/insert");
}

function change_action2() {
if(confirm("Are you sure to delete it?"))
	{
		document.form1.setAttribute('action', "student/delete");
		document.form1.submit();
	}	
	else
	{
		return false;
	}
}
</script>
<body>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<!-- For login user -->
	<form id="form1" name="form1" method="post" action="student/delete">
	    <table width="500" border="1" cellspacing="0" cellpadding="0" style="border:1 px; border-collapse:collapse">
	        <tr>
	        	<td width="50">Select</td>
	            <td width="250">Name</td>
	            <td width="200">Score</td>

	        </tr>
		    <c:forEach items="${alluserinfo}" var="p">
		       <tr>
		        <td><input type="radio" name="check_radio" id="check_radio" value="${p.s_id}" /></td>
		        <td><c:out value="${p.s_name}"/></td>
		        <td><c:out value="${p.s_score}"/></td>
		      </tr>
		    </c:forEach>
	    </table>
	    <br>
		<table width="500" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="250" align="center"><input type="submit" name="button" id="button" value="insert" OnClick="change_action1();"></td>
		    <td width="250" align="center"><input type="submit" name="button2" id="button2" value="delete"></td>
		  </tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
    </form>
    <h2>
			<a href="/viz">Visualization</a>
	</h2>
    
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	    
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>


	</sec:authorize>

</body>
</html>