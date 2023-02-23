package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PasswordDataDao;
import dto.PasswordData;

@WebServlet("/getalldata")
public class GetAllData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PasswordDataDao dao=new PasswordDataDao();
		List<PasswordData> listdata = dao.getAllPasswordDatasDetails();
		req.setAttribute("listdata", listdata);
		RequestDispatcher rd=req.getRequestDispatcher("getAlldata.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PasswordDataDao dao=new PasswordDataDao();
		List<PasswordData> listdata = dao.getAllPasswordDatasDetails();
		req.setAttribute("listdata", listdata);
		RequestDispatcher rd=req.getRequestDispatcher("getAlldata.jsp");
		rd.forward(req, resp);
		
		
	}

}
