package beans.aluno;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped                   
// classe Serializable é obrigatorio para bean de Session
public class AlunoBean implements Serializable {
	private Aluno aluno = new Aluno();
	
	private List<Aluno> listAlunos = new ArrayList<Aluno>();
    public AlunoBean() {
	   // inicializa a lista com alguns alunos
    	this.listAlunos.add(new Aluno("MARCOS PONTES", "01/02/1980"));
    	this.listAlunos.add(new Aluno("PEDRO SANTOS", "22/12/1983"));
    	this.listAlunos.add(new Aluno("KARLA MARQUES", "11/04/1995"));
    	this.listAlunos.add(new Aluno("CARLOS SANTOS", "31/10/1979"));
    	this.listAlunos.add(new Aluno("PAULA SILVA", "11/12/1968"));
    	this.listAlunos.add(new Aluno("ANDRÉ PEREIRA", "11/11/1988"));
    	this.listAlunos.add(new Aluno("LUIZ FREITAS", "11/02/1972"));
    }
	
	  /**
	   * Método que irá simular o cadastro do aluno.
	   * @return página de entrada (aluno.xhtml)
	   */
	  public String adicionarAluno() {
		// adiciona o objeto "aluno" na lista   
	    listAlunos.add(aluno);
		  
		//Cria um formatador de datas para o padrão dd/MM/yyyy.
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    //Envia uma mensagem para a pagina informando que o aluno foi cadastrado 
	    String msg = "Aluno adicionado: " + aluno.getNome() + " - " 
	                 + aluno.getCurso().getNome() + " - " 
	    		     + " Nascido em: " + df.format(aluno.getDataNascimento())
	    		     + " " + aluno.getIdade() + " Anos";
	    FacesMessage fm = new FacesMessage(msg);
	    FacesContext.getCurrentInstance().addMessage("msg", fm);

	    // limpa o objeto para o próximo cadastro.
	    aluno = new Aluno();
	    
	    //Retorna para a página de entrada (aluno.xhtml).
	    return "aluno2primefaces.xhtml";
	  }

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	  
	public List<Aluno> getListAlunos() {
		return listAlunos;
	}
	
}
