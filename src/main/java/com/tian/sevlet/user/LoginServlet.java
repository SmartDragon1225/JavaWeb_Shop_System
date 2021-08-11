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
	//接受用户参数、调用业务层、转发视图
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		System.out.println("dkwem ============ " );
		System.out.println("。。。" );
		System.out.println("。。" );
		//获取用户名和密码
		//String userCode = "admin";
		//String userPassword = "1234567";
		String userCode = req.getParameter("userCode");
		String userPassword = req.getParameter("userPassword");
		//调用service方法，进行用户匹配
		UserService userService = new UserServiceImpl();
		User user = userService.login(userCode,userPassword);
		if(null != user){//登录成功
			System.out.println("登录成功 ============ " );
			//放入session
			req.getSession().setAttribute(Constants.USER_SESSION,user);
			//页面跳转（frame.jsp）
			resp.sendRedirect("jsp/frame.jsp");
		}else{
			System.out.println("登录失败 ============ " );
			//页面跳转（login.jsp）带出提示信息--转发
			req.setAttribute("error", "Username or Password is not correct! please again!");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doGet(req, resp);
	}
}
