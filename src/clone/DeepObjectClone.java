package clone;

class Count implements Cloneable {
	private int value = 0;

	public void increase() {
		value++;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new Error(e);
		}
	}
}

class DeepObject implements Cloneable {
	private Count counter = new Count();

	public void increase() {
		counter.increase();
	}

	public int getValue() {
		return counter.getValue();
	}

	@Override
	public Object clone() {
		DeepObject obj = null;
		try {
			obj = (DeepObject) super.clone();
			obj.counter = (Count) counter.clone();
			return obj;
		} catch (Exception e) {
			throw new Error(e);
		}
	}
}

public class DeepObjectClone {
	public static void cloneObject() {
		DeepObject obj = new DeepObject();
		obj.increase();// 1
		DeepObject cloneObj = (DeepObject) obj.clone();
		cloneObj.increase();// 2
		obj.increase();// 2
		System.out.println(cloneObj.getValue());
	}

	public static void main(String[] args) {
		cloneObject(); // 2
	}
}
