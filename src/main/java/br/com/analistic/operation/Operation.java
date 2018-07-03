package br.com.analistic.operation;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.analistic.model.ClienteModel;
import br.com.analistic.model.VendaModel;
import br.com.analistic.model.VendedorModel;
import br.com.analistic.model.WrapperVenda;

public class Operation {
	
	private Integer totalCliente = 0;
	private Integer totalVendedor = 0;
	private BigDecimal vendaMaisCara;

	
	public void verificaInstancia(List<Object> object) {
		for (Object tipo : object) {
			if(tipo instanceof VendedorModel) {
				this.totalVendedor++;
			}
			if(tipo instanceof ClienteModel) {
				this.totalCliente++;
			}
			if(tipo instanceof VendaModel) {
				//List<WrapperVenda> venda = new ArrayList<>();
				//venda.add(new WrapperVenda.Builder().name().itemId().totalVEnda(new BigDecimal(tipo.)))
			}
		}
	}

	public Integer getTotalCliente() {
		return totalCliente;
	}

	public Integer getTotalVendedor() {
		return totalVendedor;
	}
/*
	private BigDecimal maiorVenda(List<Object> object) {
		//object.stream().filter(o -> (o instanceof VendaModel)).map(m -> m);
		return 1.0L;
	}*/
	
	private String piorVendendor() {
		return " ";
	}
	
}
