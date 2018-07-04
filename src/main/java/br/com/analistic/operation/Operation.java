package br.com.analistic.operation;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.analistic.model.ClienteModel;
import br.com.analistic.model.ProdutoModel;
import br.com.analistic.model.VendaModel;
import br.com.analistic.model.VendedorModel;
import br.com.analistic.model.WrapperVenda;

public class Operation {
	
	private Integer totalCliente = 0;
	private Integer totalVendedor = 0;
	private Integer idVendaMaisCara;
	private String piorVendedor;

	
	@Autowired
	public void verificaInstancia(List<Object> object) {
		List<WrapperVenda> venda = new ArrayList<>();
		for (Object tipo : object) {
			if(tipo instanceof VendedorModel) {
				this.totalVendedor++;
			}
			if(tipo instanceof ClienteModel) {
				this.totalCliente++;
			}
			if(tipo instanceof VendaModel) {
				
				venda.add(new WrapperVenda.Builder()
							.name(((VendaModel) tipo).getSalesmanName())
							.saleId(((VendaModel) tipo).getSaleId())
							.totalVEnda(somaTotal(((VendaModel) tipo).getProduto()))
							.build());				
			}
		}
		//venda.stream().forEach(a -> System.out.println(a.getTotalVEnda() +" "+a.getSaleId()+" "+a.getName()));
		this.idVendaMaisCara = maiorVenda(venda).getSaleId();
		this.piorVendedor = piorVendedor(venda).getName();
	}
	
	private WrapperVenda maiorVenda (List<WrapperVenda> venda) {
		Comparator<WrapperVenda> comparator = Comparator.comparing(WrapperVenda::getTotalVEnda);
		WrapperVenda v = venda.stream().max(comparator).get();
		return v;
	}
	
	private WrapperVenda piorVendedor (List<WrapperVenda> venda) {
		Comparator<WrapperVenda> comparator = Comparator.comparing(WrapperVenda::getTotalVEnda);
		WrapperVenda v = venda.stream().min(comparator).get();
		return v;
	}
	
	public String getNamePiorVendedor() {
		return this.piorVendedor;
	}
	
	public Integer getIdVendaMaisCara() {
		return this.idVendaMaisCara;
	}
	
	private BigDecimal somaTotal(List<ProdutoModel> produto) {
		BigDecimal totalVenda = BigDecimal.ZERO;
		for (ProdutoModel produtoModel : produto) {
			totalVenda.add (produtoModel.getItemPrice().multiply(new BigDecimal(produtoModel.getItemQuantidade())));
		}
		return  totalVenda;
	}
	

	public Integer getTotalCliente() {
		return totalCliente;
	}

	public Integer getTotalVendedor() {
		return totalVendedor;
	}
	
}
