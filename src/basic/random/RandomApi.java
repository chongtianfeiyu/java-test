package basic.random;

import java.util.Random;
import java.util.UUID;


public class RandomApi {
	public static void main(String[] args) {
		//int�����int��Χ
		System.out.println(new Random().nextInt());
		//�Զ��巶Χ,0 �� ~
		System.out.println(new Random().nextInt(10));
		//UUID���
		System.out.println(UUID.randomUUID().toString().replace("-",""));
	}
}
