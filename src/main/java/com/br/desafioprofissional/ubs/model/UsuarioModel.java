package com.br.desafioprofissional.ubs.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class UsuarioModel implements Serializable{
	
	private static final long serialVersionUID = 5339157997088207310L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idkey")
	private Long id;
	
	private String nome;
	
	private String sobrenome;

	private String email;
	
	private String cpf;
	
	private String bairro;
	
	@Column(name="cartaosus")
	private String cartaoSus;
	
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCartaoSus() {
		return cartaoSus;
	}

	public void setCartaoSus(String cartaoSus) {
		this.cartaoSus = cartaoSus;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cartaoSus, cpf, email, id, nome, senha, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioModel other = (UsuarioModel) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cartaoSus, other.cartaoSus)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha)
				&& Objects.equals(sobrenome, other.sobrenome);
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", cpf="
				+ cpf + ", bairro=" + bairro + ", cartaoSus=" + cartaoSus + ", senha=" + senha + "]";
	}

	public UsuarioModel(Long id, String nome, String sobrenome, String email, String cpf, String bairro,
			String cartaoSus, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
		this.bairro = bairro;
		this.cartaoSus = cartaoSus;
		this.senha = senha;
	}

	public UsuarioModel() {
	}
	
	

}
