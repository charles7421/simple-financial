package br.com.ux.controller;

import br.com.ux.util.Conexao;
import java.util.List;

/**
 *
 * @author Renato
 */
public class FacadeEJB<T> extends Conexao {

    private Class<T> entityClass;

    public FacadeEJB(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void Salvar(T t) {
        em.getEntityManagerFactory().getCache().evictAll();
        em.persist(t);
    }

    public void Atualizar(T t) {
        em.getEntityManagerFactory().getCache().evictAll();
        em.merge(t);
    }

    public void Excluir(T t, Integer id) {
        em.getEntityManagerFactory().getCache().evictAll();
        t = em.getReference(entityClass, id);
        em.remove(t);
    }

    public T Selecionar(T t) {
        em.getEntityManagerFactory().getCache().evictAll();
        return em.find(entityClass, t);
    }

    public T SelecionarPorID(Integer t) {
        em.getEntityManagerFactory().getCache().evictAll();
        return em.find(entityClass, t);
    }

    public List<T> ListarTodos() {
        em.getEntityManagerFactory().getCache().evictAll();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
    
    public int Contar() {
        em.getEntityManagerFactory().getCache().evictAll();
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
