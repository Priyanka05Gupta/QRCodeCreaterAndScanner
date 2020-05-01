package com.java.qrcode;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/*
 * @author Priyanka Gupta
 * @date 1st May 2020
 * @source https://www.youtube.com/watch?v=wICCZYE7cQ8
 *
 **/
public class QRCodeGenerator {
	
	public static void main(String[] args) {
//		C:\Users\Lenovo\Documents\PriyankaEclipseWorkspace\QRCodeCreatorAndScanner\image
		File file = new File(".\\img\\QrCodeTest2.jpg");
		String content = "This is my new content for QRCOde2";
		ByteArrayOutputStream out = QRCode.from(content).to(ImageType.JPG).stream();
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(out.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("success");
	}

}
