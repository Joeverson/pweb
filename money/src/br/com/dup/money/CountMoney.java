package br.com.dup.money;

public class CountMoney {
	private int value;
	private int count;
	private int array[] = {100, 50, 20, 10, 5, 1};
	private String str;

	public CountMoney(int val){
		this.value = val;
		this.count = 1;
		this.str = "";
		
		//começa a testar ^^
		this.run();
	}
	/**
	 * chamada principal do esquema, onde vai ficar validando se 
	 * o valor informado do usuário chegou a zero.
	 * 
	 *  @param null
	 *  @return null
	 * */
	private void run(){
		while(this.value != 0)
			this.cedulas();
	}
	
	/**
	 * Este metodo varre o array em busca de uma valor menos que o dado pelo usuario
	 * e em seguida subitra do valor total e alem disso conta a quantidade de cedulas
	 * 
	 * Ele pega o array de cedulas possiveis e o valor informado pelo usuário.
	 * 
	 * @param null
	 * @return - por baixo ele gera a estring com as informações de valor de cedual
	 * e quantidade.
	 * @return true | false
	 * */
	private boolean cedulas(){		
		for(int k : this.array){
			if(k <= this.value){
				this.str += "valor: "+this.value+" ---- "+this.count+"-> cedula: R$"+k+"<br>";
				this.value -= k;
				this.count++;
				return true;
			}
		}
		return false;
	}

	public String getReports() {
		return str;
	}
}
