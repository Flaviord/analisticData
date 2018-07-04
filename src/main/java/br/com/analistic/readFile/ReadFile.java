package br.com.analistic.readFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public static void writeLines(Path path) {
		Charset charset = Charset.forName("UTF-8");
		try {
			Files.write(path, "novo dado".getBytes());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
