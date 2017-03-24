package tryWithResource;

import org.junit.Test;

public class CustomResource implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("进行资源释放");
	}
	
	public static  void useCustomResource() throws Exception{
		try(CustomResource customResource = new CustomResource()){
			System.out.println("使用资源");
		}
	}
	
	@Test
	public void test1(){
		try {
			CustomResource.useCustomResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
