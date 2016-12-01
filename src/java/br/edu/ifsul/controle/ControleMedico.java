/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.MedicoDAO;
import br.edu.ifsul.dao.EspecialidadeDAO;
import br.edu.ifsul.trabalho.Medico;
import br.edu.ifsul.trabalho.Especialidade;
import br.edu.ifsul.util.UtilMensagens;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ariel
 */
@ManagedBean(name = "controleMedico")
@SessionScoped // ciclo de vida de sessão
public class ControleMedico implements Serializable{

    private MedicoDAO<Medico> dao;
    private EspecialidadeDAO<Especialidade> especialidadeDao;
    private Medico objeto;
    
    public ControleMedico() {
        dao = new MedicoDAO<>();
        especialidadeDao = new EspecialidadeDAO<>();
    }
    
    public String listar(){
        return "/privado/medico/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Medico();
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
    
    public MedicoDAO getDao() {
        return dao;
    }

    public void setDao(MedicoDAO dao) {
        this.dao = dao;
    }

    public Medico getObjeto() {
        return objeto;
    }

    public void setObjeto(Medico objeto) {
        this.objeto = objeto;
    }

    public EspecialidadeDAO<Especialidade> getEspecialidadeDao() {
        return especialidadeDao;
    }

    public void setEspecialidadeDao(EspecialidadeDAO<Especialidade> especialidadeDao) {
        this.especialidadeDao = especialidadeDao;
    }
    
    
    
}
