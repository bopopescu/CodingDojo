package com.number.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuessTheNumber
 */
@WebServlet("/GuessTheNumber")
public class GuessTheNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuessTheNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer getrandomnumber = (Integer) session.getAttribute("getrandomnumber");
        System.out.println("dsdsdsdsd ewewewe dfdfdf wewewe ");

        System.out.println(getrandomnumber);
        if(getrandomnumber == null) {
        		getrandomnumber = (int)(Math.random()*(100)+1);
        }
  		session.setAttribute("getrandomnumber", getrandomnumber);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Number.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String say = (String) session.getAttribute("say");
		Integer getrandomnumber = (Integer) session.getAttribute("getrandomnumber");
		System.out.println(say);
		String guess = (String) request.getParameter("guess"); //from form -> guess
		System.out.println(guess);
		Double getguess = Double.parseDouble(guess);

  		if(getguess > getrandomnumber) {
  			session.setAttribute("say", "Too High!");
  		}
  		else if(getguess < getrandomnumber) {
  			session.setAttribute("say", "Too Low!");
  		}else {
  			session.setAttribute("say", "That's right!");
//  			session.invalidate();
//  			doGet(request, response);
  		}
			session.setAttribute("guess", getguess);

  	    response.sendRedirect("/GreatNumberGame/GuessTheNumber");

      }
      
		
	}


