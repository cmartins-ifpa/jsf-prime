package login;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean {
	private String nome;
	private String senha;

	public String login() {
		if (checkLogin(nome, senha)) {
			// salva o objeto "USUARIO" em tempo de sessão 
			FacesContext.getCurrentInstance().getExternalContext()
			       .getSessionMap().put("USUARIO", nome.toUpperCase());
			// redireciona para a página "home"
			return "home.xhtml";
		}
	    FacesMessage fm = new FacesMessage("Erro! Verifique seu acesso.");
	    FacesContext.getCurrentInstance().addMessage("msg", fm);
		return "login";
	}
	
	// getters e setters das propriedades/atributos
	public String getNome() { return nome; 	}
	public void setNome(String nome) { this.nome = nome; }
	public String getSenha() { return senha; 	}
	public void setSenha(String senha) { this.senha = senha; }

	private boolean checkLogin(String nome2, String senha2) {
		// código para validar a senha
		if (nome2.equalsIgnoreCase("admin") && senha2.equalsIgnoreCase("admin") )
			return true;
		
		return false;
	}


}
