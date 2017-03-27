package basic.Set.TreeSet;

public class Student implements Comparable<Student> {
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
		// TODO Auto-generated method stub
		return this.name + "," + this.id;
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
	
	@Override
	public int compareTo(Student o) {
		int num = 0;
		if (!(o instanceof Student)) {
			throw new RuntimeException("����ѧ�����");
		}
		Student su = (Student) o;
		num = this.id - su.id;
		if (num == 0) {
			return this.name.compareTo(su.name);
		}
		return num;
	}


}
