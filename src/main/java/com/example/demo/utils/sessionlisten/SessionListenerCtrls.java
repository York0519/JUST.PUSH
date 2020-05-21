package com.example.demo.utils.sessionlisten;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SessionListenerCtrls implements HttpSessionListener, ServletContextListener {

	public static String session_str = "session_loginlist";

	// 这里其实可以控制一定量的会话，如果会话数量不够，则让用户排队。

	public static ArrayList GetOnLineUser(HttpServletRequest request) {
		return GetOnLineUser(request.getSession());
	}

	/**
	 * 获取在线的用户.
	 * 
	 * @param session
	 * @return value
	 */
	public static ArrayList GetOnLineUser(HttpSession session) {
		ServletContext application = session.getServletContext();

		synchronized (application) {
			String sessionid = session.getId();

			return (ArrayList) application.getAttribute(session_str);
		}
	}

	/**
	 * session 创建的时候，添加到session登录用户数组内。
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

		// TODO Auto-generated method stub

		ServletContext application = arg0.getSession().getServletContext();

		synchronized (application) {
			String sessionid = arg0.getSession().getId();

			ArrayList loginList = (ArrayList) application.getAttribute(session_str);

			if (loginList == null) {
				loginList = new ArrayList();
				application.setAttribute(session_str, loginList);
			}
			if (!loginList.contains(arg0.getSession().getId())) {
				loginList.add(arg0.getSession().getId());
			}
		}
		log.info("session created.");
	}

	/**
	 * session 销毁时， 从用户数组内删除.
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

		ServletContext application = arg0.getSession().getServletContext();
		synchronized (application) {

			ArrayList loginList = (ArrayList) application.getAttribute(session_str);
			if (loginList != null) {

				if (loginList.contains(arg0.getSession().getId())) {
					loginList.remove(arg0.getSession().getId());
				}
				log.info("session removed.");
			} else {
				log.info("login list is null.");
			}
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		SessionIniter.getInstance().contextDestroyed();
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		SessionIniter.getInstance().contextInitialized();
	}
}
