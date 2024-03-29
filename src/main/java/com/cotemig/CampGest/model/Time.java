package com.cotemig.CampGest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Time {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cod_time;

	private String nome_time;

	@OneToMany(mappedBy="time")
	private List<Atleta> atletas;

	private Integer pontos;
	private Integer vitorias;
	private Integer derrotas;
	private Integer empates;	
	private Integer gols_pro;
	private Integer gols_contra;
	private Integer gols_saldo;
	private Integer posicao;
	private boolean classificado;


	@ManyToMany(mappedBy="times")
	private List<Partida> partidas;
	
	@ManyToOne
	@JoinColumn(name="campeonato_id", nullable=false)
	private Campeonato campeonato;

	public boolean isClassificado() {
		return classificado;
	}

	public void setClassificado(boolean classificado) {
		this.classificado = classificado;
	}

	public void setGols_saldo(Integer gols_saldo) {
		this.gols_saldo = gols_saldo;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	private void position(){
		if (this.posicao > 0 && this.posicao <= 4){
			this.classificado = true;
		}
	}

	private void setGols_saldo(){
		this.gols_saldo =  gols_pro - gols_contra;
	}
	public Integer getGols_saldo(){
		return this.gols_saldo;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Integer SaldoGols(){
		return gols_pro - gols_contra;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getVitorias() {
		return vitorias;
	}

	public void setVitorias(Integer vitorias) {
		this.vitorias = vitorias;
	}

	public Integer getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(Integer derrotas) {
		this.derrotas = derrotas;
	}

	public Integer getEmpates() {
		return empates;
	}

	public void setEmpates(Integer empates) {
		this.empates = empates;
	}

	public Integer getGols_pro() {
		return gols_pro;
	}

	public void setGols_pro(Integer gols_pro) {
		this.gols_pro = gols_pro;
		setGols_saldo();
	}

	public Integer getGols_contra() {
		return gols_contra;
	}

	public void setGols_contra(Integer gols_contra) {
		this.gols_contra = gols_contra;
		setGols_saldo();
	}

	public Integer getCod_time() {
		return cod_time;
	}
	public void setCod_time(Integer cod_time) {
		this.cod_time = cod_time;
	}
	public List<Atleta> getAtletas() {
		return atletas;
	}
	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}	
	public String getNome_time() {
		return nome_time;
	}
	public void setNome_time(String nome_time) {
		this.nome_time = nome_time;
	}		
}
