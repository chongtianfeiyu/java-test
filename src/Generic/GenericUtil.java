package Generic;

public class GenericUtil {
	
	public static  <T> T getObject(Class<T> t) throws InstantiationException, IllegalAccessException{
		T t2 = t.newInstance();
		return t2;
	}
}
