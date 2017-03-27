package Reference.SoftReference;

import java.lang.ref.SoftReference;

import org.junit.Test;

public class SoftReferenceTest {

	@Test
	public void test1() {
		Object obj = new Object();
		SoftReference<Object> reference = new SoftReference<Object>(obj);
		obj = null;// 创建了软引用
	}

	@Test
	public void test2() {
		Student obj = new Student("andy", 12);
		SoftReference<Student> reference = new SoftReference<Student>(obj);
		obj = null;// 创建了软引用
		Student student = reference.get();
		System.out.println(student.getName());
	}
}
