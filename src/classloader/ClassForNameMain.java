package classloader;

public class ClassForNameMain {
	public void classForNameVsLoader() throws ClassNotFoundException {
		String className = "classloader.ClassForNameTest";
		Class<?> clazz1 = Class.forName(className);// 会进行类初始化
		ClassLoader loader = this.getClass().getClassLoader();
		Class<?> clazz2 = loader.loadClass(className);
	}

	public static void main(String[] args) {
		ClassForNameMain main = new ClassForNameMain();
		try {
			main.classForNameVsLoader();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
