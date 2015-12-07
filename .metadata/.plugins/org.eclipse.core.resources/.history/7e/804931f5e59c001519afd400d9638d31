$(function(){

    // preload de imagem
    $.fn.imgShow = function(){
        $(this.selector).on("change", function(evt){
            var files = evt.target.files; // lista de arquivos
            // a tag img que possui a classe imagem-slide vai receber a imagem que foi update
            $('.imagem-show').attr("src", URL.createObjectURL(event.target.files[0]));

        });
    };

    $.fn.imgBG = function(selector){
        $(this.selector).on("change", function(evt){
            var files = evt.target.files; // lista de arquivos
            // a tag img que possui a classe imagem-slide vai receber a imagem que foi update
            console.log(selector);
            $(selector).css({background: "linear-gradient(rgba(1,1,1, 0.4), rgba(1,1,1, 0.4)), url("+URL.createObjectURL(event.target.files[0])+") center / cover"});
        });
    };

    // preload de musicas
    $.fn.music = function(a){
        $(this.selector).on("change", function(evt){
            var files = evt.target.files; // lista de arquivos
            // a tag img que possui a classe imagem-slide vai receber a imagem que foi update
            a.src = URL.createObjectURL(event.target.files[0]);
            a.play();
        });
    };

    // preload de imagem
    $.fn.countDays = function(date){
        now = new Date();
        $date = [now.getDate(), now.getMonth()+1, now.getFullYear()];

        $d = date.split('/');
        $d2 = $date;
        $days = 0;

        while(true){
            if($d[0] < 31){
                $d[0]++;
            }else{
                if($d[1] <= 12){
                    $d[1]++;
                    $d[0] = 1;
                }else{
                    if($d[2] <= $d2[2]){
                        $d[2]++;
                        $d[1] = 1;
                    }else{
                        return 0;
                    }

                }
            }

            $days++;
            if(($d[0]==$d2[0]) && ($d[1]==$d2[1]) && ($d[2]==$d2[2])){
                return $days;
            }

        }
    };

    // Extend the default Number object with a formatMoney() method:
    // usage: someVar.formatMoney(decimalPlaces, symbol, thousandsSeparator, decimalSeparator)
    // defaults: (2, "$", ",", ".")
    Number.prototype.formatMoney = function(places, symbol, thousand, decimal) {
        places = !isNaN(places = Math.abs(places)) ? places : 2;
        symbol = symbol !== undefined ? symbol : "R$";
        thousand = thousand || ",";
        decimal = decimal || ".";
        var number = this,
            negative = number < 0 ? "-" : "",
            i = parseInt(number = Math.abs(+number || 0).toFixed(places), 10) + "",
            j = (j = i.length) > 3 ? j % 3 : 0;
        return symbol + negative + (j ? i.substr(0, j) + thousand : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + thousand) + (places ? decimal + Math.abs(number - i).toFixed(places).slice(2) : "");
    };

    /*
     *  vamos pegar uma stringo e organizala para apresenta-la de forma correta
     *  ou seja, vamos pegar uma timestamp e entregar uma data formatada.
     * */

    String.prototype.formatTimestamp = function() {
        $strs = this.split(" ");
        $date = $strs[0].split("-");


        if($date[2] == "00" || $date[0] == "0000")
            return "---";

        return $date[2]+"/"+$date[1]+"/"+$date[0];
    };

    /**
     * o search busca por qualquer coisa onde vc quiser
     * ou seja ele busca um termo .. ele pega uma informação
     * de um imput e manda para um arquivo informado e depois ele
     * retorna um json.
     *
     * Como funciona?
     *
     * $(seletor): onde estará o input que sera pego o texto
     * .search(url): para onde será enviado o texto e retrnará oq ue o arquivo mandar, mas por default deve ser um json.
     *
     * exemplo: $(seletor).search(url) :: return json;
     *
     * **/

    $.fn.search = function(url, callback){
        $(this.selector).on("keyup", function(){
            $.ajax({
                url: url,
                type: 'post',
                data:  'search='+$(this).val(),
                datatype: 'json',
                success: function(e){
                    console.log(e);
                    $.each(JSON.parse(e), function(a, b){
                        callback.call(a,b);
                    });
                },
                error: function(e){
                    console.log("Error ao comunicar com o servidor");
                }
            });
        });
    };
});