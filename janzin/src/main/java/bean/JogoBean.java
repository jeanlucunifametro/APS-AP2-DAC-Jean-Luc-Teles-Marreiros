package bean;

import entidade.Jogo;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import dao.JogoDAO;


@ManagedBean
public class JogoBean {
	private Jogo jogo = new Jogo();
	private int contar;
	private List<Jogo> listar;
	

	public String salvar() {
		try {
			JogoDAO.salvar(jogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
					"jogo " + jogo.getDescricao() + "Salvo com sucesso."));
			jogo = new Jogo();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Erro ao salvar o local"));
		}
		return "listar";
	}
	
	public String testando() {
		JogoDAO.atualizar(jogo);
		return null;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	
	


	public String atualizar() {
		try {
			System.out.println("asdasd");
			JogoDAO.atualizar(jogo);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Local editado com sucesso"));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Erro ao editar o Local"));
		}
		return null;
	}
	
	
	public String excluir() {
		try {
			JogoDAO.deletar(jogo);;
			listar.remove(jogo); 
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Local excluido com sucesso"));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error ao excluir o Local"));
		}
		return null;
	}
	
	public void contar() {
		try {
			Long count = JogoDAO.contar();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "O banco possui " + count + " Locais"));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Erro ao mostrar a quantidade de locais"));
		}
	}
	
	
	public List<Jogo> getListar() {
		if(listar ==  null) {
			listar = JogoDAO.listar();
		}
		return listar;
	}

	public void setListar(List<Jogo> listar) {
		this.listar = listar;
	}
	
	
	public int getContar() {
		return contar;
	}

	public void setContar(int contar) {
		this.contar = contar;
	}

}