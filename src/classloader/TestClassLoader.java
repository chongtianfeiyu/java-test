package classloader;

import org.junit.Test;

public class TestClassLoader {
	public void loadClass() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		ClassLoader current = getClass().getClassLoader();// 获取类加载器
		Class<?> clazz = current.loadClass("java.lang.String");// 加载类
		Object str = clazz.newInstance();// 实例化类
		System.out.println(str.getClass());// class java.lang.String
	}

	public void displayParents() {
		ClassLoader current = getClass().getClassLoader();
		while (current != null) {
			System.out.println(current.toString());
			current = current.getParent();
		}
	}
	
	
	
	@Test
	public void test1() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		loadClass();
		String str = "";
		System.out.println(str.getClass());// class java.lang.String
	}

	@Test
	public void test2() {
		displayParents();
		// 从小到大
		// sun.misc.Launcher$AppClassLoader@1ddd40f3 系统类加载器（应用类加载器）
		// sun.misc.Launcher$ExtClassLoader@28d320d6 扩展类加载器
		// 启动类加载器
	}
	
}
