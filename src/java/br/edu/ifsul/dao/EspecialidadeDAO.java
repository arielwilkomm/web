/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.trabalho.Especialidade;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import static java.lang.reflect.Array.set;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.eclipse.jdt.internal.compiler.impl.Constant;

/**
 *
 * @author Ariel
 */
public class EspecialidadeDAO implements Serializable{
    private Especialidade objetoselecionado;
    private String mensagem = "";
    private EntityManager em;

    public EspecialidadeDAO() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    public boolean validaObjeto(Especialidade obj){
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Especialidade>> erro = validador.validate(obj);
        if(erro.size() > 0){
            mensagem = "";
            mensagem += "Erro:<BR>";
            for (ConstraintViolation<Especialidade> erros : erro){
                mensagem += "Erro "+ erros.getMessage()+"<BR>";
            }
            return false;
        } else {
            return true;
        }
    }
    
    public List<Especialidade> getLista(){
        
        return em.createQuery("from Especialidade order by descricao").getResultList();
    }
    
    public boolean salvar(Especialidade obj){
        try {
            em.getTransaction().begin();
            if(obj.getId() == null){
                em.persist(obj);
            } else {
                em.merge(obj);
            }
            em.getTransaction().commit();
            mensagem = "Sucesso";
            return true;
       } catch (Exception e) {
           if(em.getTransaction().isActive() == false){
               em.getTransaction().begin();
           }
           em.getTransaction().rollback();
           mensagem = "Erro"+Util.getMensagemErro(e);
           return false;
        }
    }
    
    public boolean remover(Especialidade obj){
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            mensagem = "Removido";
            return true;
       } catch (Exception e) {
           if(em.getTransaction().isActive() == false){
               em.getTransaction().begin();
           }
           em.getTransaction().rollback();
           mensagem = "Erro"+Util.getMensagemErro(e);
           return false;
        }
    }
    
    public Especialidade localizar(Integer id){
        return  em.find(Especialidade.class, id);
    }

    public Especialidade getObjetoselecionado() {
        return objetoselecionado;
    }

    public void setObjetoselecionado(Especialidade objetoselecionado) {
        this.objetoselecionado = objetoselecionado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
