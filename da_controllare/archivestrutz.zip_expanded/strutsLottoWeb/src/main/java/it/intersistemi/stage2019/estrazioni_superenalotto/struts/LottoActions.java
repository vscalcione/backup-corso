package it.intersistemi.stage2019.estrazioni_superenalotto.struts;

import java.util.Arrays;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


public class LottoActions extends ActionSupport {
	
	//attributi pagina
	private int[] sestina; //sestina da cercare
		
	public int[] getSestina() {
		return sestina;
	}
	
	public void setSestina(int[] sestina) {
		this.sestina = sestina;
	}

	//action
	//caricamento iniziale pagina e indirizzamento alla jsp
	@Action(value="lotto", results = {@Result(name="success",location="jsp/lotto.jsp") })
	public String doGet(){
		sestina = new int[6];
		Arrays.fill(sestina, 1);
		return "success";
	}
}
