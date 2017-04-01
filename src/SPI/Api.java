package SPI;

import java.util.HashMap;

public class Api {
	private static HashMap<String, Class<? extends Spi>> spis = new HashMap<String, Class<? extends Spi>>();
	private String protocol;

	public Api(String protocol) {
		this.protocol = protocol;
	}

	public void send(String msg) throws InstantiationException,
			IllegalAccessException {
		Spi spi = spis.get(protocol).newInstance();
		spi.send("消息发送开始");
		spi.send(msg);
		spi.send("消息发送结束");
	}

	public static void register(String protocol, Class<? extends Spi> cls) {
		spis.put(protocol, cls);
	}
}
