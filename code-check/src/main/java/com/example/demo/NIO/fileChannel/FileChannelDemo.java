package com.example.demo.NIO.fileChannel;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Author chuke
 * @create 2020/10/30 21:20
 */
@Slf4j
public class FileChannelDemo {

    /**
     * 创建fileChannel的放啊
     * 使用一个InputStream、OutputStream或RandomAccessFile来获取一个FileChannel实例。
     */
    public void demo() throws IOException {
        //第一种
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\17382\\Desktop\\0000.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        //第二种
        FileChannel inChannel2 = FileChannel.open(Paths.get("C:\\Users\\17382\\Desktop\\000.txt"), StandardOpenOption.READ);

    }

    public void FileChannel() {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\17382\\Desktop\\0000.txt", "rw");
            FileChannel asFile = accessFile.getChannel();
            //alllocate初始化指定长度
            ByteBuffer bbf = ByteBuffer.allocate(500);
            //数据从channel写到buffer中
            //从buffer中读取数据的两种方法：1）int byteRead = inChannle.write(buf) 写入数据到channel
            //                           2) byte abyte = buffer.get()       读出数据为字节
            int byteRead = asFile.read(bbf);
            while (byteRead != -1) {
                System.out.println("read" + byteRead);
                bbf.flip();
                //hasRemaining 返回剩余长度是否大于限制长度
                while (bbf.hasRemaining()) {
                    System.out.println("" + (char) bbf.get());
                }
                //clear() 简单理解就是复位（Reset） 但不清除数据（position=0, limit=capacity
                //compact()方法是将所有未读数据读取到buffer的起始出，将position设到最后一个未读的元素后面，
                // limit像clear方法一样，设置成capacity，现在已经准备写入数据，但不会覆盖未读数据
                bbf.clear();
                /*bbf.compact();*/
                byteRead = asFile.read(bbf);

            }
            accessFile.close();
        } catch (FileNotFoundException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * channel 是一种非阻塞 io 操作，write操作并不能一次将buffer 中的数据全部写入到指定的 channel 中去，需要考虑下次执行的
     *
     * clear()与compact()方法的区别
     * clear清空所有缓存中的数据，position将被设回0，limit被设置成 capacity的值 全部数据重置清空
     * compact是将position放置于未读数据的最后的位置，下次读入数据时，直接从未读数据的最后部分开始写入
     */
    public void setChannel() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\17382\\Desktop\\0000.txt","rw");
        FileChannel byteBuffer = accessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        //将数据从一个channel读取到另外一个channel中使用方法
        while(byteBuffer.read(buffer)>0||buffer.hasRemaining()) {
            buffer.flip();
            byteBuffer.write(buffer);
            buffer.compact();
        }
    }

    public void readBuffer() throws IOException {
//        FileChannel inChannel2 = FileChannel.open(Paths.get("C:\\Users\\17382\\Desktop\\000.txt"), StandardOpenOption.READ);
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\17382\\Desktop\\0000.txt", "rw");
        FileChannel channel = aFile.getChannel();
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        //到afile中
        channel.write(buf);
    }

    /**equals()方法与compareTo()满足条件
     * 有相同的类型（byte、char、int等）。
     * Buffer中剩余的byte、char等的个数相等。
     * Buffer中所有剩余的byte、char等都相同。
     *
     * equals只比较两个buffer中剩余的char，byte的是否完全相等
     * compareTo比较两个buffer中剩余元素的大小
     * 1、第一个不相等的元素小于另一个Buffer中对应的元素 。
     * 2、所有元素都相等，但第一个Buffer比另一个先耗尽(第一个Buffer的元素个数比另一个少)。
     * ：剩余元素是从 position到limit之间的元素，位标到限制位置中间的元素
     */

    public class ChannelTest {
        public  void main(String[] args) throws IOException {
            //创建FileChannel，指定要读取的文件
            FileChannel channel = FileChannel.open(Paths.get("aaa.txt"), StandardOpenOption.READ);
            ByteBuffer buffer=ByteBuffer.allocate(1024);//创建缓冲区
            while (channel.read(buffer)>0){//将channel从文件中读取的数据写入到缓冲区中。到尽头时候为0或者-1
                //buffer改为读取模式
                buffer.flip();
                String s = new String(buffer.array(), 0, buffer.limit());//从缓冲区中读取数据
                System.out.println(s);
                buffer.clear();
            }
            channel.close();
        }
    }



    public static void main(String[] args) throws IOException {
        FileChannelDemo demo = new FileChannelDemo();
        demo.readBuffer();
    }
}

