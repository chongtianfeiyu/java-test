package io.multiplexing;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SaveStream {

	private InputStream input;
	private byte data[];

	public SaveStream(InputStream input) {
		data = new byte[0];
		this.input = input;
		save();
	}

	private void save() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte buffer[] = new byte[1024];
		int len = -1;
		try {
			while ((len = input.read(buffer)) != -1)
				output.write(buffer, 0, len);
		} catch (IOException e) {
			System.out.println("存储流出现错误");
		}
		data = output.toByteArray();
	}

	public InputStream getInputStream() {
		return new ByteArrayInputStream(data);
	}

	public static void main(String args[]) throws Exception {
		SaveStream saveSteam = new SaveStream(new FileInputStream(
				"D:/阿里巴巴Java开发手册.pdf"));
		InputStream is1 = saveSteam.getInputStream();
		FileOutputStream os1 = new FileOutputStream("D:/test1.pdf");
		FileOutputStream os2 = new FileOutputStream("D:/test2.pdf");
		int len = -1;
		byte bs[] = new byte[1024];
		while ((len = is1.read(bs)) != -1)
			os1.write(bs, 0, len);
		os1.close();
		is1.close();
		InputStream is2 = saveSteam.getInputStream();
		System.out.println((new StringBuilder("is1=is2? ")).append(is1 == is2)
				.toString());
		while ((len = is2.read(bs)) != -1)
			os2.write(bs, 0, len);
		os2.close();
		is2.close();
	}
}