package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class BufferAndChannel {
	public void readFile(String filePath) throws IOException{
		RandomAccessFile aFile = new RandomAccessFile(filePath, "rw");
		FileChannel inChannel = aFile.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = inChannel.read(buf);
		while(bytesRead!=-1){
			System.out.println("bytesRead:"+bytesRead);
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char)buf.get());
			}
			System.out.println("");
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
	
	@Test
	public void test1() throws IOException{
		readFile("d:/win7.txt");
	}
}
