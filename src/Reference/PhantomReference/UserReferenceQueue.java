package Reference.PhantomReference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class UserReferenceQueue {
	private static class ReferenceObject {
		protected void finalize() throws Throwable {
			System.out.println("finalize 被调用");
			super.finalize();
		}
	}

	public static void phantomReferenceQueue() {
		ReferenceQueue<ReferenceObject> queue = new ReferenceQueue<ReferenceObject>();
		ReferenceObject obj = new ReferenceObject();
		PhantomReference<ReferenceObject> phantomRef = new PhantomReference<ReferenceObject>(
				obj, queue);
		obj = null;
		Reference<? extends ReferenceObject> ref = null;
		int i = 0;
		while ((ref = queue.poll()) == null) {
			System.out.println("poll"+(++i));
			System.gc();
		}
		phantomRef.clear();
		System.out.println(ref == phantomRef);
		System.out.println("幽灵引用被清除");
	}
	
	public static void main(String[] args) {
		phantomReferenceQueue();
	}
}
