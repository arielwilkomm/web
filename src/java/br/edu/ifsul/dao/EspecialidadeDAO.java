/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.trabalho.Especialidade;
import java.io.Serializable;

/**
 *
 * @author Ariel
 */
public class EspecialidadeDAO<T> extends DAOGenerico<Especialidade> implements Serializable{
    public EspecialidadeDAO(){
        super();
        super.setClassPersistente(Especialidade.class);
        super.setOrdem("descricao");
        
    }
}
