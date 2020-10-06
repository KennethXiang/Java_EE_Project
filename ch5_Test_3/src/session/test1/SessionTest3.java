package session.test1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * ����session���󷢴�ʱ��
 * ����ʱ�䣺���ǿͻ��˲����Ƿ�������ʱ��
 * 1 ͬһ�����������ʱ��������ת
 * 2 ͬһ������������ǲ�ͬ���̸�����ת�����
 * 3 ��ͬ��������Ľ���
 * */

@WebServlet(urlPatterns="/SessionTest3")
public class SessionTest3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//������
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		//��ȡsession���Ự������
		HttpSession session=req.getSession();	
		session.setMaxInactiveInterval(3);
		
		//���ID�����й۲�
		String ssid=session.getId();
		out.println("<h1>Test3ҳ���е�ssid:"+ssid+"</h1>");
		out.println("<h1>Test3�����isNew��"+session.isNew()+"</h1>");
		
		System.out.println(ssid);
		
		//resp.sendRedirect("SessionTest2");
		out.println("<a href=\"SessionTest2\">SessionTest2</a>");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}