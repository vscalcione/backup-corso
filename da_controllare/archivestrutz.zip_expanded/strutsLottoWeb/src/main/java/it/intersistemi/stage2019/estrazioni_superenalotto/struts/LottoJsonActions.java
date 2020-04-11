package it.intersistemi.stage2019.estrazioni_superenalotto.struts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.HttpParameters;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import it.intersistemi.tirocinio.algoritmi.sestine.GeneratoreSestine;
import it.intersistemi.tirocinio.algoritmi.sestine.Validator;
import it.intersistemi.tirocinio.jdbc.ControlloSestine;

@Result(name = "success", type = "json")
@ParentPackage("json-default")
public class LottoJsonActions extends ActionSupport {

	// attributi
	private int[] sestina;

	public int[] getSestina() {
		return sestina;
	}

	public void setSestina(int[] sestina) {
		this.sestina = sestina;
	}

	// Actions

	// generazione sestina random
	@Action(value = "/random")
	public String random() throws ServletException, IOException {
		sestina = GeneratoreSestine.generaRandom(90);
		return "success";
	}

	// chiamata query di ricerca
	@Action(value="/cerca", interceptorRefs=@InterceptorRef("json"))
	public String doPost()
			throws ServletException, IOException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String jdbcConn = "jdbc:sqlserver://localhost:1433;DatabaseName=archivio1874";
		String user = "sa";
		String password = "Intersistemi2019";

		
		HttpParameters parameters = ActionContext.getContext().getParameters();
		try {
			sestina = sestinaToInt(parameters.toString());
		} catch (NumberFormatException e) {
			sestina = null;

		}
		System.out.println(Arrays.toString(sestina));

		//redirect sestina non valida
		if (sestina == null || (!Validator.inputValido(sestina))) {
			sestina = new int[1];
			sestina[0] = -1;
			return "success";
		}

		try (Connection conn = DriverManager.getConnection(jdbcConn, user, password)) {
			int[] sestinaQuery = sestina;
			sestina = new int[1];
			sestina[0] = ControlloSestine.findSestina(conn, sestinaQuery) ? 1 : 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";

	}

	// altri metodi utili alla pagina
	private int[] sestinaToInt(String sestinaParam) {
		int[] sestina = new int[6];
		sestinaParam = sestinaParam.substring(10, sestinaParam.length() - 2);
		String[] cut;
		try {
			cut = sestinaParam.split(",");
		} catch (PatternSyntaxException e) {
			throw new NumberFormatException();
		}
		// converto il parametro passato come stringa
		for (int i = 0; i < sestina.length; i++) {
			sestina[i] = Integer.parseInt(cut[i]);
		}
		Arrays.sort(sestina);
		return sestina;
	}

}
