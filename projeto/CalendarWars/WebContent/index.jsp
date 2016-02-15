<%@ include file="add-on/header.jspf"%>
<%@ include file="add-on/menu.jspf"%>
<style>
.media {
	padding-left: 10px;
	cursor: pointer;
}

.media:nth-child(even) {
	background-color: rgba(255, 255, 255, 0.5);
}

.meses, .years {
	background: transparent;
	border: 1px solid #42A5F5;
	outline: none;
	padding: 10px;
	color: white;
	border-radius: 10px;
}

.meses option, .years option {
	background: transparent;
}
</style>

<div class="col-md-10 col-md-offset-1"
	style="margin-top: 20px; margin-bottom: 20px;">
	<select class="meses">
	</select> <select class="years">
	</select>

	<!-- Colored raised button -->
	<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored btn-go">
			Go for Date
		</button>


</div>
<div class="row model" style="margin-top: 30px;"></div>

<script>
	var cwars = new cWars();
	date();
	
	$(".btn-go").click(function(){
		cwars.alterDate($(".meses").val(), $(".years").val());
		$(".model").html("");
		date();
	});
	
	
	
	function date(){
		cwars.days(function(a, b) {
			$(".years").append('<option value="'+a+'">' + a + '</option>');
		});

		cwars.mounths(function(a, b) {
			$(".meses").append('<option value="'+a+'">' + a + '</option>');
		});

		cwars.generator(function(a, b) {
					$(".model")
							.append(
									'<div class="col-md-10 col-md-offset-1">'
											+ '<div class="media">'
											+ '<div class="media-left media-middle">'
											+ '<h3 style="color:white;"> '
											+ a.day
											+ '<p>'
											+ a.week
											+ '</p>'
											+ '</h3>'
											+ '</div>'
											+ '<div class="media-body">'
											+ '<h4 class="media-heading" style="color:white"> - Anota��o - </h4>'
											+

											'</div>' + '</div>' + '</div>');
				});
	}
</script>
<%@ include file="add-on/footer.jspf"%>
