package com.gustavo.automatos.teste;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.gustavo.automatos.AutomatosFinitos;

public class AutomatosMain {

	static HashMap<String, ArrayList<AutomatosFinitos.Estado>> tabelaDeTransicoes = new AutomatosFinitos().montaEstados();

	public static void main(String[] args) {

		Scanner scan = null;
		
		try {
			
			scan = new Scanner(System.in);
			
			String read;
			System.out.println("Digite um numero real....");
			read = scan.next();
	
			System.out.println("Cadeia: " + caracteresLidos(read));
	
			char[] cadeia = read.toCharArray();
			
			System.out.print("Q0 => ");
			String nextEstado = "Q0";
			
			for (int i = 0; i < cadeia.length; i++) {
				nextEstado = goNextEstado(nextEstado, cadeia[i]);
				System.out.print(nextEstado + " => ");
			}
			
			if (isEstadoFinal(nextEstado))
				System.out.println("Aceita!");
			else
				System.out.println("Não Aceita");
			
			scan.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

	public static boolean isEstadoFinal(String ultimoEstado) {

		AutomatosFinitos.EstadosFinais finais[] = AutomatosFinitos.EstadosFinais.values();
		boolean retorno = false;
		for (int a = 0; a < finais.length; a++) {

			if (ultimoEstado.equals(finais[a].toString())) {
				retorno = true;
				break;
			}
		}
		return retorno;
	}

	public static String goNextEstado(String estado, char caracter) {
		
		String lastEstado = AutomatosFinitos.Estados.QR.toString();
		
		if (estado == null)
			return lastEstado;
		
		ArrayList<AutomatosFinitos.Estado> listEstados = tabelaDeTransicoes.get(estado);
		
		if (listEstados == null)
			return lastEstado;
		
		for (AutomatosFinitos.Estado stateNow : listEstados) {

			char[] permitidos = stateNow.caracteresPermitidos.toCharArray();

			for (int a = 0; a < permitidos.length; a++) {

				if (caracter == permitidos[a]) 
					return lastEstado = stateNow.proximoEstado.toString();
				
			}
		}

		return lastEstado;
	}

	public static String caracteresLidos(String s) {

		char b[] = s.toCharArray();
		String retorno = "[";

		for (int i = 0; i < b.length; i++) {
			retorno += b[i] + " | ";
		}
		retorno = retorno.substring(0, retorno.length()-2) + "]";
		return retorno;

	}

}
