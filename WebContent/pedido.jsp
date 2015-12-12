<%@ include file="add-on/header.jspf"%>

<!-- verificando sessao -->
<c:if test="${empty sessionScope.name }">
	<script> window.location.href="<%=request.getContextPath()%>/login.jsp"</script>
</c:if>

<h4 class="text-center">Veja os itens de seu carrinho / ${ sessionScope.name }</h4>
<div class="col-md-8 col-md-offset-2" style="margin-top: 30px;">
	<div class="aqui-alerta"></div>
	<ul class="list-group">

		<!-- verificando se esta fazio -->
		<c:if test="${empty itens }">
			<p>Ops, Você ainda não escolheu nada!!</p>
		</c:if>

		<c:forEach var="i" items="${ itens }">
			<li class="list-group-item">
				<div class="row">
					<div class="col-md-3">R$ ${ i.getPrecoUnitario() }</div>
					<div class="col-md-9" class="descricao">${ i.descricaoCurta }
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>

	<div class="row" style="margin: 20px 0;">
		<div class="col-md-12">
			<div class="btn-group" role="group" aria-label="btns">
				<a href="<%=request.getContextPath()%>/comprar" class="btn btn-info">Comprar</a>
			</div>
		</div>
	</div>
	
	<%@ include file="add-on/menu.jspf"%>
</div>


<%@ include file="add-on/footer.jspf"%>