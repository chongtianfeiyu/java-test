package SingleInstance;

public class StaticSingleInstance {
	private static final StaticSingleInstance instance = new StaticSingleInstance();
	//私有化构造函数
	private StaticSingleInstance(){}
	//
	public static StaticSingleInstance getInstance() {
		return instance;
	}
}
