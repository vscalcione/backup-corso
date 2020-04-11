package it.intersistemi.corsojava.esercizi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.intersistemi.corsojava.ConsoleInput.ConsoleInputInteri;
import it.intersistemi.corsojava.ConsoleInput.ConsoleInputStringa;

public class SimulazioneContoCorrente {
	public static void main(String[] args) throws IOException{
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		NuovoContoCorrente conto1 = new NuovoContoCorrente();
		String nomeCliente = ConsoleInputStringa.leggiStringa(console, "Inserisci nome: ").toUpperCase();
		String cognomeCliente = ConsoleInputStringa.leggiStringa(console, "Inserisci cognome").toUpperCase();
		conto1.setNomeCliente(nomeCliente);
		conto1.setCognomeCliente(cognomeCliente);
		double saldoIniziale = 0;
		saldoIniziale = conto1.versa(ConsoleInputInteri.leggiIntero(console, "Inserisci importo: "));
		double prelievo = ConsoleInputInteri.leggiIntero(console, "Prelievo: ");
		if(prelievo > saldoIniziale) {
			System.out.println("Prelievo negato");
			conto1.visualizzaSaldo();
		}else {
			if(prelievo == saldoIniziale) {
				System.out.println("Prelievo di "+saldoIniziale);
				conto1.preleva(prelievo);
				conto1.visualizzaSaldo();
			}else {
				System.out.println("Prelievo di: "+prelievo);
				conto1.preleva(prelievo);
				conto1.visualizzaSaldo();
			}
		}
		
	}
	
	public static class NuovoContoCorrente{
		String cognomeCliente, nomeCliente;
		double saldo, saldoCliente;
		public String getCognomeCliente() {
			return cognomeCliente;
		}
		
		public void setCognomeCliente(String cognomeCliente) {
			this.cognomeCliente = cognomeCliente;
		}
		
		public String getNomeCliente() {
			return nomeCliente;
		}
		
		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}
		
		public double getSaldo() {
			return saldo;
		}
		
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		
		public double getSaldoCliente() {
			return saldoCliente;
		}
		
		public void setSaldoCliente(double saldoCliente) {
			this.saldoCliente = saldoCliente;
		}
		
		public double versa(double importo) {
			return saldoCliente = saldoCliente + importo;
		}
		
		public void preleva(double importo) {
			saldoCliente = saldoCliente - importo;
		}
		
		public void versaAssegno(double importo) {
			saldo = saldo + importo;
		}
		
		public void visualizzaSaldo() {
			System.out.println("===========================");
			System.out.println("Nome Cliente: "+nomeCliente);
			System.out.println("Cognome Cliente: "+cognomeCliente);
			System.out.println("Saldo: "+saldoCliente);
			System.out.println("===========================");
		}
		
		public void prelevaNew(double importo) {
			saldo = saldo - importo;
		}
		
		public void visualizzaNew() {
			System.out.println("Nuovo saldo: "+saldo);
		}
	}
}