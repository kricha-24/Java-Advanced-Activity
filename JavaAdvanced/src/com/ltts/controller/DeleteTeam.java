package com.ltts.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltts.dao.TeamDao;
import com.ltts.model.Team;

/**
 * Servlet implementation class DeleteTeamServlet
 */
@WebServlet("/DeleteTeam")
public class DeleteTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeam() {
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
		Team p=new Team(0, id, null, null, 0);
		System.out.println("Inside Servlet: "+p);
		TeamDao pd=new TeamDao();
		boolean b=false;		
		RequestDispatcher rd=null;
		try {
			b=pd.deleteTeam(p); // Control TRanfers to Dao file
			rd=request.getRequestDispatcher("Success1.html");
			rd.forward(request, response);
			System.out.println("Team deets deleted succesfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.write("Already Player id Used: "+e);
			rd=request.getRequestDispatcher("team.html");
			rd.include(request, response);
			e.printStackTrace();
			
		}
		
	}


}
