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

<c:if test="${not empty sessionScope.name }">
	<!-- se não estiver logado ele n grava nem faz chamada-->
	<script>
			$(function(){
				$count = 1;
				
				$(".choose").on("click", function(){					
					$.ajax({
						url: "<%=request.getContextPath()%>/pedido",
							type : "post",
							data : "id=" + $(this).val(),
							datatype : "json",
							success : function(e) {
								console.log(e);
								$('.aqui-alerta').html('<div class="alert alert-success" role="alert">Salvo com Sucesso ( '+ $count + ' )!</div>');
								$count++;
							}
						});
					});

		});
	</script>
</c:if>


<h4 class="text-center">Clique para adicionar ao carrinho / ${ sessionScope.name }</h4>
<div class="col-md-8 col-md-offset-2" style="margin-top: 30px;">
	<div class="aqui-alerta"></div>
	<ul class="list-group">
		<c:forEach var="i" items="${ itens }">
			<li class="list-group-item">
				<div class="row">
					<div class="col-md-3">
						<input type="checkbox" class="choose" name="choose"
							value="${ i.itemID }">
					</div>
					<div class="col-md-9" class="descricao">${ i.descricaoCurta }
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>


	<%@ include file="add-on/menu.jspf"%>
</div>


<%@ include file="add-on/footer.jspf"%>