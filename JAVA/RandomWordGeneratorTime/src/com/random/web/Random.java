package com.random.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Random
 */
@WebServlet("/Random")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Random() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer get = (Integer) session.getAttribute("count");
        String getthatdate = (String) session.getAttribute("date");

//        String getdate = (String) session.getAttribute("date");
		String newstr = "";
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K",
		                     "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
		                     "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7",
		                     "8", "9"};
		for(int i = 0; i < 10; i++) {
			int random = (int)(Math.random()*(alphabet.length)+0);
			newstr = newstr.concat(alphabet[random]);
		}

        if(get == null) {
        		session.setAttribute("count", 0);
        		session.setAttribute("date", "Null");
        		session.setAttribute("thatstring", "");
        }
        else {
			//Integer clicks1 = (Integer) session.getAttribute("count");
			get++;
        		session.setAttribute("count", get);
        		session.setAttribute("date", getthatdate);
        		session.setAttribute("thatstring", newstr);

        }
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/generate.jsp");
        view.forward(request, response);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        // Get the date today using Calendar object.
        Date today = new Date();    
        // Using DateFormat format method we can create a string 
        // representation of a date with the defined format.
        String reportDate = df.format(today);
        session.setAttribute("date", reportDate);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
