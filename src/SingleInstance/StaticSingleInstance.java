package SingleInstance;

public class StaticSingleInstance {
	private static final StaticSingleInstance instance = new StaticSingleInstance();
	//˽�л����캯��
	private StaticSingleInstance(){}
	//
	public static StaticSingleInstance getInstance() {
		return instance;
	}
}
