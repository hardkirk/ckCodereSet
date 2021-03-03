package com.example.demo.NIO.fileChannel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author chuke
 * @create 2020/11/2 9:32
 */
public class TransferFromDemo {
    /**
     * 在javaNIO中，如果有个管道是FileChannel，则可以直接将数据从一个管道传输到另外一个管道
     * 这里是将fileChannel1的数据传输到fileChannel2的文件中
     */

    public void TransferFromDemo() throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\17382\\Desktop\\1.txt","rw");
        FileChannel fileChannel = accessFile.getChannel();

        RandomAccessFile accessFile2 = new RandomAccessFile("C:\\Users\\17382\\Desktop\\0000.txt","rw");
        FileChannel fileChannel2 = accessFile2.getChannel();

        //方法的输入参数position表示从position处开始向目标文件写入数据，count表示最多传输的字节数。
        // 如果源通道的剩余空间小于 count 个字节，则所传输的字节数要小于请求的字节数。
        //此外要注意，在SoketChannel的实现中，SocketChannel只会传输此刻准备好的数据（可能不足count字节）。
        // 因此，SocketChannel可能不会将请求的所有数据(count个字节)全部传输到FileChannel中。
        long positon = 0;
        long count = fileChannel.size();
        //将源数据传输到fileChannel文件中
        fileChannel2.transferFrom(fileChannel,positon,count);


    }

    /**
     * 此方法是用于将fileChannel输出传输到其他channel中
     */
    public void tranferTo() throws IOException{
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\17382\\Desktop\\1.txt","rw");
        FileChannel fileChannel = accessFile.getChannel();

        RandomAccessFile accessFile2 = new RandomAccessFile("C:\\Users\\17382\\Desktop\\0000.txt","rw");
        FileChannel fileChannel2 = accessFile2.getChannel();

        //将fileChannel2d的数据传输到fileChannel1中
        long position = 0;
        long count = fileChannel2.size();
        fileChannel2.transferTo(position,count,fileChannel);
    }

    /**向fileChannel中写入数据*/
    public void readChannel() throws IOException {
        String newData = "it just one change for you";
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\17382\\Desktop\\1.txt","rw");
         FileChannel channel = accessFile.getChannel();
         ByteBuffer byteBuffer = ByteBuffer.allocate(500);
         byteBuffer.put(newData.getBytes());
         /*int bytenum = channel.read(byteBuffer);*/
        //当读到文件尾时，返回-1
         while (byteBuffer.hasRemaining()){
             //将byteByffer中的数据写入channel中
             channel.write(byteBuffer);
         }
         channel.close();
    }
    /**
     * FileChannel： 用于文件的数据读写
     * DatagramChannel： 用于UDP的数据读写
     * SocketChannel： 用于TCP的数据读写，一般是客户端实现
     * ServerSocketChannel: 允许我们监听TCP链接请求，每个请求会创建会一个SocketChannel，一般是服务器实现
     */
    public static void main(String[] args) throws IOException {
        TransferFromDemo demo = new TransferFromDemo();
       /* demo.TransferFromDemo();*/
        demo.tranferTo();
    }

    //文件空洞：在大于文件结尾的部分进行写入数据，使得文件结尾到写入文件这部分形成空洞，导致文件的大小会比实际上使用的要大
    //出于性能方面的考虑，操作系统会将数据缓存在内存中，所以无法保证写入到FileChannel里的数据一定会即时写到磁盘上。要保证这一点，需要调用force()方法
    //同时将文件数据和元数据强制写到磁盘上：
    //   channel.force(true);
}
