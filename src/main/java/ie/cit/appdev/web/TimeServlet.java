package ie.cit.appdev.web;

import ie.cit.appdev.dao.AccountRespository;
import ie.cit.appdev.domain.Account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TimeServlet extends HttpServlet{
	
	private AccountRespository accRepository ;
	
	@Override
	public void init() throws ServletException{
		ServletContext servletContext=getServletContext();
		WebApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(servletContext);
		accRepository = ctx.getBean(AccountRespository.class);	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		String msg=String.format("Current time is %s", new Date().toString());
		pw.print(msg);
		pw.close();
			
	}
	
}
