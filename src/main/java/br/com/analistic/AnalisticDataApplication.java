package br.com.analistic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.analistic.binder.BinderToModel;
import br.com.analistic.operation.Operation;
import br.com.analistic.readFile.ReadFile;

@SpringBootApplication
public class AnalisticDataApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AnalisticDataApplication.class, args);
	
		while (true) {
	
		List<Object> object = new ArrayList<>();
		
		String arquivoEntrada = System.getenv().get("HOME")+"/data/in/";
		
		List<Path> filePaths = new ArrayList<>();
		filePaths = ReadFile.filePathList(arquivoEntrada);
		
		if (!filePaths.isEmpty()) {
			List<Path> filteredPaths = ReadFile.arquivoData(filePaths);
			
			for (Path pathFilesFiltered : filteredPaths) {
				
				ReadFile.readLines(pathFilesFiltered).stream().forEach(line -> object.add(BinderToModel.binderToModel(line)));
				
				Operation operacoes = new Operation();
				operacoes.verificaInstancia(object);
				ReadFile.writeLines(pathFilesFiltered,operacoes);
			}
		}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
		
	}
}
