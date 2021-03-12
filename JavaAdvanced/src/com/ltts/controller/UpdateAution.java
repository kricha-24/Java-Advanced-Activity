package com.ltts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.dao.AutionDao;
import com.ltts.model.Aution;


/**
 * Servlet implementation class UpdateAuctionServlet
 */
@WebServlet("/UpdateAution")
public class UpdateAution extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAution() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out = response.getWriter();		
		int id=Integer.parseInt(request.getParameter("aid"));	
		//int ayear = Integer.parseInt(request.getParameter("ayear"));
		double aprice = Double.parseDouble(request.getParameter("aprice"));		
		// Player p1 = new Player();
		Aution a = new Aution(id,0,0,null,aprice);
		System.out.println("Inside Servlet: "+a);
		AutionDao pd=new AutionDao();
		boolean b=false;		
		RequestDispatcher rd=null;
		try {
			b= pd.updateAution(a);
			rd=request.getRequestDispatcher("Success2.html");
			rd.forward(request, response);
			System.out.println("Hurray! Updated!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("auction.html");
			rd.include(request, response);
			e.printStackTrace();
		}
		
	}

	
}

