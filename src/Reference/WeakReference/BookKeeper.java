package Reference.WeakReference;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//图书管理员
public class BookKeeper {
	// 书名对应多个借阅者
	// 如果将HashMap -> WeakHashMap 可以解决潜在问题，因为强引用使得，books存在时，内部的Book都无法被回收
	private Map<Book, Set<User>> books = new HashMap<>();

	// 借阅操作
	public void borrowBook(Book book, User user) {
		Set<User> users = null;
		if (books.containsKey(book)) {
			users = books.get(book);
		} else {
			users = new HashSet<User>();// 使用了强引用，这会导致使用完之后，垃圾回收器无法回收
			books.put(book, users);
		}
		users.add(user);
	}

	// 还书操作
	public void returnBook(Book book, User user) {
		if (books.containsKey(book)) {
			Set<User> users = books.get(book);
			users.remove(user);
		}
	}
}
