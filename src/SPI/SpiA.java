package SPI;

public class SpiA implements Spi{
	static{
		Api.register("a", SpiA.class);
	}
	
	@Override
	public void send(String msg) {
		System.out.println("spiA:"+msg);
	}

}
