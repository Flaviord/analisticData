package br.com.analistic.model;

import java.math.BigDecimal;

public class ProdutoModel {
	private Integer itemId;
	private Integer itemQuantidade;
	private BigDecimal itemPrice;
	
	public static class Builder {
		private Integer itemId;
		private Integer itemQuantidade;
		private BigDecimal itemPrice;
		
		public Builder() {}
		
		public Builder itemId(Integer val) {
			this.itemId = val;
			return this;
		}
		public Builder itemQuantidade(Integer val) {
			this.itemQuantidade = val;
			return this;
		}
		public Builder itemPrice(BigDecimal val) {
			this.itemPrice = val;
			return this;
		}
		public ProdutoModel build() {
			return new ProdutoModel(this);
		}
	}
	private ProdutoModel(Builder builder) {
		this.itemId = builder.itemId;
		this.itemQuantidade = builder.itemQuantidade;
		this.itemPrice = builder.itemPrice;
	}
}
