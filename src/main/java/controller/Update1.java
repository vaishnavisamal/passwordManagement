package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PasswordDataDao;
import dto.PasswordData;

@WebServlet("/updateuser1")
public class Update1 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession httpSession=req.getSession();
		int id=(Integer)httpSession.getAttribute("id");
		
		PasswordDataDao dao=new PasswordDataDao();
		PasswordData data=dao.getPasswordDataById(id);
		
		String fb_password=req.getParameter("fb_password");
		String gmail_password=req.getParameter("gmail_password");
		String insta_password=req.getParameter("insta_password");
		String linkedin_password=req.getParameter("linkedin_password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		data.setFb_password(fb_password);
		data.setGmail_password(gmail_password);
		data.setInsta_password(insta_password);
		data.setLinkedin_password(linkedin_password);
		data.setPhone_num(phone);
		
		dao.updatePasswordDataById(data);
		
		RequestDispatcher rd=req.getRequestDispatcher("GetDataUser.jsp");
		rd.forward(req, resp);
		
		
		
	}

}
