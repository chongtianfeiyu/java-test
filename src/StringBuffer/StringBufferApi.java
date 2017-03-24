package StringBuffer;

public class StringBufferApi {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("abc");
		System.out.println(s1.append("cde").toString());
		System.out.println(s1.reverse().toString());
	}
}
