package br.com.informaticaf1.models;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "AVALIACOES")
public class Avaliacao extends AbstractPersistable<Short> {

	private static final long serialVersionUID = 1L;

	private Date dataCriacao;
	private Float bracoDireito;
	private Float bracoEsquerdo;
	private Float ombros;
	private Float pescoco;
	private Float cintura;
	private Float coxaDireita;
	private Float coxaEsquerda;
	private Float pernaDireita;
	private Float pernaEsquerda;
	private Float peitoral;
	
	private Usuario usuario;

	@Override
	public void setId(Short id) {

		super.setId(id);
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_criacao", nullable = false, length = 10)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public void setBracoDireito(Float bracoDireito) {
		this.bracoDireito = bracoDireito;
	}

	@Column(name = "braco_direito", nullable = false, length = 3)
	public Float getBracoDireito() {
		return bracoDireito;
	}

	@Column(name = "braco_esquerdo", nullable = false, length = 3)
	public Float getBracoEsquerdo() {
		return bracoEsquerdo;
	}

	public void setBracoEsquerdo(Float bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}

	@Column(name = "ombros", nullable = false, length = 3)
	public Float getOmbros() {
		return ombros;
	}

	public void setOmbros(Float ombros) {
		this.ombros = ombros;
	}

	@Column(name = "percoco", nullable = false, length = 3)
	public Float getPescoco() {
		return pescoco;
	}

	public void setPescoco(Float pescoco) {
		this.pescoco = pescoco;
	}

	@Column(name = "cintura", nullable = false, length = 3)
	public Float getCintura() {
		return cintura;
	}

	public void setCintura(Float cintura) {
		this.cintura = cintura;
	}

	@Column(name = "coxa_direita", nullable = false, length = 3)
	public Float getCoxaDireita() {
		return coxaDireita;
	}

	public void setCoxaDireita(Float coxaDireita) {
		this.coxaDireita = coxaDireita;
	}

	@Column(name = "coxa_esquerda", nullable = false, length = 3)
	public Float getCoxaEsquerda() {
		return coxaEsquerda;
	}

	public void setCoxaEsquerda(Float coxaEsquerda) {
		this.coxaEsquerda = coxaEsquerda;
	}

	@Column(name = "perna_direita", nullable = false, length = 3)
	public Float getPernaDireita() {
		return pernaDireita;
	}

	public void setPernaDireita(Float pernaDireita) {
		this.pernaDireita = pernaDireita;
	}

	@Column(name = "perna_esquerda", nullable = false, length = 3)
	public Float getPernaEsquerda() {
		return pernaEsquerda;
	}

	public void setPernaEsquerda(Float pernaEsquerda) {
		this.pernaEsquerda = pernaEsquerda;
	}

	@Column(nullable = false, length = 3)
	public Float getPeitoral() {
		return peitoral;
	}

	public void setPeitoral(Float peitoral) {
		this.peitoral = peitoral;
	}

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
