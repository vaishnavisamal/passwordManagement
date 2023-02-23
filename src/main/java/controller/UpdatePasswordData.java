package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PasswordDataDao;
import dto.PasswordData;

@WebServlet("/update")
public class UpdatePasswordData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String fb_password=req.getParameter("fb_password");
		String gmail_password=req.getParameter("gmail_password");
		String insta_password=req.getParameter("insta_password");
		String linkedin_password=req.getParameter("linkedin_password");
		long phone=Long.parseLong(req.getParameter("phone"));
		String role=req.getParameter("role");
		
		PasswordDataDao dao=new PasswordDataDao();
		PasswordData data=dao.getPasswordDataById(id);
		
		data.setName(name);
		data.setEmail(email);
		data.setPassword(password);
		data.setFb_password(fb_password);
		data.setGmail_password(gmail_password);
		data.setInsta_password(insta_password);
		data.setLinkedin_password(linkedin_password);
		data.setPhone_num(phone);
		data.setRole(role);
		
		dao.updatePasswordDataById(data);
		
		RequestDispatcher rd=req.getRequestDispatcher("/getalldata");
		rd.forward(req, resp);
		
		
	}

}
