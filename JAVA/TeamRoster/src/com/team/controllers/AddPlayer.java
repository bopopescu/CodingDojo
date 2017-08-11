package com.team.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.team.models.*;

/**
 * Servlet implementation class AddPlayer
 */
@WebServlet("/AddPlayer")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN add player of deoGET");
		System.out.println(request.getParameter("id"));
		request.setAttribute("id", request.getParameter("id"));
		request.getRequestDispatcher("/WEB-INF/views/AddNewPlayer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN add player");
		System.out.println(request.getParameter("id"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println(Team.list.get(id));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		System.out.println(age);
		Player newPlayer = new Player(first_name, last_name, age);
		Team.list.get(id).players.add(newPlayer);
//		Team newTeam = new Team(teamname);
		request.setAttribute("newPlayer", newPlayer);
		response.sendRedirect("/TeamRoster/Teams?id="+id);

	}

}
