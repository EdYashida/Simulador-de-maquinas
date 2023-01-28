import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Leitor {
    
    public static String leitor(String path, int lin) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader(path));
                Path arq = Paths.get(path);
		List<String> linha = Files.readAllLines(arq);
             
	
                        return linha.get(lin);
		              
	}
    public static String[] leitorMaisDUm(String path, int lin) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader(path));
                Path arq = Paths.get(path);
		List<String> linha = Files.readAllLines(arq);
             
	
                        return linha.get(lin).split(";");
		              
	}
    public void escrever(String path, List<String> resultado) throws IOException{
        Path arq = Paths.get(path);
        Files.write(arq, resultado);
    }
    
}
