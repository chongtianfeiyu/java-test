package io.Files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.Test;

public class TestFiles {
	@Test
	public void test1() {
		Path path = Paths.get("d:/win7.txt");
		boolean pathExists = Files.exists(path,
				new LinkOption[] { LinkOption.NOFOLLOW_LINKS });
		System.out.println(pathExists);
	}

	@Test
	public void test2() throws IOException {
		Path path = Paths.get("d:/", "test1/");
		Files.createDirectory(path);// 只能创建单级目录
	}

	@Test
	// 复制
	public void test3() throws IOException {
		Path path1 = Paths.get("d:/win7.txt");
		Path path2 = Paths.get("d:/win7-test.txt");
		// Files.copy(path1, path2);
		Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
	}

	@Test
	// 重命名 或者 移动
	public void test4() throws IOException {
		Path path1 = Paths.get("d:/win7.txt");
		Path path2 = Paths.get("d:/win7-test.txt");
		// Files.copy(path1, path2);
		Files.move(path1, path2, StandardCopyOption.REPLACE_EXISTING);
	}

	@Test
	// 删除
	public void test5() throws IOException {
		Path path1 = Paths.get("d:/win7 - 副本.txt");
		Files.delete(path1);
	}

	@Test
	public void test6() throws IOException {
		Path path1 = Paths.get("d:/MyDrivers");
		Path walkFileTree = Files.walkFileTree(path1, new FileVisitor<Path>() {
			@Override
			public FileVisitResult postVisitDirectory(Path arg0,
					IOException arg1) throws IOException {
				System.out.println("postVisit dir:" + arg0);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult preVisitDirectory(Path arg0,
					BasicFileAttributes arg1) throws IOException {
				System.out.println("preVisit dir: " + arg0);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path arg0, BasicFileAttributes arg1)
					throws IOException {
				System.out.println("visitFile: " + arg0);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path arg0, IOException arg1)
					throws IOException {
				System.out.println("visitFile failed: " + arg0);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	@Test
	// 遍历查找文件
	public void test7() {
		Path rootPath = Paths.get("d:/MyDrivers");
		try {
			Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attrs) throws IOException {
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	// 遍历删除文件
	public void test8() {
		Path rootPath = Paths.get("d:/MyDrivers - 副本");
		try {
			Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attrs) throws IOException {
					System.out.println("delete file: " + file.toString());
					Files.delete(file);
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir,
						IOException arg1) throws IOException {
					Files.delete(dir);
					System.out.println("delete dir: " + dir.toString());
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
