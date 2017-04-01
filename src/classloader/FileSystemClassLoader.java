package classloader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemClassLoader extends ClassLoader {
	private Path path;

	public FileSystemClassLoader(Path path) {
		this.path = path;
	}

	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] classData = getClassData(name);
			return defineClass(name, classData, 0, classData.length);
		} catch (IOException e) {
			throw new ClassNotFoundException();
		}
	}

	private byte[] getClassData(String className) throws IOException {
		Path classFilePath = classNameToPath(className);
		return Files.readAllBytes(classFilePath);
	}

	private Path classNameToPath(String className) {
		return path.resolve(className.replace('.', File.separatorChar)
				+ ".class");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Path path = Paths.get("E:/project/eclipse_J2EE/java-test/bin/");
		FileSystemClassLoader classLoader = new FileSystemClassLoader(path);
		Class<?> clazz = classLoader.findClass("classloader.Sample");
		Object object = clazz.newInstance();
		Method method = clazz.getMethod("getName");
		String name  =(String)method.invoke(object);
		System.out.println(name);
	}
}
