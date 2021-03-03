package com.example.demo.NIO.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Author chuke
 * @create 2020/11/3 21:16
 */
public class Server {
    private static final String EXIT_MARK = "exit";
    private int port;
    Server(int port) {
        this.port = port;
    }

    public void chatServer() throws IOException {
        // 创建服务端套接字通道，监听端口，并等待客户端连接
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.socket().bind(new InetSocketAddress(port));
        System.out.println("服务端启动，正在监听"+port+"端口");
        SocketChannel socketChannel = SocketChannel.open();
        serverSocket.accept();
        System.out.println("接收了来自客户端"+socketChannel.getRemoteAddress().toString().replace("/","")+"请求");


    }
}
