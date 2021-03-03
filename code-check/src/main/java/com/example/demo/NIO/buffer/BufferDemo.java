package com.example.demo.NIO.buffer;

/**
 * @Author chuke
 * @create 2020/10/31 15:14
 */
public class BufferDemo {
    /**
     * 写入数据到Buffer
     * 调用flip()方法
     * 从Buffer中读取数据
     * 调用clear()方法或者compact()方法  清空缓存区
     * compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
     *
     * buffer的类型为
     *    ByteBuffer
     *     MappedByteBuffer
     *     CharBuffer
     *      DoubleBuffer
     *     FloatBuffer
     *      IntBuffer
     *     LongBuffer
     *      ShortBuffer
     */


}
