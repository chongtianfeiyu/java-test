package basic.Integer;

public class IntegerApi {
	public static void main(String[] args) {
		/*
		 * Integer i1 = new Integer(10); System.out.println(i1.toString());
		 * System.out.println(Integer.toBinaryString(123));
		 * System.out.println(Integer.parseInt("123"));
		 * System.out.println(Integer.valueOf("12345"));
		 */
		// ����ת��
		// (1) int --> Integer
		int num = 20;
		Integer i1 = new Integer(num);
		Integer i2 = Integer.valueOf(num);
		// (2) Integer --> int
		Integer i3 = new Integer(20);
		int num2 = i3.intValue();
		// (3) int --> String
		int num3 = 20;
		String s1 = String.valueOf(num3);
		String s2 = num3+"";
		String s3 = Integer.toString(20);
		// (4) String --> int
		String s4 = "123";
		int num4 = Integer.parseInt(s4);
		//��ת��ΪInteger�ڱ�Ϊint
		Integer i4 = new Integer(s4);
		//��
		Integer i5 = Integer.valueOf(s4);
		int num5 = i4.intValue();
		int num6 = i5.intValue();
	}
}
