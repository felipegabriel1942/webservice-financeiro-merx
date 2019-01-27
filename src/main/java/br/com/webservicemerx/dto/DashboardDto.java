package br.com.webservicemerx.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class DashboardDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private List<Double> despesaMesAMes;	
	
	@Getter
	@Setter
	private List<Double> receitaMesAMes;
	
	@Getter
	@Setter
	private List<Double> despesaPorTipo;
	
	
	
}
