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

@WebServlet("/delete1")
public class Delete1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession  hs= req.getSession();
		int id=(Integer)hs.getAttribute("id");
		PasswordDataDao dao= new PasswordDataDao();
		dao.deletePasswordDataById(id);
		RequestDispatcher dispatcher =req.getRequestDispatcher("register.html");
		dispatcher.forward(req, resp);
		
		
	}

}
