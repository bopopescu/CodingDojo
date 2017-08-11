package com.team.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.models.*;

/**
 * Servlet implementation class DeletePlayer
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
		int deleting = Integer.parseInt(request.getParameter("delete"));
		int teamnumber = Integer.parseInt(request.getParameter("teamnumber"));
		System.out.println(Team.list.get(teamnumber));
		Team.list.get(teamnumber).killplayer(deleting);
//		for( int i = 0; i< Team.list.get(teamnumber).players.size(); i++) {
//			System.out.println(Team.list.get(teamnumber).players.get(i).last_name);
//		}
//		System.out.println(Team.list.get(teamnumber).players.get(deleting).first_name);
		response.sendRedirect("/TeamRoster/Teams?id="+teamnumber);	}
	}


