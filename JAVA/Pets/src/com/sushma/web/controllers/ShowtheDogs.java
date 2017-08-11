package com.sushma.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sushma.web.models.*;
/**
 * Servlet implementation class ShowtheDogs
 */
@WebServlet("/ShowtheDogs")
public class ShowtheDogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowtheDogs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("dogname");
		String breed = request.getParameter("dogbreed");
		Double weight = Double.parseDouble(request.getParameter("dogweight"));
		String out = String.format("%s %s %f", name, breed, weight);
//		request.setAttribute("dogname", name);
//		request.setAttribute("dogbreed", breed);
//		request.setAttribute("dogweight", weight);
		Dog thisnewDog = new Dog(name, breed, weight);
		System.out.println(thisnewDog.name);
		request.setAttribute("dog", thisnewDog);
		request.getRequestDispatcher("/WEB-INF/views/dog.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
