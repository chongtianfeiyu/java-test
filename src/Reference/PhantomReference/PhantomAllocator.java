package Reference.PhantomReference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/*
 * 幽灵引用来代替finalize，可以防止对象复活
 * 内存受限时，使用幽灵引用，可以把程序内存控制在一定的范围之内
 */
public class PhantomAllocator {
	private byte[] data = null;
	private ReferenceQueue<byte[]> queue = new ReferenceQueue<byte[]>();
	private Reference<? extends byte[]> ref = null;

	public byte[] get(int size) {
		if (ref == null) {
			data = new byte[size];
			ref = new PhantomReference<byte[]>(data, queue);
		} else {
			data = null;
			System.gc();
			try {
				ref = queue.remove();
				ref.clear();
				ref = null;
				System.gc();
				data = new byte[size];
				ref = new PhantomReference<byte[]>(data, queue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
