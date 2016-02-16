<%@ include file="add-on/header.jspf"%>
<%@ include file="add-on/menu.jspf"%>

<div class="row">
<div class="demo-card-square mdl-card mdl-shadow--2dp col-md-8 col-md-offset-2">
	<h2 class="text-center">Adicionar Data</h2>
	<form method="post" action="addDate">
		<ul>
			<li>
				Data: <input type="date" name="date">
			</li>
			<li>
				tipo: <select name="tipo">
					<option value="movel">movel</option>
					<option value="fixo">fixo</option>
					<option value="subistituto">subistituto</option>
				</select>
			</li>
			<li>
				Descrição: <textarea rows="10" cols="40"></textarea>
			</li>
		</ul>
	</form>
</div>
</div>

<%@ include file="add-on/footer.jspf"%>