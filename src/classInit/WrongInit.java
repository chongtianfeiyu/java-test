package classInit;

class Animal {
	public Animal() {
		int average = 30 / getCount();
	}
	protected int getCount() {
		return 4;
	}
}
class Dog extends Animal {
	private int count;
	public Dog(int count) {
		this.count = count;
	}
	@Override
	public int getCount() {
		return count;
	}

}
public class WrongInit {
	public static void main(String[] args) {
		Dog dog = new Dog(4);
	}
}
