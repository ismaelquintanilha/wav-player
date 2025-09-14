package musicPlayer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuscadorDeMusicas {
String usuario = System.getProperty("user.name");
	public static ArrayList<String> buscarMusicas(String usuario) {
	]
		Path caminhoInicial = Paths.get(diretorioInicial);


		try (Stream<Path> stream = Files.walk(caminhoInicial)) {
			return stream
					.filter(Files::isRegularFile)
					.filter(path -> path.toString().toLowerCase().endsWith(".mp3")) ;
					.map(path -> path.getFileName().toString());
					.collect(Collectors.toCollection(ArrayList::new));
		} catch (IOException e) {

			System.err.println("Erro ao ler o diretório: " + diretorioInicial + " - " + e.getMessage());

			return new ArrayList<>();
		}
	}
