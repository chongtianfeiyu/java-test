package nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import org.junit.Test;
/**
 * buffer主要参数
 * 1、capacity 容量 ,设置：buffer.allocate(capacity)，获取:buffer.capacity()
 * 2、limit 缓存限制，设置：buffer.limit(limit),获取：buffer.limit()
 * 3、position 存储的位置，设置：buffer.position(position),获取：buffer.position()
 * 4、存入值,put()、putXxx()、get()、getXxx，每次"无参存入"或者"无参获取"都使得position改变，改变大小，按单位算，下面例子中：byte为单位，所以插入char，移动2个字节
 * 5、postion -> 0，flip()方法
 * @author linzf
 */
public class TestBuffer {

	@Test
	public void test1(){
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.put((byte) 1);
		buffer.put(new byte[3]);
		buffer.putChar('A');
		buffer.putInt(1);
		buffer.put((byte) 2);
		System.out.println(buffer.get(0));
	}
	
	@Test
	/*
	 * 大端表示，高位字节在前
	 * 小段表示，低位字节在前
	 * 例子：int为4字节，
	 * 	   1 = 0x00000001,大端表示，2^0 = 1 
	 *     1 = 0x01000000,小端表示，2^24 = 16777216
	 */
	public void test2(){
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.putInt(1);
		int int1 = buffer.getInt(0);
		System.out.println(int1);// 1
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		int int2 = buffer.getInt(0);
		System.out.println(int2);// 16777216
	}
	
	@Test
	/*
	 * flip 将position变为
	 * 读取限制默认为capacity的一半
	 */
	public void test3(){
		ByteBuffer buffer = ByteBuffer.allocate(32);
		byte[] byte1 = new byte[16];
		byte1[0] = (byte)1;
		byte1[1] = (byte)2;
		byte1[2] = (byte)3;
		byte1[3] = (byte)4;
		buffer.put(byte1);
		System.out.println(buffer.position());//16
		buffer.flip();
		System.out.println(buffer.position());//0
//		System.out.println(buffer.getInt());//2^16+2^9+3,66051
		System.out.println(buffer.get());// 0,相当于buffer.get(0)
		System.out.println(buffer.position());//position移动到了1
		buffer.compact();//压缩
		System.out.println(buffer.position());//position移动到了15,因为limit为16，以这个为单位压缩，且已经读取过的值，无法获取到了
		System.out.println(buffer.get(0));//实际获取为原来的：byte1[1]为1
	}
	
	@Test
	/*
	 * IntBuffer intBuffer = buffer.asIntBuffer();
	 * intBuffer为新的Buffer,buffer原来存的值在intBuffer被清除，且两个Buffer会相互影响
	 */
	public void test4(){
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.putInt(1);
		System.out.println(buffer.position());// 4
		IntBuffer intBuffer = buffer.asIntBuffer();
		System.out.println(intBuffer.position());// 将位置重置为0
		intBuffer.put(2);//移动了位置到1
		System.out.println(intBuffer.get(0));//2，buffer中的值被清除掉了 
		System.out.println(buffer.position());//buffer位置为4，且intBuffer改变会影响到buffer
		int value = buffer.getInt();
		System.out.println(value);//2
		buffer.putInt(10);
		System.out.println(intBuffer.get(1));
	}
	
	
	@Test
	public void test5(){
		
	}
}