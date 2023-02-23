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

@WebServlet("/registeruser")
public class RegisterUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		String role= req.getParameter("role");
		
		PasswordData data=new PasswordData();
		data.setName(name);
		data.setEmail(email);
		data.setPassword(password);
		
		data.setRole(role);
		
		PasswordDataDao dao=new PasswordDataDao();
		dao.savePasswordData(data);
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
			
		
	}

}
