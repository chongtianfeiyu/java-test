package Process;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.Test;

public class TestProcess {
	
	public void startProcessNormal() throws IOException{
		ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","netstat","-a");
		Process process = pb.start();
		InputStream inputStream = process.getInputStream();
		Files.copy(inputStream, Paths.get("d:/netstat.txt"), StandardCopyOption.REPLACE_EXISTING);
	}
	
	@Test
	public void test1() throws IOException{
		startProcessNormal();
	}
	
	@Test
	public void test2() throws IOException{
		ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c","netstat -a");
		pb.redirectOutput(Redirect.INHERIT);//继承方式
		pb.start();//输出结果，输出在控制台
	}
	
	@Test
	public void test3() throws IOException{
		ProcessBuilder pb = new ProcessBuilder("wmic","process");
		File outFile = Paths.get("d:/tasks.txt").toFile();
		pb.redirectOutput(outFile);
		pb.start();//输出结果，输出在文件中
	}
}
