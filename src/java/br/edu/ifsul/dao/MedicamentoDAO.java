/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.trabalho.Medicamento;
import java.io.Serializable;

/**
 *
 * @author Ariel
 */
public class MedicamentoDAO<T> extends DAOGenerico<Medicamento> implements Serializable{
    public MedicamentoDAO(){
        super();
        super.setClassPersistente(Medicamento.class);
        super.setOrdem("nome");
        
    }
}
