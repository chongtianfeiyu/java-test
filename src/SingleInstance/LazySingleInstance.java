package SingleInstance;

public class LazySingleInstance {
	private LazySingleInstance() {
	}

	private static LazySingleInstance instance = null;

	public static LazySingleInstance getInstance() {
		if (instance == null) {
			synchronized (LazySingleInstance.class) {
				if (instance == null) {
					instance = new LazySingleInstance();
				}
			}
		}
		return instance;
	}
}
