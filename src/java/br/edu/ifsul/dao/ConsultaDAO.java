/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.trabalho.Consulta;
import java.io.Serializable;

/**
 *
 * @author Ariel
 */
public class ConsultaDAO<T> extends DAOGenerico<Consulta> implements Serializable{
    public ConsultaDAO(){
        super();
        super.setClassPersistente(Consulta.class);
        super.setOrdem("id");
        
    }
}
