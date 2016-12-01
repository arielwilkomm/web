/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.MedicamentoDAO;
import br.edu.ifsul.trabalho.Medicamento;
import br.edu.ifsul.util.UtilMensagens;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ariel
 */
@ManagedBean(name = "controleMedicamento")
@SessionScoped // ciclo de vida de sessão
public class ControleMedicamento implements Serializable{

    private MedicamentoDAO<Medicamento> dao;
    private Medicamento objeto;
    
    public ControleMedicamento() {
        dao = new MedicamentoDAO<>();
    }
    
    public String listar(){
        return "/privado/medicamento/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Medicamento();
    }
    
    public void salvar(){
        boolean persistiu;
        if(objeto.getId()==null){
            persistiu = dao.persist(objeto);
        }else{
            persistiu = dao.merge(objeto);
        }
                
        if(persistiu){
            UtilMensagens.mensagemInformação(dao.getMensagem());
        }else{
            UtilMensagens.mensagem(dao.getMensagem());
        }
    }

    
    public void editar(Integer id){
        objeto = dao.localizar(id);
    }
    
    public void remover(Integer id){
        objeto = dao.localizar(id);
        if(dao.remove(objeto)){
            UtilMensagens.mensagemInformação(dao.getMensagem());
        }else{
            UtilMensagens.mensagem(dao.getMensagem());
        }
    }
    
    public MedicamentoDAO getDao() {
        return dao;
    }

    public void setDao(MedicamentoDAO dao) {
        this.dao = dao;
    }

    public Medicamento getObjeto() {
        return objeto;
    }

    public void setObjeto(Medicamento objeto) {
        this.objeto = objeto;
    }
    
}
