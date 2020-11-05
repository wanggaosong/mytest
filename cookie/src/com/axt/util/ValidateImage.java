package com.axt.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.axt.sso.client.memCached.MemCached;

public class ValidateImage {

	public static final String VALIDATIONKEY = "validation_key";

	public static final int WIDTH = 80;

	public static final int HEIGHT = 25;

	private static ValidateImage instance;

	private final Random random;

	private final Font font;
	
	private ValidateImage() {
		this.random = new Random();

		this.font = new Font("Consolas", Font.PLAIN, HEIGHT);
	}

	public synchronized Image drawValidateImage() {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();

		Graphics2D g2d = (Graphics2D) g;

		g.setColor(getRandColor(200, 250));

		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.DARK_GRAY);

		int[] xPoints = new int[2];

		int[] yPoints = new int[2];

		for (int j = 0; j < 2; j++) {
			xPoints[j] = random.nextInt(WIDTH - 1);

			yPoints[j] = random.nextInt(HEIGHT - 1);
		}
		g.drawPolyline(xPoints, yPoints, 2);
		
		g.setFont(font);

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < 4; i++) {

			char randChar = getCharValue(random.nextInt(62));
			Color color = null;
            if(i % 2 == 0){
            	color = new Color(10 + random.nextInt(105), 20 + random.nextInt(55), 140 + random.nextInt(105));
            }else{
            	color = new Color(140 + random.nextInt(95), 20 + random.nextInt(55), 10 + random.nextInt(105));
            }

			g.setColor(color);

			AffineTransform trans = new AffineTransform();

			trans.rotate(random.nextInt(18) * 3.14 / 180, 10 * i + 10, 7);

			float scaleSize = random.nextFloat() + 0.8f;

			if (scaleSize > 0.9f) scaleSize = 0.9f;

			trans.scale(scaleSize, scaleSize);

			g2d.setTransform(trans);
			g.drawString(randChar + "", 20 + 15 * i, 19);
//			g.drawString(randChar + "", 13 * i + 10, 19);

			buffer.append(randChar);
		}
		g.dispose();

		// session.setAttribute(VALIDATIONKEY, buffer.toString().toLowerCase());
		
		// MemCached.set(idcode, buffer.toString().toLowerCase());

		return image;
	}

	private char getCharValue(int x) {
		if(x < 10){
			return (char)(x + 48);
		}
		if(x < 36){
			return (char)(x + 55);
		}
		if(x < 62){
			return (char)(x + 61);
		}
		return '0';
	}

	private Color getRandColor(int fc, int bc) {
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	public synchronized static ValidateImage getInstance() {
		return instance == null ? instance = new ValidateImage() : instance;
	}
	
	/**
	* @param args
	*/
	public static void main(String[] args) 
	{

	GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
	String evnfonts[] = gEnv.getAvailableFontFamilyNames();
	for (int i = 0; i < evnfonts.length; i++) 
	{
	System.out.println(evnfonts[i]);
	}
	}
}
