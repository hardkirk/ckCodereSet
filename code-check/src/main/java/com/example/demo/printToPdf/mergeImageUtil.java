package com.test.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class CompositeImage {

    public static void mergeImage(String fileStr1, String fileStr2, String path)
            throws IOException {
        File file1 = new File(path, fileStr1);
        File file2 = new File(path, fileStr2);

        // BufferedImage image1 = ImageIO.read(file1);
        // BufferedImage image2 = ImageIO.read(file2);

        BufferedImage image1 = ImgCompress(file1);
        BufferedImage image2 = ImgCompress(file2);

        BufferedImage combined = new BufferedImage(image1.getWidth(), image1.getHeight() * 2,
                BufferedImage.TYPE_INT_RGB);
        File outputfile = new File("D:/uploadfile/222/");
        ImageIO.write(combined, "jpg", outputfile);
        // paint both images, preserving the alpha channels
    }

    // 图片压缩处理

    private static Image img;
    private static int width;
    private static int height;

    public static BufferedImage ImgCompress(File file) throws IOException {
        img = ImageIO.read(file); // 构造Image对象
        width = img.getWidth(null); // 得到源图宽
        height = img.getHeight(null); // 得到源图长

//    return resizeFix(400, 492);
        return resizeFix(600, 692);
    }

    /**
     * 按照宽度还是高度进行压缩
     *
     * @param w
     *          int 最大宽度
     * @param h
     *          int 最大高度
     */
    public static BufferedImage resizeFix(int w, int h) throws IOException {
        if (width / height > w / h) {
            return resizeByWidth(w);
        } else {
            return resizeByHeight(h);
        }
    }

    /**
     * 以宽度为基准，等比例放缩图片
     *
     * @param w
     *          int 新宽度
     */
    public static BufferedImage resizeByWidth(int w) throws IOException {
        int h = (int) (height * w / width);
        return resize(w, h);
    }

    /**
     * 以高度为基准，等比例缩放图片
     *
     * @param h
     *          int 新高度
     */
    public static BufferedImage resizeByHeight(int h) throws IOException {
        int w = (int) (width * h / height);
        return resize(w, h);
    }

    /**
     * 强制压缩/放大图片到固定的大小
     *
     * @param w
     *          int 新宽度
     * @param h
     *          int 新高度
     */
    public static BufferedImage resize(int w, int h) throws IOException {
        // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        try {
            g.drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图
        } finally {
            if (g != null) {
                g.dispose();
            }
        }
        return image;
        // File destFile = new File("C:\\temp\\456.jpg");
        // FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流
        // // 可以正常实现bmp、png、gif转jpg
        // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        // encoder.encode(image); // JPEG编码
        // out.close();
    }

    public static void main(String[] args) throws IOException {
        String path = "D:/uploadfile/333/";
        String fileStr1 = "111.jpg";
        String fileStr2 = "222.jpg";
        String fileStr3 = "621.png";
        mergeImage(fileStr1, fileStr2, path);
    }

}