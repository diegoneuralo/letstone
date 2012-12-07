package br.com.letstone.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "banda", schema = "letstone", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
@NamedQueries({ @NamedQuery(name = Banda.GET_POR_NOME, query = "select b from Banda b where upper(b.nome) like :nome") })
public class Banda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected static final String GET_POR_NOME = "Banda.getPorNome";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
