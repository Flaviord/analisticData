package br.com.analistic.binder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.analistic.model.ClienteModel;
import br.com.analistic.model.ProdutoModel;
import br.com.analistic.model.VendaModel;
import br.com.analistic.model.VendedorModel;

public class BinderToModel {
	
	//001ç1234567891234çDiegoç50000
	private static VendedorModel bindToVendedorModel(String[] line) {
		return new VendedorModel.Builder().code(Integer.parseInt(line[0])).cpf(line[1]).name(line[2]).salary(new BigDecimal(line[3])).build();
	}
	
	//002çCNPJçNameçBusiness Area
	private static ClienteModel bindToClienteModel(String[] line) {
		return new ClienteModel.Builder().code(Integer.parseInt(line[0])).cnpj(line[1]).nameBusinessArea(line[2]).build();
	}
	
	//003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name
	private static VendaModel bindToVendaModel(String[] line,List<ProdutoModel> produto) {
		VendaModel vendaModel =  new VendaModel.Builder()
				.code(Integer.parseInt(line[0]))
				.saleId(Integer.parseInt(line[1]))
				.produto(produto)
				.salesmanName(line[3]).build();
		return vendaModel;
	}
	
	private static ProdutoModel bindToProdutoModel(String[] line) {
		 return  new ProdutoModel.Builder()
				.itemId(Integer.parseInt(line[0]))
				.itemQuantidade(Integer.parseInt(line[1]))
				.itemPrice(new BigDecimal(line[2]))
				.build();
	}
	
	public static Object binderToModel(String line) {
		String[] dataLine = verificaSeparador(line,"ç");
		
		if(dataLine[0].equals("001")) {
			return bindToVendedorModel(dataLine);
		}
		if(dataLine[0].equals("002")) {
			return bindToClienteModel(dataLine);
		}
		if(dataLine[0].equals("003")) {
			return bindToVendaModel(dataLine, montarDadosProdutoModel(dataLine));
		}
		return null;
	}
	
	private static List<ProdutoModel> montarDadosProdutoModel(String[] val) {
		String[] linePrice = verificaSeparador(patternExp(val[2]),",");
		List<ProdutoModel> produto = new ArrayList<>();
		for (String string : linePrice) {
			produto.add(bindToProdutoModel(verificaSeparador(string, "-")));
		}
		return produto;
	}
	
	private static String[] verificaSeparador(String item,String separador) {
		String[] itens = item.split(separador);
		return itens;
	}
	
	private static String patternExp(String val) {
		String saida = "";
		Pattern pattern = Pattern.compile("([0-9|-|.|,|-])+");
		Matcher match = pattern.matcher(val);
		while(match.find()) saida += match.group();
		return saida;
	}
	
}
