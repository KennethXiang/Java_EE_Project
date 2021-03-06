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
 * 测试session对象发呆时间
 * 发呆时间：就是客户端不理睬服务器的时间
 * 1 同一个浏览器进程时，各种跳转
 * 2 同一个浏览器，但是不同进程各种跳转的情况
 * 3 不同的浏览器的进程
 * */

@WebServlet(urlPatterns="/SessionTest3")
public class SessionTest3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//三剑客
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		//获取session（会话）对象
		HttpSession session=req.getSession();	
		session.setMaxInactiveInterval(3);
		
		//输出ID，进行观察
		String ssid=session.getId();
		out.println("<h1>Test3页面中的ssid:"+ssid+"</h1>");
		out.println("<h1>Test3程序的isNew："+session.isNew()+"</h1>");
		
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
