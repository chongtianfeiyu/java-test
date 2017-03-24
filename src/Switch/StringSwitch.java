package Switch;

import org.junit.Test;

/**
 * jdk1.7 ʹ��case����ʹ���ַ�������ʵ������ʹ��hashcode+equal
 * ���ǿ���ʹ��enum���������
 * @author linzf
 */
public class StringSwitch {

	@Test
	// ����ǰ
	public void test1() {
		String sex = "";
		switch (sex) {
		case "��":// ����"\u7537"���е�Unicode��ʾ
			System.out.println("�����е�");
			break;
		case "Ů":
			System.out.println("����Ů��");
			break;
		default:
			System.out.println("�ұ����ҵ��Ա�");
			break;
		}
	}

	@Test
	// �����
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
			System.out.println("�����е�");
			break;
		case 1:
			System.out.println("����Ů��");
			break;
		default:
			System.out.println("�ұ����ҵ��Ա�");
			break;
		}
	}
}
