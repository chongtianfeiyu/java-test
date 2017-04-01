package io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/**
 * 获取channel的多种方式
 * 
 * @author linzf
 */
public class GetChannel {
	@Test
	public void test1() throws FileNotFoundException {
		String filePath = "d:/win7.txt";
		RandomAccessFile aFile = new RandomAccessFile(filePath, "rw");
		FileChannel inChannel = aFile.getChannel();
	}

	@Test
	public void test2() throws IOException {
		FileChannel inChannel = FileChannel.open(Paths.get("d:/", "win7.txt"),
				StandardOpenOption.READ, StandardOpenOption.WRITE,
				StandardOpenOption.CREATE);
	}

	@Test
	public void test3() throws IOException {
		try (FileChannel destChannel = FileChannel.open(
				Paths.get("d:/", "win7-test.txt"), StandardOpenOption.WRITE,
				StandardOpenOption.CREATE)) {
			InputStream inputStream = new FileInputStream(new File(
					"d:/win7.txt"));
			ReadableByteChannel newChannel = Channels.newChannel(inputStream);
			destChannel.transferFrom(newChannel, 0, Integer.MAX_VALUE);
		}
	}

	@Test
	// 使用缓存实现文件复制
	public void test4() throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1024 * 4);
		try (FileChannel srcChannel = FileChannel.open(
				Paths.get("d:/win7.txt"), StandardOpenOption.READ);
				FileChannel destChannel = FileChannel
						.open(Paths.get("d:/win7-test.txt"),
								StandardOpenOption.CREATE_NEW,
								StandardOpenOption.WRITE)) {
			while (srcChannel.read(buffer) > 0 || buffer.position() != 0) {
				buffer.flip();// 切换为读模式
				destChannel.write(buffer);
				buffer.compact();
			}
		}
	}

	@Test
	// 使用通道实现文件的复制
	public void test5() throws IOException {
		try (FileChannel srcChannel = FileChannel.open(
				Paths.get("d:/win7.txt"), StandardOpenOption.READ);
				FileChannel destChannel = FileChannel
						.open(Paths.get("d:/win7-test.txt"),
								StandardOpenOption.CREATE_NEW,
								StandardOpenOption.WRITE)) {
			srcChannel.transferTo(0, srcChannel.size(), destChannel);
		}
	}

	@Test
	// 处理大文件，先把部分加载到内存中，处理完成之后再加载剩下的部分
	// force类似io流中flush，强制更新
	// channel.force(true);
	/*
	 * force方法会把所有未写磁盘的数据都强制写入磁盘。这是因为在操作系统中出于性能考虑回把数据放入缓冲
	 * 区，所以不能保证数据在调用write写入文件通道后就及时写到磁盘上了，除非手动调用force方法。 force方法
	 * 需要一个布尔参数，代表是否把meta data也一并强制写入
	 */
	public void test6() throws IOException {
		try (FileChannel channel = FileChannel.open(Paths.get("d:/win7.txt"),
				StandardOpenOption.READ, StandardOpenOption.WRITE)) {
			MappedByteBuffer buffer = channel.map(
					FileChannel.MapMode.READ_WRITE, 0, channel.size());// 物理内存中的
			byte b = buffer.get(0);// 获取该位置的值
			buffer.put(5, b);// 替换该位置的值
			buffer.force();
		}
	}
}
