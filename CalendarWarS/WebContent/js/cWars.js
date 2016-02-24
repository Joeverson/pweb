function cWars () {
    this.calendar = new Date();
    this.day_of_week = ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'];
    this.month_of_year = ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'];
    this.year = this.calendar.getFullYear();       // Retorna o ano
    this.month = this.calendar.getMonth();    // Retorna mes (0-11)
    this.today = this.calendar.getDate();     // Retorna dias (1-31)
    this.weekday = this.calendar.getDay();   // Retorna dias (1-31)
    this.DAYS_OF_WEEK = 7;    // "constant" para o numero de dias na semana
    this.DAYS_OF_MONTH = 31;    // "constant" para o numero de dias no mes
    this.calendar.setDate(1);    // Comecar o calendario no dia '1'
}

//alter the month that will go be changed
cWars.prototype.alterDate = function(month, year){
    this.calendar.setMonth(month || this.month);    // Comecar o calendario com o mes atual
    this.calendar.setFullYear(year);
};

cWars.prototype.mounths = function(callback){
	for(index = 0; index < this.month_of_year.length; index++){
		callback.call(index, this.month_of_year[index]);
	}
}

cWars.prototype.days = function(callback){
	for(index = 2000; index < (this.year + 25); index++){
		callback.call(0, index);
	}
}

cWars.prototype.generator = function (callback) {
    var cal = "";    // Usado para imprimir na tela
    var day = 0;
    var i = 0;
    
    for(index=0; index < this.DAYS_OF_MONTH; index++){
        if( this.calendar.getDate() > index ){
            this.week_day = this.calendar.getDay();

            //if(this.week_day == 0) callback.call(0, {"week": "this", "day": "this", "this": false}); //momento onde ha queba de dias no mês
            console.log(i++);
            i++;
            if(this.week_day != this.DAYS_OF_WEEK){
                day  = this.calendar.getDate();
                               
                if( this.today == this.calendar.getDate() )
                    callback.call(0, {"week": this.day_of_week[this.week_day], "day": day, "this": true});
                else
                    callback.call(0, {"week": this.day_of_week[this.week_day], "day": day, "this": false});
            }

        }
        this.calendar.setDate(this.calendar.getDate()+1);
    }
    
    //callback.call(0, {"week": this.day_of_week[this.week_day], "day": (i/2)});
};
