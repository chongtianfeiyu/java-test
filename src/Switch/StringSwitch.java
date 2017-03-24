package Switch;

import org.junit.Test;

/**
 * jdk1.7 使得case可以使用字符串，但实际上是使用hashcode+equal
 * 我们可以使用enum类型来替代
 * @author linzf
 */
public class StringSwitch {

	@Test
	// 编译前
	public void test1() {
		String sex = "";
		switch (sex) {
		case "男":// 其中"\u7537"是男的Unicode表示
			System.out.println("我是男的");
			break;
		case "女":
			System.out.println("我是女的");
			break;
		default:
			System.out.println("我保密我的性别");
			break;
		}
	}

	@Test
	// 编译后
	public void test2() {
		String sex = "";
		byte byte0 = -1;
		switch (sex.hashCode()) {
		case 30007:
			if (sex.equals("\u7537")) {
				byte0 = 0;
			}
			break;
		case 22899:
			if (sex.endsWith("\u5973")) {
				byte0 = 1;
			}
			break;
		}
		switch (byte0) {
		case 0:
			System.out.println("我是男的");
			break;
		case 1:
			System.out.println("我是女的");
			break;
		default:
			System.out.println("我保密我的性别");
			break;
		}
	}
}
