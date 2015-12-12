<%@ include file="add-on/header.jspf"%>

<!-- verificando sessao -->
<c:if test="${empty sessionScope.name }">
	<div class="row" style="margin: 20px 0;">
		<div class="col-md-12">
			<div class="btn-group" role="group" aria-label="btns">
				<a href="<%=request.getContextPath()%>/login.jsp"
					class="btn btn-info">Login</a>
			</div>
		</div>
	</div>
</c:if>




<h4 class="text-center">Finalizar compra / ${ sessionScope.name }</h4>
<div class="col-md-8 col-md-offset-2" style="margin-top: 30px;">
	<div class="aqui-alerta"></div>
	<ul class="list-group">
		<c:forEach var="i" items="${ itens }">
		 	<c:set var="total" value="${total + i.getPrecoUnitario()}" />  
			  <li class="list-group-item">
			    <span class="label label-success">R$ ${ i.getPrecoUnitario() } </span>
			    	${ i.descricaoCurta }
			  </li>
		</c:forEach>
		
		
		<li class="list-group-item">
			<input type="text" placeholder="Numero do Cartão">
		</li>
		<li class="list-group-item">
			<input type="text" placeholder="Endereço">
		</li>
		
		<li class="list-group-item" style="font-size:30px;">
			Total: 
			<span class="label label-success">R$ ${total}</span>
		</li>
	</ul>
	
	<div class="row" style="margin: 20px 0;">
		<div class="col-md-12">
			<div class="btn-group" role="group" aria-label="btns">
				<a href="<%=request.getContextPath()%>/finalizar" class="btn btn-info">Finalizar</a>
			</div>
		</div>
	</div>


	<%@ include file="add-on/menu.jspf"%>
</div>


<%@ include file="add-on/footer.jspf"%>