package Utlity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class plyloadconvertor {
	
	public static String generateString(String filename) throws IOException
	{
		String filepath =System.getProperty("user.dir")+"\\resources\\" +filename;
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}

}
