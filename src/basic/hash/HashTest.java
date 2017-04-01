package basic.hash;

import java.util.Objects;

import org.junit.Test;

public class HashTest {
	@Test
	public void test1() {
		int hash = Objects.hash("hello");
		int hashCode = Objects.hashCode("hello");
		System.out.println("hash: " + hash + ",hashCode: " + hashCode);
	}

	@Test
	public void test2() {
		String str1 = Objects.toString("hello");
		String str2 = "hello";
		String str3 = Objects.toString(null, "hello");// 设置默认值
		System.out.println("str1:" + str1 + ",str2:" + str2 + ",str3:" + str3);
	}
}
