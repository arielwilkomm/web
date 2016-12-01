/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul;

import br.edu.ifsul.*;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.trabalho.Especialidade;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ariel
 */
@FacesConverter(value = "converterEspecialidade")
public class ConverterEspecialidade implements Serializable, Converter{

    //Metodo que converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    
        if(string == null || string.equals("Selecione um resgistro")){
            return null;
        }
        try {
            return EntityManagerUtil.getEntityManager().find(Especialidade.class, Integer.parseInt(string));
        } catch (Exception e) {
            return null;
        }
    }

    //Metodo que converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o == null){
            return null;
        }
        Especialidade obj = (Especialidade) o;
        return obj.getId().toString();
    }
    
}
