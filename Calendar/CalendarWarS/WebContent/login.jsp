<%@ include file="add-on/header.jspf"%>
<%@ include file="add-on/menu.jspf"%>
<!-- Square card -->
<style>
.demo-card-square.mdl-card {
	width: 320px;
	height: 420px;
}

.demo-card-square>.mdl-card__title {
	color: #fff;
	background: url('img/img2.png') bottom right 15% no-repeat #303F9F;
	background-size: 50%; 
}
</style>

<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4" style="margin-top: 10px;">
			<p class="text-center" style="color:white">${ error }</p>
			<div class="demo-card-square mdl-card mdl-shadow--2dp">
				<div class="mdl-card__title mdl-card--expand">
					<h2 class="mdl-card__title-text">Login</h2>
				</div>
				<div class="mdl-card__supporting-text">
					<form action="login" method="post">
						<div class="mdl-textfield mdl-js-textfield">
						    <input class="mdl-textfield__input" type="text" name="login" id="login">
						    <label class="mdl-textfield__label" for="login">Login...</label>
						  </div>
						  <div class="mdl-textfield mdl-js-textfield">
						    <input class="mdl-textfield__input" type="password" name="pass" id="pass">
						    <label class="mdl-textfield__label" for="pass">Password...</label>
						  </div>				
					
				</div>
				<div class="mdl-card__actions mdl-card--border">
					<button type="submit" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
						Entrar</button>
				</div></form>
			</div>
		</div>
	</div>
</div>
<%@ include file="add-on/footer.jspf"%>