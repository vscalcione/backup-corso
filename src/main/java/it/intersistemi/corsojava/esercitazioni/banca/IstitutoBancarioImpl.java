package it.intersistemi.corsojava.esercitazioni.banca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IstitutoBancarioImpl implements IstitutoBancario {
	String nome;
	String abi;
	String cab;
	Map<Integer, ContoCorrente> contiCorrenti= new HashMap<Integer, ContoCorrente>();
	int contatoreNumeroConto;
	
	
	public IstitutoBancarioImpl(String nome, String abi, String cab) {
		this.abi= abi;
		this.cab= cab;
		this.nome= nome;
	}

	@Override
	public int aggiungiContoCorrente(String nomeIntestatario, String cognomeIntestatario)
			throws ContoCorrenteException {
		ContoCorrente contoCorrente= new ContoCorrente(nomeIntestatario, cognomeIntestatario, contatoreNumeroConto);
		contiCorrenti.put(contatoreNumeroConto, contoCorrente); 
		int contatore = contatoreNumeroConto++;
		return contatore;
	}

	@Override
	public int aggiungiContoCorrente(String nomeIntestatario, String cognomeIntestatario, double saldoIniziale)
			throws ContoCorrenteException {
		ContoCorrente contoCorrente= new ContoCorrente(nomeIntestatario, cognomeIntestatario, contatoreNumeroConto, saldoIniziale);
		contiCorrenti.put(contatoreNumeroConto, contoCorrente);
		int contatore = contatoreNumeroConto++;
		return contatore;
	}

	@Override
	public List<ContoCorrente> getListaContoCorrenti() throws ContoCorrenteException {
		List<ContoCorrente> listaContiCorrenti= new ArrayList<>(contiCorrenti.values());
		return listaContiCorrenti;
	}

	@Override
	public ContoCorrente recuperaContoCorrenteByNumero(int numeroConto) throws ContoCorrenteException {
		
		return contiCorrenti.get(numeroConto);
	}

	@Override
	public void preleva(int numeroConto, double ammontare) throws ContoCorrenteException {
		contiCorrenti.get(numeroConto).preleva(ammontare);
		
		}


	@Override
	public void deposita(int numeroConto, double ammontare) throws ContoCorrenteException {
		contiCorrenti.get(numeroConto).deposita(ammontare);
		
		
	}

	@Override
	public void eseguiBonificoBancario(int numeroConto, IstitutoBancario istitutoDestinatario,
			int numeroContoDestinatario, double ammontare) throws ContoCorrenteException {
		this.preleva(numeroContoDestinatario, ammontare);
		istitutoDestinatario.deposita(numeroContoDestinatario, ammontare);
	}

}

