package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class MultiBuffer {
	
	@SuppressWarnings("resource")
	public static void scatteringRead(String filePath) throws IOException{
		RandomAccessFile aFile = new RandomAccessFile(filePath, "rw");
		FileChannel inChannel = aFile.getChannel();
		ByteBuffer header = ByteBuffer.allocate(4);
		ByteBuffer body = ByteBuffer.allocate(1024);
		ByteBuffer[] bufferArray = {header , body};
		inChannel.read(bufferArray);
		header.flip();
		System.out.print("header:\"");
		while (header.hasRemaining()) {
			System.out.print((char)header.get());
		}
		System.out.println("\"");
		body.flip();
		System.out.print("body:\"");
		while (body.hasRemaining()) {
			System.out.print((char)body.get());
		}
		System.out.println("\"");
		aFile.close();
	}
	
	public static void gatheringWrite(String fromPath, String toPath)
			throws IOException {
		RandomAccessFile fromFile = new RandomAccessFile(fromPath, "rw");
		FileChannel inChannel = fromFile.getChannel();
		ByteBuffer header = ByteBuffer.allocate(4);
		ByteBuffer body = ByteBuffer.allocate(1024);
		ByteBuffer[] bufferArray = { header, body };
		inChannel.read(bufferArray);
		header.flip();// 将buffer的模式从write变为read，write就是只能写进去，read就是只能读出来
		body.flip();
		RandomAccessFile toFile = new RandomAccessFile(toPath, "rw");
		FileChannel outChannel = toFile.getChannel();
		outChannel.write(bufferArray);
	}

	@Test
	public void test1() throws IOException {
		gatheringWrite("d:/win7.txt", "d:/win7-test.txt");
	}
	
	@Test
	public void test2() throws IOException{
		scatteringRead("d:/win7.txt");
	}
}
