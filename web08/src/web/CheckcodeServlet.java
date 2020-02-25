package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckcodeServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       System.out.println("checkcode...");
       /*
        * 一，绘图
        */
       //step1,内存映像对象(画布)
       BufferedImage image = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
       //step2,获得画笔
       Graphics g = image.getGraphics();
       //step3,给画笔设置颜色
       g.setColor(new Color(255,255,255));
       //step4,给画布设置背景颜色
       g.fillRect(0, 0, 80, 30);
       //step5,重新给笔设置颜色
       Random r = new Random();
       g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
       g.setFont(new Font(null,Font.ITALIC,24));
       //step6,生成一个随机数
       String number = r.nextInt(88888) + "";
       g.drawString(number, 5, 26);     
       /*
        * 二，压缩图片并输出
        */
       //设置服务器返回的数据类型(图片)
       response.setContentType("image/jpeg");
       //获得字节输出流
       OutputStream ops = response.getOutputStream();
       //压缩图片并输出
       javax.imageio.ImageIO.write(image, "jpeg", ops);
       ops.close();      		
	}
}
