/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ConsultaDAO;
import br.edu.ifsul.dao.PacienteDAO;
import br.edu.ifsul.dao.MedicoDAO;
import br.edu.ifsul.trabalho.Consulta;
import br.edu.ifsul.trabalho.Exame;
import br.edu.ifsul.trabalho.Paciente;
import br.edu.ifsul.trabalho.Medico;
import br.edu.ifsul.util.UtilMensagens;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ariel
 */
@ManagedBean(name = "controleConsulta")
@SessionScoped // ciclo de vida de sessão
public class ControleConsulta implements Serializable{

    private ConsultaDAO<Consulta> dao;
    private Consulta objeto;
    private PacienteDAO<Paciente> pacienteDao;
    private MedicoDAO<Medico> medicoDao;
    private Exame exame;
    private Boolean novoExame;
    
    public ControleConsulta() {
        dao = new ConsultaDAO<>();
        pacienteDao = new PacienteDAO<>();
        medicoDao = new MedicoDAO<>();
    }

    public void novoExame(){
        exame = new Exame();
        novoExame = true;
    }
    
    public void alterarExame(int Index){
        exame = objeto.getExame().get(Index);
        novoExame = false;
    }
    
    public void removerExame(int Index){
        objeto.removerExame(Index);
        UtilMensagens.mensagemInformação("Exame Removido Com Sucesso");
    }
    
    public void salvarExame(){
        if(novoExame){
            objeto.adicionarExame(exame);
        }
        UtilMensagens.mensagemInformação("Operação executada com sucesso!");
    }
    
    public String listar(){
        return "/privado/consulta/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Consulta();
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
    
    public ConsultaDAO getDao() {
        return dao;
    }

    public void setDao(ConsultaDAO dao) {
        this.dao = dao;
    }

    public Consulta getObjeto() {
        return objeto;
    }

    public void setObjeto(Consulta objeto) {
        this.objeto = objeto;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Boolean getNovoExame() {
        return novoExame;
    }

    public void setNovoExame(Boolean novoExame) {
        this.novoExame = novoExame;
    }

    public PacienteDAO<Paciente> getPacienteDao() {
        return pacienteDao;
    }

    public void setPacienteDao(PacienteDAO<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public MedicoDAO<Medico> getMedicoDao() {
        return medicoDao;
    }

    public void setMedicoDao(MedicoDAO<Medico> medicoDao) {
        this.medicoDao = medicoDao;
    }

    
}
