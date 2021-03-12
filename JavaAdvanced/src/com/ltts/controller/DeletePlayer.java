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
 * Servlet implementation class DeletePlayerServlet
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePlayer() {
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
		String id = request.getParameter("pno");		
		Player p=new Player(id, null, 0, 0, 0);
		System.out.println("Inside Servlet: "+p);
		PlayerDao pd=new PlayerDao();
		boolean b=false;		
		RequestDispatcher rd=null;
		try {
			b=pd.deletePlayer(p);
			rd=request.getRequestDispatcher("Success.html");
			rd.forward(request, response);
			System.out.println("Player deets deleted succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("addplayer.html");
			rd.include(request, response);
			e.printStackTrace();
			
		}
		
	}


}
