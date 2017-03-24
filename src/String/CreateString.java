package String;

public class CreateString {
	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = "ABC";
		byte[] b1 = { 65, 66, 67 };
		String s3 = new String(b1);
		String s4 = new String(b1,1,1);
		char[] c1 = {'A','B','C'};
		String s5 = new String(c1);
		String s6 = new String(c1,1,1);
		System.out.println(s1 + "," + s2 + "," + s3+","+s4+","+s5+","+s6);
	}
}
