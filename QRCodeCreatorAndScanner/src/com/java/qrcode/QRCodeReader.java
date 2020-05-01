package com.java.qrcode;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

/*
 * @author Priyanka Gupta
 * @date 1st May 2020
 * @source https://www.youtube.com/watch?v=YhQTKsAi3-U
 *
 **/
public class QRCodeReader {

	public static void main(String[] args) throws Exception {
		JFileChooser ch = new JFileChooser();
		ch.showOpenDialog(null);
		
		File file = ch.getSelectedFile();
//		 new File(".//img//QrCodeTest2.jpg");
		if(file==null) {
			throw new Exception("Invalid file");
		}
		try {
			Result r = new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file)))));
//			JOptionPane .showMessageDialog(null, r.getText());

			JOptionPane .showMessageDialog(null, r.getText(), "QR Code", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(file.getAbsolutePath()));
			
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
