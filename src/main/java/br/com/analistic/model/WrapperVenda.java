package br.com.analistic.model;

import java.math.BigDecimal;

public class WrapperVenda {
	private String name;
	private Integer itemId;
	private BigDecimal totalVEnda;
	
	public static class Builder {
		private String name;
		private Integer itemId;
		private BigDecimal totalVEnda;
		
		public Builder name(String val) {
			this.name = val;
			return this;
		}
		
		public Builder totalVEnda (BigDecimal val) {
			this.totalVEnda = val;
			return this;
		}
		
		public Builder itemId(Integer val) {
			this.itemId = val;
			return this;
		}
		public WrapperVenda build() {
			return new WrapperVenda(this);
		}
	}
	private WrapperVenda(Builder builder) {
		this.name = builder.name;
		this.itemId = builder.itemId;
		this.totalVEnda = builder.totalVEnda;
	}
	
}
