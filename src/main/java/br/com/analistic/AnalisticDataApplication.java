package br.com.analistic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.analistic.binder.BinderToModel;
import br.com.analistic.model.VendaModel;
import br.com.analistic.operation.Operation;
import br.com.analistic.readFile.ReadFile;

@SpringBootApplication
public class AnalisticDataApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AnalisticDataApplication.class, args);
		
		List<Object> object = new ArrayList<>();
		
		String arquivoEntrada = System.getenv().get("HOME")+"/Sources/";
		String arquivoSaida = System.getenv().get("HOME")+"/Sources/";
		
		List<Path> filePaths = new ArrayList<>();
		filePaths = ReadFile.filePathList(arquivoEntrada);
		ReadFile.arquivoData(filePaths);
		
		List<Path> filteredPaths = ReadFile.arquivoData(filePaths);
		filteredPaths.forEach(a -> ReadFile.readLines(a).stream().forEach(line ->  object.add(BinderToModel.binderToModel(line))));
		
		object.stream().forEach(a -> System.out.println(a));
		
		Operation operacoes = new Operation();
		operacoes.verificaInstancia(object);
		System.out.println("Total Clientes->"+operacoes.getTotalCliente());
		System.out.println("Total Vendendor->"+operacoes.getTotalVendedor());
		   
		
	}
}
