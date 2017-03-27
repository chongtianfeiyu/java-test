package io.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import org.junit.Test;
/**
 * buffer��Ҫ����
 * 1��capacity ���� ,���ã�buffer.allocate(capacity)����ȡ:buffer.capacity()
 * 2��limit �������ƣ����ã�buffer.limit(limit),��ȡ��buffer.limit()
 * 3��position �洢��λ�ã����ã�buffer.position(position),��ȡ��buffer.position()
 * 4������ֵ,put()��putXxx()��get()��getXxx��ÿ��"�޲δ���"����"�޲λ�ȡ"��ʹ��position�ı䣬�ı��С������λ�㣬���������У�byteΪ��λ�����Բ���char���ƶ�2���ֽ�
 * 5��postion -> 0��flip()����
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
	 * ��˱�ʾ����λ�ֽ���ǰ
	 * С�α�ʾ����λ�ֽ���ǰ
	 * ���ӣ�intΪ4�ֽڣ�
	 * 	   1 = 0x00000001,��˱�ʾ��2^0 = 1 
	 *     1 = 0x01000000,С�˱�ʾ��2^24 = 16777216
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
	 * flip ��position��Ϊ
	 * ��ȡ����Ĭ��Ϊcapacity��һ��
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
		System.out.println(buffer.get());// 0,�൱��buffer.get(0)
		System.out.println(buffer.position());//position�ƶ�����1
		buffer.compact();//ѹ��
		System.out.println(buffer.position());//position�ƶ�����15,��ΪlimitΪ16�������Ϊ��λѹ�������Ѿ���ȡ���ֵ���޷���ȡ����
		System.out.println(buffer.get(0));//ʵ�ʻ�ȡΪԭ���ģ�byte1[1]Ϊ1
	}
	
	@Test
	/*
	 * IntBuffer intBuffer = buffer.asIntBuffer();
	 * intBufferΪ�µ�Buffer,bufferԭ�����ֵ��intBuffer�����������Buffer���໥Ӱ��
	 */
	public void test4(){
		ByteBuffer buffer = ByteBuffer.allocate(32);
		buffer.putInt(1);
		System.out.println(buffer.position());// 4
		IntBuffer intBuffer = buffer.asIntBuffer();
		System.out.println(intBuffer.position());// ��λ������Ϊ0
		intBuffer.put(2);//�ƶ���λ�õ�1
		System.out.println(intBuffer.get(0));//2��buffer�е�ֵ�������� 
		System.out.println(buffer.position());//bufferλ��Ϊ4����intBuffer�ı��Ӱ�쵽buffer
		int value = buffer.getInt();
		System.out.println(value);//2
		buffer.putInt(10);
		System.out.println(intBuffer.get(1));
	}
}