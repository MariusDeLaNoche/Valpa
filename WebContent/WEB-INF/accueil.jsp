<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<jsp:include page="parts/head.jsp" />
	
	<body>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/accueil.js"></script>
		<jsp:include page="parts/logo.jsp" />
		<jsp:include page="parts/menu.jsp" />
		<div class="container">
			<div class="justify-content-center blocFondBlanc">
				<h2>Bienvenue ${ nomPrenomUser }</h2>
				<div id="jstree_div"></div>
			</div>
		</div>
		<jsp:include page="parts/footer.jsp" />
	</body>
</html>