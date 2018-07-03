package br.com.analistic.model;

public class ClienteModel {
	private Integer code;
	private String cnpj;
	private String nameBusinessArea;
	
	public static class Builder {
		public Builder() {}
		
		private Integer code;
		private String cnpj;
		private String nameBusinessArea;
		
		public Builder code(Integer val) {
			this.code = val;
			return this;
		}
		public Builder cnpj(String val) {
			this.cnpj = val;
			return this;
		}
		public Builder nameBusinessArea(String val) {
			this.nameBusinessArea = val;
			return this;
		}
		
		public ClienteModel build() {
			return new ClienteModel(this);
		
		}
	}
	private ClienteModel(Builder builder) {
		this.code = builder.code;
		this.cnpj = builder.cnpj;
		this.nameBusinessArea = builder.nameBusinessArea;
	}
}
