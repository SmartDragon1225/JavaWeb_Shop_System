package com.tian.sevlet.user;


import com.tian.utils.Constants;
import com.tian.dao.BaseDao;
import com.tian.pojo.User;
import com.tian.service.user.UserService;
import com.tian.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	//�����û�����������ҵ��㡢ת����ͼ
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		
		System.out.println("dkwem ============ " );
		System.out.println("������" );
		System.out.println("����" );
		//��ȡ�û���������
		//String userCode = "admin";
		//String userPassword = "1234567";
		String userCode = req.getParameter("userCode");
		String userPassword = req.getParameter("userPassword");
		//����service�����������û�ƥ��
		UserService userService = new UserServiceImpl();
		User user = userService.login(userCode,userPassword);
		if(null != user){//��¼�ɹ�
			System.out.println("��¼�ɹ� ============ " );
			//����session
			req.getSession().setAttribute(Constants.USER_SESSION,user);
			//ҳ����ת��frame.jsp��
			resp.sendRedirect("jsp/frame.jsp");
		}else{
			System.out.println("��¼ʧ�� ============ " );
			//ҳ����ת��login.jsp��������ʾ��Ϣ--ת��
			req.setAttribute("error", "Username or Password is not correct! please again!");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		doGet(req, resp);
	}
}
