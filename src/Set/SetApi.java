package Set;

import java.util.HashSet;
import java.util.Set;

public class SetApi {
	public static void main(String[] args) {
		//使用set自定义判断相等，需要重写hashCode()和equals()
		Set<Student> set = new HashSet<Student>();
		Student s1 = new Student("andy1",1);
		set.add(s1);
		Student s2 = new Student("andy2",2);
		set.add(s2);
		System.out.println(set);
		Student s3 = new Student("andy1",1);
		set.add(s3);
		System.out.println(set);
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
	}
}
