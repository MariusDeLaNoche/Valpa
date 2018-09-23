<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="parts/head.jsp" />

<body>
	<jsp:include page="parts/logo.jsp" />
	<jsp:include page="parts/menu.jsp" />
	<div class="container">
		<div class="justify-content-center blocFondBlanc">
			<h1>Votre compte en détails</h1>
			<div class="row margin-bottom-30">
				<%-- 
				Affichage des messages d'erreur AJAX
		 		--%>
				<div class="col-sm-12">
					<c:if test="${not empty messages['errAJAX']}">
						<div class="alert alert-danger">${ messages['errAJAX'] }</div>
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="card">
						<div class="card-block">
							<h3 class="card-title">Suivi consommation</h3>
							
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card">
						<div class="card-block">
							<h3 class="card-title">Mon Forfait</h3>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/AdminJS.js"></script>
	<jsp:include page="parts/footer.jsp" />
</body>
</html>