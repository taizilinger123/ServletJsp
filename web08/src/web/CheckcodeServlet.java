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
        * һ����ͼ
        */
       //step1,�ڴ�ӳ�����(����)
       BufferedImage image = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
       //step2,��û���
       Graphics g = image.getGraphics();
       //step3,������������ɫ
       g.setColor(new Color(255,255,255));
       //step4,���������ñ�����ɫ
       g.fillRect(0, 0, 80, 30);
       //step5,���¸���������ɫ
       Random r = new Random();
       g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
       g.setFont(new Font(null,Font.ITALIC,24));
       //step6,����һ�������
       String number = r.nextInt(88888) + "";
       g.drawString(number, 5, 26);     
       /*
        * ����ѹ��ͼƬ�����
        */
       //���÷��������ص���������(ͼƬ)
       response.setContentType("image/jpeg");
       //����ֽ������
       OutputStream ops = response.getOutputStream();
       //ѹ��ͼƬ�����
       javax.imageio.ImageIO.write(image, "jpeg", ops);
       ops.close();      		
	}
}
