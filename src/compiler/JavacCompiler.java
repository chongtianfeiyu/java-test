package compiler;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavacCompiler {
	public void compile1(Path src, Path output) {
		ProcessBuilder pb = new ProcessBuilder("javac.exe", src.toString(),
				"-d", output.toString());
		try {
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compile2(Path src, Path output) {
		String[] args = new String[]{src.toString(),"-d",output.toString()};
		try {
			PrintWriter out = new PrintWriter(Paths.get("output.txt").toFile());
//			com.sun.tools.javac.Main.compile(args,out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
