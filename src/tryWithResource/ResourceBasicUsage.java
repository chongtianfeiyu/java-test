package tryWithResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
/**
 * try-resource 实现了AutoCloseable借口,才可以使用
 * @author linzf
 */
public class ResourceBasicUsage {
	public String readFile(String path) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(String.format("%n"));
			}
			return builder.toString();
		}
	}
	
	@Test
	public void test1() throws IOException{
		String str = readFile("C:/Users/Administrator.ZX-201703241344/Desktop/test.txt");
		System.out.println(str);
	}
}
