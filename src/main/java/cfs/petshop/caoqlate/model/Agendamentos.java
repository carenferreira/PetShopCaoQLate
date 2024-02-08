package cfs.petshop.caoqlate.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Agendamentos {
	@Id
	@SequenceGenerator(
			name = "agendamento_id",
			sequenceName = "agendamento_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendamento_id")
	private Long id;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar data;
	
	@ManyToOne
	private Cao cao;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Servicos> servicos = new ArrayList<Servicos>();
	private Double valor;
	private Boolean realizado = false;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Cao getCao() {
		return cao;
	}
	public void setCao(Cao cao) {
		this.cao = cao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Servicos> getServicos() {
		return servicos;
	}
	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Boolean getRealizado() {
		return realizado;
	}
	public void setRealizado(Boolean realizado) {
		this.realizado = realizado;
	}
	
}
