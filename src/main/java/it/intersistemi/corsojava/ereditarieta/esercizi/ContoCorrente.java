/**
 * 
 */
package it.intersistemi.corsojava.ereditarieta.esercizi;
import java.lang.*;

public class ContoCorrente{
	private int numeroConto;
	private String intestatarioConto;
	private double saldoCorrente;
	private double prelievo;
	private Bancomat[] carte=new Bancomat[5];	
	
	public ContoCorrente(int numeroConto, String intestatarioConto) {
		this.numeroConto=numeroConto;
		this.intestatarioConto=intestatarioConto;
	}
	
	public ContoCorrente(int numeroConto, String intestatarioConto, double saldoCorrente, double prelievo) {
		this.numeroConto=numeroConto;
		this.intestatarioConto=intestatarioConto;
		this.saldoCorrente=saldoCorrente;
		this.prelievo=prelievo;
	}
	
	public int getNumeroConto() {
		return numeroConto;
	}
	
	public String getIntestatarioConto() {
		return intestatarioConto;
	}
	
	public double getSaldoCorrente() {
		saldoCorrente=saldoCorrente - prelievo;
		return saldoCorrente;
	}
	
	public void setSaldoCorrente(double versamento) {
		this.saldoCorrente=versamento;
	}
	
	public void setPrelievo(double prelievoMain) {
		this.prelievo=prelievoMain;
	}
	
	public boolean aggiungiCarta(Bancomat bancomat) {
		if(bancomat!=null) {
			for (int i = 0; i < carte.length; i++) {
				if(carte[i]==null) {
					carte[i]=bancomat;
					return true;
				}
			}
		}
		return false;
	}
	
	Bancomat trovaBancomat(int numeroCarta) {
		for (int i = 0; i < carte.length; i++) {
			if(carte[i]!=null && carte[i].getNumeroCarta()==numeroCarta) {
				return carte[i];
			}
		}
		return null;
	}
	
	public boolean prelievoDaAtm(int numeroCarta, int pinCode, double prelievo) {
		if(prelievo>0) {
			Bancomat bancomat=trovaBancomat(numeroCarta);
			if(bancomat!=null) {
				if(bancomat.getPinCode()==pinCode) {
					if(prelievo <= saldoCorrente) {
						saldoCorrente=saldoCorrente - prelievo;
					}
				}
			}
		}
		return false;
	}
	
	public boolean deposita(int numeroCarta, int pinCode, double contante) {
		if(prelievo>0) {
			Bancomat bancomat=trovaBancomat(numeroCarta);
			if(bancomat!=null) {
				if(bancomat.getPinCode()==pinCode) {
					if(prelievo <= saldoCorrente) {
						saldoCorrente=saldoCorrente + prelievo;
					}
				}
			}
		}
		return false;
	}
	
	private void aggiungiMovimento(int numeroCarta, double contante, int segno) {
		Movimento[] movimenti = null;
		int indiceMovimento = 0;
		movimenti[indiceMovimento]=new Movimento(numeroCarta, contante, segno);
		indiceMovimento=(indiceMovimento+1) % movimenti.length;
	}
	
	/*public Movimento[] getListaMovimenti() {
		int contaMovimenti=0;
		Object movimenti;
		for(Movimento movimento : movimenti) {
			if(movimento!=null) {contaMovimenti++;}
		}
		
		int indiceMovimento;
		int indiceMovimentoIniziale=indiceMovimento;
		Movimento[] listaMovimenti=new Movimento[contaMovimenti];
		
	}*/
}