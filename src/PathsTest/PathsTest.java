package PathsTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PathsTest {
	@Test
	public void test1() {
		Path path = Paths.get("d:/", "pathtest1/pathtest2/", "win7.txt");
		System.out.println("root:" + path.getRoot());
		System.out.println("filename:" + path.getFileName());
		System.out.println("parent:" + path.getParent());
		System.out.println("nameCount:" + path.getNameCount());
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println("name" + i + ":" + path.getName(i));
		}
		System.out.println("Subpath (0,3): " + path.subpath(0, 3));
		System.out.println(path.toString());
	}

	@Test
	// path转换
	public void test2() {
		Path path = Paths.get("/rafaelnadal/tournaments/2009", "BNP.txt");
		System.out.println("absolutePath:" + path.toAbsolutePath().toString());// /代表从根目录开始
		System.out.println("uri:" + path.toUri().toString());
		try {
			// 转化为真实路径
			Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e) {
			System.out.println("出错");
		}
		// 转换为File
		File file = path.toFile();
		// 合并两个地址
		Path base = Paths.get("d:/", "test1/");
		Path path1 = base.resolve("test1.txt");
		System.out.println("resolvePath:" + path1.toString());// d:\test1\test1.txt
		Path path2 = path1.resolveSibling("test2.txt");
		System.out.println("resolveSiblingPath:" + path2.toString());// d:\test1\test2.txt

	}

	@Test
	// 导航到其他地址
	public void test3() {
		Path path1 = Paths.get("/tournaments/2009/BNP.txt");
		Path path2 = Paths.get("/tournaments/2011");
		Path path1ToPath2 = path1.relativize(path2);//
		Path path2ToPath1 = path2.relativize(path1);
		System.out.println("path1:" + path1 + "\npath2:" + path2);
		System.out.println("path1ToPath2:" + path1ToPath2);
		System.out.println("path2ToPath1:" + path2ToPath1);
	}

	@Test
	public void test4() {
		// 比较地址
		Path path01 = Paths.get("/rafaelnadal/tournaments/2009/BNP.txt");
		Path path02 = Paths.get("e:/rafaelnadal/tournaments/2009/BNP.txt");
		if (path01.toAbsolutePath().equals(path02)) {
			System.out.println("The paths are equal!");
		} else {
			System.out.println("The paths are not equal!"); // true
		}
		// 判断是否为同一个文件
		try {
			boolean check = Files.isSameFile(path01, path02);
			if (check) {
				System.out.println("The paths locate the same file!"); // true
			} else {
				System.out.println("The paths does not locate the same file!");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		boolean sw = path01.startsWith("/rafaelnadal/tournaments");
		boolean ew = path01.endsWith("BNP.txt");
		System.out.println(sw);  //output:  true
		System.out.println(ew);  //output:  true 
	}
}
