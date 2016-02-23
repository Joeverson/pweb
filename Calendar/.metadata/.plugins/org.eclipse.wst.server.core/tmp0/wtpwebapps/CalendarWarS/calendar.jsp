<%@ include file="add-on/header.jspf"%>
<%@ include file="add-on/menu.jspf"%>
<style>
	input, textarea{
		border:none;
		outline:none;
	}
</style>
<div class="container">
<div class="row">
	<div
		class="col-md-8 col-md-offset-2 demo-card-square mdl-card mdl-shadow--2dp" style="width:50%">
		<h3 class="text-center">Adicionar Data</h3>
		<small class="text-center">${ error }</small>
		<form method="post" action="calendar">
			<ul class="demo-list-control mdl-list">
				<li class="mdl-list__item">
					<div class="col-md-4">Data:</div>
					<div class="col-md-8">
						<input type="date" name="date">
					</div>
				</li>
				<li class="mdl-list__item">
					<div class="col-md-4">Tipo:</div>
					<div class="col-md-8">
						<select name="type">
							<option value="movel">movel</option>
							<option value="fixo">fixo</option>
							<option value="subistituto">subistituto</option>
						</select>
					</div>
				</li>
				<li class="mdl-list__item">
					<div class="col-md-4">Descrição:</div>
					<div class="col-md-8">
						<textarea rows="10" cols="20" name="note" placeholder="Digite aqui"></textarea>
					</div>
				</li>
				<li class="mdl-list__item">
					<!-- Colored raised button -->
					<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
					  Salvar
					</button>

				</li>
			</ul>
		</form>
	</div>
</div>

</div>

<%@ include file="add-on/footer.jspf"%>