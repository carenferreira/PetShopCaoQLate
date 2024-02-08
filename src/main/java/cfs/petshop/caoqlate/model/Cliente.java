package cfs.petshop.caoqlate.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente {
	@Id
	@SequenceGenerator(
			name = "cliente_id",
			sequenceName = "cliente_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_id")
	private Long id;
	private String cpf;
	private String nome;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar datanascimento;
	private String email;
	private String telefone;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Cao> caes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Calendar datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Cao> getCaes() {
		return caes;
	}
	public void setCaes(List<Cao> caes) {
		this.caes = caes;
	}
	
}
