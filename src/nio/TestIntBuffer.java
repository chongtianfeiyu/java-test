package nio;

import java.nio.ByteBuffer;
/**
 * buffer��Ҫ����
 * 1��capacity ���� ,���ã�buffer.allocate(capacity)����ȡ:buffer.capacity()
 * 2��limit �������ƣ����ã�buffer.limit(limit),��ȡ��buffer.limit()
 * 3��position �洢��λ�ã����ã�buffer.position(position),��ȡ��buffer.position()
 * 4������ֵ,put()��putXxx()��ÿ���붼ʹ��position�ı䣬�ı��С������λ�㣬���������У�byteΪ��λ�����Բ���char���ƶ�2���ֽ�
 * 5��postion -> 0��flip()����
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