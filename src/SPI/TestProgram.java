package SPI;

public class TestProgram {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		try {
			Class.forName("SPI.SpiA");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Api api = new Api("a");
		api.send("hello");
	}
}
