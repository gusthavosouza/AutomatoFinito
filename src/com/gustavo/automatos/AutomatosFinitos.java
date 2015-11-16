package com.gustavo.automatos;
import java.util.ArrayList;
import java.util.HashMap;


public class AutomatosFinitos {
	
		public HashMap<String, ArrayList<Estado>> montaEstados() {

			HashMap<String, ArrayList<Estado>> tabelaDeTransicoes = new HashMap<String, ArrayList<Estado>>();
			
			tabelaDeTransicoes.put("Q0", putProximoEstado(new Estado(Estados.Q1, Characters.numbers), new Estado(Estados.Q2, Characters.point)));
			
			tabelaDeTransicoes.put("Q1", putProximoEstado(new Estado(Estados.Q1, Characters.numbers),new Estado(Estados.Q3, Characters.point), new Estado(Estados.Q5, Characters.typeNumber),new Estado(Estados.Q6, Characters.e)));
			
			tabelaDeTransicoes.put("Q2", putProximoEstado(new Estado(Estados.Q4, Characters.numbers)));
			
			tabelaDeTransicoes.put("Q3", putProximoEstado(new Estado(Estados.Q4, Characters.numbers),new Estado(Estados.Q5, Characters.typeNumber),new Estado(Estados.Q6, Characters.e)));
			
			tabelaDeTransicoes.put("Q4", putProximoEstado(new Estado(Estados.Q4, Characters.numbers),new Estado(Estados.Q5, Characters.typeNumber), new Estado(Estados.Q6, Characters.e)));
			
			tabelaDeTransicoes.put("Q6", putProximoEstado(new Estado(Estados.Q7, Characters.signal), new Estado(Estados.Q8, Characters.numbers)));
			
			tabelaDeTransicoes.put("Q7", putProximoEstado(new Estado(Estados.Q8,Characters.numbers)));
			
			tabelaDeTransicoes.put("Q8", putProximoEstado(new Estado(Estados.Q8,Characters.numbers),new Estado(Estados.Q5, Characters.typeNumber)));
			
			tabelaDeTransicoes.put("QR", putProximoEstado(new Estado(Estados.QR, "".toCharArray())));
			
			return tabelaDeTransicoes;
		}

		public ArrayList<Estado> putProximoEstado(Estado... estados) {

			ArrayList<Estado> arrayEstados = new ArrayList<Estado>();
			for (int i = 0; i < estados.length; i++)
				arrayEstados.add(estados[i]);

			return arrayEstados;
		}

	static class Characters {

		final static char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7','8', '9' };
		final static char[] signal = { '+', '-' };
		final static char[] typeNumber = { 'f', 'd' };
		final static char[] point = { '.' };
		final static char[] e = {'e'};
	}

	public enum Estados {

		Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, QR;

	}

	public enum EstadosFinais {
		Q1, Q3, Q4, Q5, Q8;
	}

	public class Estado {

		public String caracteresPermitidos = "";
		public Estados proximoEstado;

		public Estado(Estados estado, char[]... digits) {

			for (int i = 0; i < digits.length; i++)
				for (int j = 0; j < digits[i].length; j++)
					this.caracteresPermitidos += digits[i][j];

			this.proximoEstado = estado;

		}
	}
}
