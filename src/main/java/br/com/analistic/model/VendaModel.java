package br.com.analistic.model;

import java.util.List;

public class VendaModel {
	private Integer code;
	private Integer saleId;
	private String salesmanName;
	private List<ProdutoModel> produto;
	

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public String getSalesmanName() {
		return salesmanName;
	}
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	public List<ProdutoModel> getProduto() {
		return produto;
	}
	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}
	public static class Builder {
		private Integer code;
		private Integer saleId;
		private String salesmanName;
		private List<ProdutoModel> produto;
		
		public Builder() {}
		
		public Builder code(Integer val) {
			this.code = val;
			return this;
		}
		public Builder saleId(Integer val) {
			this.saleId = val;
			return this;
		}
		public Builder salesmanName(String val) {
			this.salesmanName = val;
			return this;
		}
		public Builder produto(List<ProdutoModel> val) {
			this.produto = val;
			return this;
		}
		public VendaModel build() {
			return new VendaModel(this);
		}
	}
	private VendaModel(Builder builder) {
		this.code = builder.code;
		this.saleId = builder.saleId;
		this.salesmanName = builder.salesmanName;
		this.produto = builder.produto;
	}
}
