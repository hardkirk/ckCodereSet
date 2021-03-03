package com.example.demo.NIO.selector;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author chuke
 * @create 2020/11/2 10:19
 */
@Slf4j
public class SelectorDemo {
    /**
     * 套接字通道分为三种
     * DatagramChannel	    UDP 网络套接字通道
     * SocketChannel	    TCP 网络套接字通道
     * ServerSocketChannel	TCP 服务端套接字通道
     * Java 套接字通道类型对应于两种通信协议 TCP 和 UDP
     */
    public void channelCreate() throws IOException {
        //SocketChannel 和 ServerSocketChannel 都是抽象类，不能直接通过构造方法创建通道，只能接用open方法
        //关闭的方法都是使用close
        SocketChannel socketChannel2 = SocketChannel.open();
        socketChannel2.connect(new InetSocketAddress("www.coolblog.xyz", 80));
// do something...
        socketChannel2.close();
/*******************************************************************/
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        SocketChannel socketChannel = serverSocketChannel.accept();
// do something...
        socketChannel.close();
        serverSocketChannel.close();


        //读方法
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int num = socketChannel.read(byteBuffer);
        //判断当position<limit的真假
        byteBuffer.hasRemaining();

        //写方法 NIO 通道是面向缓冲的,所以写方法需要配合缓冲区
        String data = "one more time,one more change";
        ByteBuffer buffer = ByteBuffer.allocate(500);
        buffer.clear();
        buffer.put(data.getBytes());
        //重置position在0
        buffer.flip();
        socketChannel.write(buffer);
    }

    public void SelectorTest() throws IOException {
        //SocketChannel 和 ServerSocketChannel 都是抽象类，不能直接通过构造方法创建通道
        SocketChannel socketChannel = SocketChannel.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //设置非阻塞模式的方法为configureBlocking
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("www.coolblog.xyz", 80));
        //循环检测是否已经连接上
        while (!socketChannel.finishConnect())
            log.info("连接成功");
        //连接上之后才能进行读写的操作

        //使用selector时，channel必须为非阻塞模式，
        // 在此模式下，调用 connect()，read() 和 write() 等方法时，进程/线程会立即返回
        Selector selector = Selector.open();
        //register 监听channel的事件，这里有Connect  Accept   Read  Write事件
        /**
         * 通道触发了一个事件意思是该事件已经就绪。
         * 所以，某个channel成功连接到另一个服务器称为“连接就绪”。         SelectionKey.OP_CONNECT
         * 一个server socket channel准备好接收新进入的连接称为“接收就绪”。SelectionKey.OP_ACCEPT
         * 一个有数据可读的通道可以说是“读就绪”。                         SelectionKey.OP_READ
         * 等待写数据的通道可以说是“写就绪”。                            SelectionKey.OP_WRITE
         *
         */
        //可以使用 来进行多个事件的监听
        int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        //第一个参数是Selector ，第二个参数是interest集合
        SelectionKey key2 = socketChannel.register(selector, interestSet);
        //保证只返回对该通道有效的操作符
        int interest = key2.interestOps();
        //Interest集合
        boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
        boolean isInterestedInConnect = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;
        boolean isInterestedInRead = (interestSet & SelectionKey.OP_READ) == SelectionKey.OP_READ;
        boolean isInterestedInWrite = (interestSet & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE;
        //用“位与”操作interest 集合和给定的SelectionKey常量，可以确定某个确定的事件是否在interest 集合中
        //ready集合 可以这样访问ready集合，可以下列方法返回一个boolean进行判断
        int readySet = key2.readyOps();
        /*可以调用下列方法进行判断返回一个boolean
        key.isAcceptable();
        key.isConnectable();
        key.isReadable();
        key.isWritable();*/

        /**通道的选择*/
        //表示最少一个通道在这里阻塞  select()方法返回的int值表示自上次调用后，有多少新通道就绪
        int select = selector.select();
        //比上一种多一个最长阻塞时间
        selector.select(50);
        //不会阻塞，不管什么通道就绪，就立刻返回   此方法执行非阻塞的选择操作。如果自从前一次选择操作后，没有通道变成可选择的，则此方法直接返回零
        selector.selectNow();

        //访问已选择键集中（selected key set）已就绪的通道
        Set selectedKeys = selector.selectedKeys();

    }
    /**注册一个通道注册到这个Selector上(通道的初始化过程略去)
     * ,然后持续监控这个Selector的四种事件（接受，连接，读，写）是否就绪*/
    public void selectorDemo() throws IOException {

        Selector selector = Selector.open();
        Set selectedKeys = selector.selectedKeys();
        selectedKeys = selector.selectedKeys();
        //迭代器
        Iterator keyIterator = selectedKeys.iterator();
        while (keyIterator.hasNext()) {
            SelectionKey key = (SelectionKey) keyIterator.next();
            if (key.isAcceptable()) {
                // a connection was accepted by a ServerSocketChannel.
            } else if (key.isConnectable()) {
                // a connection was established with a remote server.
            } else if (key.isReadable()) {
                // a channel is ready for reading
            } else if (key.isWritable()) {
                // a channel is ready for writing
            }
            keyIterator.remove();

        }
    }
    //总结：1、使用selector可以使用单个来管理多个chuannel
    //      2、selector注册的方法：Selector selector = Selector.open();
    //      3、注册通道
    //      channel.configureBlocking(false)    SelectorKey key  =  selector.register(selector,SelctorKey.OP_READ)
    //      4、当向Selector注册Channel时，register()方法会返回一个SelectionKey对象。这个对象包含了一些属性：
    //          interest集合
    //          ready集合
    //          Channel
    //          Selector
    //          可以通过
    //      5、通过Selector选择通道
    //      int select()
    //      int select(long timeout)
    //      int selectNow()



}
