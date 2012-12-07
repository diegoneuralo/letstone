package br.com.letstone.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "musica", schema = "letstone", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
@NamedQueries({ @NamedQuery(name = Musica.GET_POR_NOME, query = "select m from Musica m where upper(m.nome) like :nome") })
public class Musica implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final String GET_POR_NOME = "Musica.getPorNome";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	private String nome;
	@ManyToOne
	@JoinTable(name = "banda_musica", schema = "letstone", joinColumns = { @JoinColumn(name = "musica_codigo", referencedColumnName = "musica_codigo") }, inverseJoinColumns = { @JoinColumn(name = "banda_codigo", referencedColumnName = "banda_codigo") })
	private Banda banda;
	
	@ManyToOne
	@JoinTable(name = "genero_musica", schema = "letstone", joinColumns = { @JoinColumn(name = "musica_codigo", referencedColumnName = "musica_codigo") }, inverseJoinColumns = { @JoinColumn(name = "genero_codigo", referencedColumnName = "genero_codigo") })
	private Genero genero;

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

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
