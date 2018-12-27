package br.com.webservicemerx.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_despesa")
public class Despesa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	@Column(name="pk_despesa")
	private Integer id;
	
	@Getter
	@Setter
	@Column(name="fk_usuario")
	private Integer fkUsuario;
	
	@Getter
	@Setter
	@Column(name="fk_tipo_despesa")
	private Integer fkTipoDespesa;
	
	@Getter
	@Setter
	private String descricao;
	
	@Getter
	@Setter
	private double valor;
	
	@Getter
	@Setter
	@Column(name="ano_mes")
	private String anoMes;
	
	public Despesa() {

	}
	
	
	public Despesa(Integer id, Integer fkUsuario, Integer fkTipoDespesa, String descricao, double valor,
			String anoMes) {
		this.id = id;
		this.fkUsuario = fkUsuario;
		this.fkTipoDespesa = fkTipoDespesa;
		this.descricao = descricao;
		this.valor = valor;
		this.anoMes = anoMes;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Despesa other = (Despesa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
