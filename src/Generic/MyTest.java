package Generic;

import org.junit.Test;

public class MyTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Object object = GenericUtil.getObject(Class.forName("Generic.User"));
		User user = (User) object;
		String name = user.getName();
		System.out.println(name);
	}
	@Test
	public void test1(){
		
	}
}
