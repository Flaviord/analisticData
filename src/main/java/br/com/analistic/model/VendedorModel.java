package br.com.analistic.model;

import java.math.BigDecimal;

public class VendedorModel {
	private Integer code;
	private String cpf;
	private String name;
	private BigDecimal salary;
	
	public static class Builder {
		private Integer code;
		private String cpf;
		private String name;
		private BigDecimal salary;
		
		public Builder () {
			
		}
		public Builder code (Integer val) {
			this.code = val;
			return this;
		}
		public Builder  cpf(String val) {
			this.cpf = val;
			return this;
		}
		public Builder name (String val) {
			this.name = val;
			return this;
		}
		public Builder salary (BigDecimal val) {
			this.salary = val;
			return this;
		}
		
		public VendedorModel build() {
			return new VendedorModel(this);
		}
	}
	
	private VendedorModel(Builder builder) {
		this.code = builder.code;
		this.cpf = builder.cpf;
		this.name = builder.name;
		this.salary = builder.salary;
	}

}
