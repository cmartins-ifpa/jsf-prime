package beans.testes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
 
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class Bean {
	private Date dataNasc;
	private String nome;
	private String password;
	private Integer numeroInf;
	private String fone;
    private String txt1;
    private String console;
    private String console2;
    
    // metodos para tratar o evento de autocompletar  
    public List<String> completeText(String query) {
    	// gera uma lista numerada de 0 a 10 com o texto digitado
        List<String> results = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }        
        return results;
    }
    
	// getters e setters das propriedades/atributos
	public String getNome() { return nome; 	}
	public void setNome(String nome) { this.nome = nome; }
	public String getPassword() { return password; 	}
	public void setPassword(String senha) { this.password = senha; }
	public Integer getNumeroInf() {
		return numeroInf;
	}

	
	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setNumeroInf(Integer numeroInf) {
		this.numeroInf = numeroInf;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getTxt1() {
		return txt1;
	}
	public void setTxt1(String txt1) {
		System.out.println("set Txt1 = "+txt1);
		this.txt1 = txt1;
	}

	public String getConsole2() {
		return console2;
	}

	public void setConsole2(String console2) {
		this.console2 = console2;
	}
 
}
