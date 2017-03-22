package Treeset;

import java.util.TreeSet;

public class TreeSetApi {
	public static void main(String[] args) {
		Student s1 = new Student("andy1", 1);
		Student s2 = new Student("andy2", 2);
		Student s3 = new Student("andy3", 1);
		TreeSet<Student> set = new TreeSet<Student>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println(set);
	}
}
