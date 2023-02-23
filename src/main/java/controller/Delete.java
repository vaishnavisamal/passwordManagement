package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PasswordDataDao;


@WebServlet("/delete")
public class Delete extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id=Integer.parseInt(req.getParameter("id"));
		PasswordDataDao dao=new PasswordDataDao();
		
		if(dao.deletePasswordDataById(id)!=null) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("/getalldata");
			dispatcher.forward(req, resp);
		}
		
		
	}

}
