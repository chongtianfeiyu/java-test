package nio;

import java.nio.ByteBuffer;
/**
 * buffer主要参数
 * 1、capacity 容量 ,设置：buffer.allocate(capacity)，获取:buffer.capacity()
 * 2、limit 缓存限制，设置：buffer.limit(limit),获取：buffer.limit()
 * 3、position 存储的位置，设置：buffer.position(position),获取：buffer.position()
 * 4、存入值,put()、putXxx()，每存入都使得position改变，改变大小，按单位算，下面例子中：byte为单位，所以插入char，移动2个字节
 * 5、postion -> 0，flip()方法
 * @author linzf
 */
public class TestIntBuffer {

	public TestIntBuffer() {
	}

	public static void main(String args[]) {
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.put((byte) 1);
		buffer.put(new byte[3]);
		buffer.putChar('A');
		buffer.putInt(1);
		buffer.put((byte) 2);
		System.out.println(buffer.get(0));
	}
}