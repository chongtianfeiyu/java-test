package Random;

import java.util.Random;
import java.util.UUID;


public class RandomApi {
	public static void main(String[] args) {
		//int随机数，int范围
		System.out.println(new Random().nextInt());
		//自定义范围,0 到 ~
		System.out.println(new Random().nextInt(10));
		//UUID生成
		System.out.println(UUID.randomUUID().toString().replace("-",""));
	}
}
