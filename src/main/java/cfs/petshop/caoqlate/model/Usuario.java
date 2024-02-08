package cfs.petshop.caoqlate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {
	
	@Id
	@SequenceGenerator(
			name = "usuario_id",
			sequenceName = "usuario_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id")
	private Long id;
	
	@NotBlank 
	private String login;
	
	@NotBlank
	private String senha;
	
	//Caso o usuário seja um cliente = 1; adm=2;
	private int tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return String.format("Usuario [id=%s, login=%s, senha=%s, tipo=%s]", id, login, senha, tipo);
	}
	
	
}
