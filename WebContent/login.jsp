<%@ include file="/add-on/header.jspf"%>
<style>
.demo-layout-transparent {
	background: #AB47BC;
	}
	
	.demo-layout-transparent .mdl-layout__header, .demo-layout-transparent .mdl-layout__drawer-button
		{
		color: white;
	}
	
	.demo-card-wide.mdl-card input {
		border: none;
		outline: none;
		width: 100%;
		margin-top: 20px;
	}
	
	.demo-card-wide>.mdl-card__title {
		color: #1c1c1c;
	}
	
	.demo-card-wide>.mdl-card__menu {
		color: #fff;
	}
	
	.demo-card-wide.mdl-card input {
		border: none;
		outline: none;
		width: 100%;
	}
</style>
<h4 style='color: red; margin-top: 30px; margin-bottom: 30px;'
	class="col-md-12 text-center">${error}</h4>
<form method="post" action="<%=request.getContextPath()%>/login">
	<div
		class="demo-card-wide mdl-card mdl-shadow--2dp col-md-offset-4 col-md-4">
		<div class="mdl-card__title">
			<h2 class="mdl-card__title-text">Login</h2>
		</div>
		<div class="mdl-card__supporting-text">
			Faça o login aqui e agora <input type="text" name="name"
				placeholder="Login"> <input type="password" name="pass"
				placeholder="Senha">
		</div>
		<div class="mdl-card__actions mdl-card--border">
			<button type="submit"
				class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
				Save</button>
		</div>
		<div class="mdl-card__menu"></div>
	</div>
</form>
<%@ include file="/add-on/footer.jspf"%>
