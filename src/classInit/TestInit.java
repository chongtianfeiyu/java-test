package classInit;

class Children extends Parent {
	static int c1 = 3;
	int c2 = 4;
	static {
		System.out.println("c1:"+c1);
	}
	{
		System.out.println("c2:"+c2);
	}
	public Children() {
		System.out.println("new Children");
	}
}
class Parent{
	static int p1 = 1;
	int p2 = 2;
	static {
		System.out.println("p1:"+p1);
	}
	{
		System.out.println("p2:"+p2);
	}
	public Parent() {
		System.out.println("new Parent");
	}
}
public class TestInit{
	public static void main(String[] args) {
		Children c = new Children();
	}
}