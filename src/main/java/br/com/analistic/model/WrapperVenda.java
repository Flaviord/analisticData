package br.com.analistic.model;

import java.math.BigDecimal;

public class WrapperVenda {
	private String name;
	private Integer saleId;
	private BigDecimal totalVEnda;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public BigDecimal getTotalVEnda() {
		return totalVEnda;
	}
	public void setTotalVEnda(BigDecimal totalVEnda) {
		this.totalVEnda = totalVEnda;
	}
	
	public static class Builder {
		private String name;
		private Integer saleId;
		private BigDecimal totalVEnda;
		
		public Builder name(String val) {
			this.name = val;
			return this;
		}
		
		public Builder totalVEnda (BigDecimal val) {
			this.totalVEnda = val;
			return this;
		}
		
		public Builder saleId(Integer val) {
			this.saleId = val;
			return this;
		}
		public WrapperVenda build() {
			return new WrapperVenda(this);
		}
	}
	private WrapperVenda(Builder builder) {
		this.name = builder.name;
		this.saleId = builder.saleId;
		this.totalVEnda = builder.totalVEnda;
	}
	
}
