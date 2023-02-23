package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PasswordDataDao;
import dto.PasswordData;

@WebServlet("/loginuser")
public class LoginUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession httpSession=req.getSession();
		
		PasswordDataDao dao=new PasswordDataDao();
		PasswordData passwordData=null;
		List<PasswordData> data=dao.getPasswordDataByEmailAndPassword(email, password);
		if(data.isEmpty()!=true) {
			for(PasswordData d: data) {
				passwordData= d;
			}
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("InvalidCreadential");
			rd.forward(req, resp);
		}
		int id= passwordData.getId();
		httpSession.setAttribute("id", id);
		
		
		if(passwordData.getRole().equalsIgnoreCase("Admin")) {
			
			RequestDispatcher rd=req.getRequestDispatcher("/getalldata");
			rd.forward(req, resp);
		}
		else if(passwordData.getRole().equalsIgnoreCase("user")) {
			
			if(passwordData.getFb_password()!=null) {
			RequestDispatcher rd=req.getRequestDispatcher("GetDataUser.jsp");
			rd.forward(req, resp);
			}
			else if(passwordData.getFb_password()==null) {
				RequestDispatcher rd=req.getRequestDispatcher("register1.html");
				rd.forward(req, resp);   	
		}	
		}	
	}
}
