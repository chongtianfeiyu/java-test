package clone;

class Counter {
	private int value = 0;

	public void increase() {
		value++;
	}

	public int getValue() {
		return value;
	}
}

class MutableObject implements Cloneable {
	private Counter counter = new Counter();

	public void increase() {
		counter.increase();
	}

	public int getValue() {
		return counter.getValue();
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			throw new Error(e);
		}
	}
}

public class MutableObjectClone {
	public static void cloneObject() {
		MutableObject obj = new MutableObject();
		obj.increase();// 1
		MutableObject cloneObj = (MutableObject) obj.clone();
		cloneObj.increase();// 2
		obj.increase();// 3
		System.out.println(cloneObj.getValue());
	}

	public static void main(String[] args) {
		cloneObject(); // 3
	}
}
