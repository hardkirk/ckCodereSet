package com.example.demo.printToPdf;

import cn.hutool.core.io.FileUtil;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


/**
 * @author infinity
 * @version 1.0
 * @date 2020/8/29 9:55
 */
public class PrintToPdfUtil {
    /**
     * @param imageFolderPath 图片文件夹地址
     * @param pdfPath         PDF文件保存地址
     */
    public static void toPdf(String imageFolderPath, String pdfPath) {
        try {
            // 图片文件夹地址
            // 图片地址 imageFolderPath
            String imagePath = null;
            // PDF文件保存地址 pdfPath
            // 输入流
            FileOutputStream fos = new FileOutputStream(pdfPath);
            // 创建文档
            Document doc = new Document(null, 0, 0, 0, 0);
            // 写入PDF文档
            PdfWriter.getInstance(doc, fos);
            // 读取图片流
            BufferedImage img = null;
            // 实例化图片
            Image image = null;
            // 获取图片文件夹对象
            File file = new File(imageFolderPath);
            File[] files = file.listFiles();
            // 循环获取图片文件夹内的图片
            for (File file1 : files) {
                if (file1.getName().endsWith(".png")
                        || file1.getName().endsWith(".jpg")
                        || file1.getName().endsWith(".gif")
                        || file1.getName().endsWith(".jpeg")
                        || file1.getName().endsWith(".tif")) {
                    imagePath = imageFolderPath + file1.getName();
                    // 读取图片流
                    img = ImageIO.read(new File(imagePath));
                    // 根据图片大小设置文档大小
                    doc.setPageSize(new Rectangle(img.getWidth(), img
                            .getHeight()));
                    // 实例化图片
                    image = Image.getInstance(imagePath);
                    // 添加图片到文档
                    doc.open();
                    doc.add(image);
                }
            }
            // 关闭文档
            doc.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }

    /**
     * @param pdfPath  PDF文件原地址
     * @param destPath PDF文件保存地址
     */
    public static void PDFMerger(String pdfPath, String destPath) {
        //pdf合并工具类
        PDFMergerUtility mergePdf = new PDFMergerUtility();
        //合并pdf生成的文件名
        String destinationFileName = new Date().getTime() + ".pdf";
        File file = new File(pdfPath);
        String[] filelist = file.list();
        try {
            if (!FileUtil.exist(destPath)) {
                file.mkdirs();
            }
            for (int i = 0; i < filelist.length; i++) {
                mergePdf.addSource(pdfPath + File.separator + filelist[i]);
            }
            //设置合并生成pdf文件名称
            mergePdf.setDestinationFileName(destPath + File.separator + destinationFileName);
            //合并pdf
            mergePdf.mergeDocuments();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        //合并pdf生成的文件名
        String destinationFileName = new Date().getTime() + ".pdf";
        PDFMerger("D:/ceshi/pdf1/", "D:/ceshi/pdf1/");
//        toPdf("D:/ceshi/pdf1/", "D:/ceshi/pdf1/" );
        long time2 = System.currentTimeMillis();
        int time = (int) ((time2 - time1) / 1000);
        System.out.println("执行了：" + time + "秒！");
    }
}
