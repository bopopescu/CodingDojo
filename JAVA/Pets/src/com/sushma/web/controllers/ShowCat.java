package com.sushma.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sushma.web.models.*;
/**
 * Servlet implementation class ShowCat
 */
@WebServlet("/ShowCat")
public class ShowCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("catname");
		String breed = request.getParameter("catbreed");
		Double weight = Double.parseDouble(request.getParameter("catweight"));
		String out = String.format("%s %s %f", name, breed, weight);
//		request.setAttribute("catname", name);
//		request.setAttribute("catbreed", breed);
//		request.setAttribute("catweight", weight);
		Cat thisnewCat = new Cat(name, breed, weight);
		System.out.println(thisnewCat.name);
		request.setAttribute("thisnewCat", thisnewCat);
		request.getRequestDispatcher("/WEB-INF/views/cat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
