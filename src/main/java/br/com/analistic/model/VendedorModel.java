package br.com.analistic.model;

import java.math.BigDecimal;

public class VendedorModel {
	private Integer code;
	private String cpf;
	private String name;
	private BigDecimal salary;
	
	
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

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
