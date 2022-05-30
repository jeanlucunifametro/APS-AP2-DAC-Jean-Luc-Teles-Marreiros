package dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import bean.JogoBean;
import entidade.Jogo;
import util.JPAUtil;


public class JogoDAO {
	//salvar
	public static void salvar(Jogo c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	//editar
	public static void atualizar(Jogo c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(c);//
		em.getTransaction().commit();
		em.close();
		
	}
	//excluir
	public static void deletar(Jogo c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		c = em.find(Jogo.class, c.getId() );
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}
	
	//listar
	public static List<Jogo> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select c from Jogo c");
		List<Jogo> lista = q.getResultList();
		em.close();
		return lista;
	}
	//contar
	public static Long contar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Long count = (Long) em.createQuery("select count(s) from Jogo s").getSingleResult();
		em.close();
		return count;
		
		
		//salvar ou atualizarkkk
		
		
		
	}
}
