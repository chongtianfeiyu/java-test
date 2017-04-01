package serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterUser {
	public void write(User user) throws IOException {
		Path path = Paths.get("user.bin");// 相当于项目目录下的user.bin文件
		System.out.println(path.toAbsolutePath());
		try (ObjectOutputStream output = new ObjectOutputStream(
				Files.newOutputStream(path))) {
			output.writeObject(user);
		}
	}

	public static void main(String[] args) throws IOException{
         WriterUser writerUser = new WriterUser();
         User user = new User("Alex","alex@example.org");
         writerUser.write(user);
    }
}
