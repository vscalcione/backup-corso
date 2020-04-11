package it.intersistemi.corsojava.esercitazioni.datamanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContoCorrente {
	private int numeroConto;
	private String intestatario;
    private BancomatEsercizio[] carte = new BancomatEsercizio[3];
	private double saldo;
	
	public ContoCorrente(int numeroConto, String intestatario) {
		super();
		this.numeroConto = numeroConto;
		this.intestatario = intestatario;
	}
	public ContoCorrente(int numeroConto, String intestatario, double saldo) {
		this.numeroConto= numeroConto;
		this.intestatario= intestatario;
		this.saldo= saldo;
		}
		
		/*
		 * arrayCarte[0]= new BancomatEsercizio(455,123);
		 *arrayCarte[1]= new BancomatEsercizio(666,345);
		 *arrayCarte[2]= new BancomatEsercizio(777,678);
         */	
	public int getNumeroConto() {
		return numeroConto;
	}
	public void setNumeroConto(int numeroConto) {
		this.numeroConto = numeroConto;
	}
	public String getIntestatario() {
		return intestatario;
	}
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean aggiungiCarta(BancomatEsercizio bancomat) {
		 if(bancomat != null)	{
			 for(int i=0 ; i< carte.length; i++) {
				 if(carte[i] == null) {
					 carte[i] = bancomat;
				 return true;
				 }
			 }
		 }
		 return false;
	}
	private BancomatEsercizio trovaBancomat(int numeroCarta){
		for(int i= 0; i < carte.length; i++) {
			if(carte[i] != null && carte[i].getNumeroCarta() == numeroCarta) {
				return carte[i];
			}
		}
			return null;
			}
	
	public boolean prelevaDaAtm(int nCarta, int pinCarta, int contante) {
		if( contante > 0) {
			BancomatEsercizio bancomat = trovaBancomat(nCarta);
			if(bancomat != null) {
				if(bancomat.getPin() == pinCarta) {
					if(contante <= saldo) {
						saldo = saldo - contante;
						return true;
					}
						
					}
				}
			}
			return false;         
	}

		
		
		public boolean depositaDaAtm(int nCarta, int pinCarta, int contante) {
				BancomatEsercizio bancomat = trovaBancomat(nCarta);
				if(bancomat != null) {
					if(bancomat.getPin() == pinCarta) {
						if( contante > 0) {
							saldo = saldo+ contante;
						}
					return true;
				}
		}

                  return false;
		}
}
    



							
				
						
		
				

	

	
		
		
	

	
		
		
	        	


	
	
