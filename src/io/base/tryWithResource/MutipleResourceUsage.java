package io.base.tryWithResource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

public class MutipleResourceUsage {
	public void copyFile(String fromPath, String toPath)
			throws FileNotFoundException, IOException {
		try (InputStream input = new FileInputStream(fromPath);
				OutputStream output = new FileOutputStream(toPath)) {
			byte[] buffer = new byte[1024];
			int len = -1;
			while ((len = input.read(buffer)) != -1) {
				output.write(buffer, 0, len);
			}
		}
	}

	@Test
	public void test1() throws FileNotFoundException, IOException {
		copyFile("d:/win7.txt", "d:/win7-test.txt");
	}
}
