package it.intersistemi.corsojava.esercitazioni.banca;

import java.util.List;


public interface IstitutoBancario {
	 
	
	
	int aggiungiContoCorrente(String nomeIntestatario, String cognomeIntestatario) throws 
	ContoCorrenteException;

    int aggiungiContoCorrente(String nomeIntestatario, String cognomeIntestatario, 
    		double saldoIniziale) throws ContoCorrenteException;
    
    List<ContoCorrente> getListaContiCorrenti() throws ContoCorrenteException;
    
    ContoCorrente recuperaContoCorrenteByNumero(int numeroConto) throws ContoCorrenteException;
    
    void preleva(int numeroConto, double ammontare) throws ContoCorrenteException;
    
    void deposita(int numeroConto, double ammontare) throws ContoCorrenteException;
    

}
