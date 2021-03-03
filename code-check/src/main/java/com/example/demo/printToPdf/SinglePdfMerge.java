package com.example.demo.printToPdf;

import cn.hutool.core.io.FileUtil;
import com.example.demo.vo.PermitPdfInfoVO;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @Author chuke
 * @create 2020/10/23 20:04
 */
public class SinglePdfMerge {

    public static PermitPdfInfoVO mergePhoto(String imageFolderPath, String pdfPath) throws IOException, DocumentException {
        PermitPdfInfoVO fileinfo = new PermitPdfInfoVO();
        FileOutputStream fos = null;
        Document doc = null;
        // 图片文件夹地址
        // 图片地址 imageFolderPath
        String imagePath = null;
        File filetest = new File(pdfPath);
        File photoFile = new File(pdfPath);
        if (!photoFile.exists())
            photoFile.mkdir();
        // PDF文件保存地址 pdfPath
        //合并pdf生成的文件名

        String destinationFileName = new Date().getTime() + ".pdf";
        // 输入流
        fos = new FileOutputStream(pdfPath + File.separator + destinationFileName);
        // 创建文档
        Rectangle rectangle = new Rectangle(2,2,2,2);
        doc = new Document(rectangle, 1, 1, 1, 1);
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
        fileinfo.setFileName(pdfPath+destinationFileName);
        fileinfo.setPath(pdfPath);
        // 关闭文档
        doc.close();
        fos.close();
        return fileinfo;
    }

    public static void main(String[] args) throws IOException, DocumentException {
        PermitPdfInfoVO permitPdfInfoVO = SinglePdfMerge.mergePhoto("D:/uploadfile/333/", "D:/uploadfile/222/");
    }
}
