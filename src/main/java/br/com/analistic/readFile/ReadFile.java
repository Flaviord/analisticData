package br.com.analistic.readFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.analistic.operation.Operation;

public class ReadFile {
	public static List<Path> filePathList(String directory) throws IOException {
		List<Path> filePaths = new ArrayList<>();
		DirectoryStream<Path> directorySystem = Files.newDirectoryStream(FileSystems.getDefault().getPath(directory));
		 directorySystem.forEach(a -> filePaths.add(a));
		 return filePaths;
	}
	
	public static List<Path> arquivoData(List<Path> filePaths) {
		return filePaths.stream().filter(i -> i.getFileName().toString().endsWith(".dat")).collect(Collectors.toList());
	}
	
	public static List<String> readLines (Path path) {
		Charset charset = Charset.forName("UTF-8");
		try {
			List<String> lines = Files.readAllLines(path,charset);
			return lines;
		}catch(IOException e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public static void writeLines(Path path,Operation operacoes) {
		Charset charset = Charset.forName("UTF-8");
		try {
		String arquivoSaida = System.getenv().get("HOME")+"/data/out/";
		File n = new File(arquivoSaida+path.getFileName());
		File rename = new File(arquivoSaida+ renameFile( path.getFileName().toString() )+".done.dat");
		n.renameTo(rename);
		
		Files.write(Paths.get(rename.getPath()), ("Total Clientes :"+operacoes.getTotalCliente().toString()+System.lineSeparator()).getBytes(charset) );
		Files.write(Paths.get(rename.getPath()), ("Total Vendedores :"+operacoes.getTotalVendedor().toString()+System.lineSeparator()).getBytes(charset) ,StandardOpenOption.APPEND);
		Files.write(Paths.get(rename.getPath()), ("Id Venda Mais Cara :"+operacoes.getIdVendaMaisCara().toString()+System.lineSeparator()).getBytes(charset) ,StandardOpenOption.APPEND);
		Files.write(Paths.get(rename.getPath()), ("Nome pior vendedor :"+operacoes.getNamePiorVendedor().toString()+System.lineSeparator()).getBytes(charset) ,StandardOpenOption.APPEND);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private static String renameFile(String nameFile) {
		return nameFile.replace(".dat", "");
	}
}
