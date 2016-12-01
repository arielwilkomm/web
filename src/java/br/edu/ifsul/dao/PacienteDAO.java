/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.trabalho.Paciente;
import java.io.Serializable;

/**
 *
 * @author Ariel
 */
public class PacienteDAO<T> extends DAOGenerico<Paciente> implements Serializable{
    public PacienteDAO(){
        super();
        super.setClassPersistente(Paciente.class);
        super.setOrdem("nome");
        
    }
}
