package io.multiplexing;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamReuse {

	private InputStream is;

	public StreamReuse(InputStream is) {
		if (!is.markSupported())
			this.is = new BufferedInputStream(is);
		else
			this.is = is;
	}

	public InputStream getInputStream() {
		is.mark(0x7fffffff);
		return is;
	}

	public void markUsed() {
		try {
			is.reset();
		} catch (IOException e) {
			System.out.println("流重置失败");
		}
	}

	public static void main(String args[]) throws Exception {
		StreamReuse reuse = new StreamReuse(new FileInputStream(
				"D:/阿里巴巴Java开发手册.pdf"));
		InputStream is1 = reuse.getInputStream();
		FileOutputStream os1 = new FileOutputStream("D:/test1.pdf");
		FileOutputStream os2 = new FileOutputStream("D:/test2.pdf");
		int len = -1;
		byte bs[] = new byte[1024];
		while ((len = is1.read(bs)) != -1)
			os1.write(bs, 0, len);
		os1.close();
		reuse.markUsed();
		InputStream is2 = reuse.getInputStream();
		System.out.println((new StringBuilder("is1=is2? ")).append(is1 == is2)
				.toString());
		while ((len = is2.read(bs)) != -1)
			os2.write(bs, 0, len);
		os2.close();
		is2.close();
	}
}
