package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity /*dando referencia para a tabela*/
@Table(name = "tb_postagens") /*Vai criar uma tabela no banco de dados*/
public class Postagens {
	
	@Id /*Declarando a chave primária*/
	@GeneratedValue(strategy = GenerationType.IDENTITY) /*Auto incremento no banco de dados*/
	private Long id;
	
	@NotBlank /*Seria o not null do banco de dados, que precisa ser preenchido, e não aceita espaços*/
	@Size(min = 5 , max = 100) /*Determinada a quantidade de caracteres, sendo o minimo ou máximo*/
	private String titulo;
	
	@NotBlank /*Seria o not null do banco de dados, que precisa ser preenchido, e não aceita espaços*/
	@Size(min = 10 , max = 1000) /*Determinada a quantidade de caracteres, sendo o minimo ou máximo*/
	private String texto;
	
	@UpdateTimestamp /*Atualiza em tempo real*/
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema; 
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
