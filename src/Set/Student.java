package Set;

public class Student {
	private String name;
	private Integer id;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return this.name + "," + this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) {
			return false;
		}
		Student su = (Student) obj;
		return this.name.equals(su.name) && this.id == su.id;
	}
	
	
	@Override
	public int hashCode() {
		return name.hashCode()+id.hashCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
