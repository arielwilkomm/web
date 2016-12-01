/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.trabalho.Medico;
import java.io.Serializable;

/**
 *
 * @author Ariel
 */
public class MedicoDAO<T> extends DAOGenerico<Medico> implements Serializable{
    public MedicoDAO(){
        super();
        super.setClassPersistente(Medico.class);
        super.setOrdem("crm");
        
    }
}
