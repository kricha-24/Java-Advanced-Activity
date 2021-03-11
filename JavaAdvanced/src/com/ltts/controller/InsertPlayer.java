package com.ltts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.dao.PlayerDao;
import com.ltts.model.Player;

/**
 * Servlet implementation class InsertPlayer
 */
@WebServlet("/InsertPlayer")
public class InsertPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPlayer() {
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
//		doGet(request, response);
		PrintWriter out = response.getWriter();  
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		int mat=Integer.parseInt(request.getParameter("mat"));
		int run=Integer.parseInt(request.getParameter("run"));
		int wic=Integer.parseInt(request.getParameter("wic"));
		
		Player p=new Player(name, dob, mat, run, wic);
		System.out.println("Inside Servlet: "+p);
		PlayerDao pd=new PlayerDao();
		boolean b=false;
		
	//	RequestDispatcher rd=null;
		try {
			b=pd.insertPlayer(p); // Control TRanfers to Dao file
	//		rd=request.getRequestDispatcher("success.html");
//			rd.forward(request, response);
			//System.out.println("Successfully Inserted...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
//
			out.write("Already Player name Used: "+e);
//			rd=request.getRequestDispatcher("addplayer.html");
	//		rd.include(request, response);
			e.printStackTrace();
		}
	}

}
