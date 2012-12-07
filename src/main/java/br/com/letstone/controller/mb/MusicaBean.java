package br.com.letstone.controller.mb;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class MusicaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;  
	  
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
}
