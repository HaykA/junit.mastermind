package be.howest.mastermind.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.howest.entities.Scheme;
import be.howest.mastermind.MasterMind;
import be.howest.mastermind.MasterMindFactory;
import be.howest.mastermind.exceptions.InvalidAttemptException;
import be.howest.services.SchemeService;

/**
 * Servlet implementation class MasterMindServlet
 */
@WebServlet({"/mastermind/", "/mastermind"})
public class MasterMindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/mastermind.jsp";
	private final SchemeService schemeService = new SchemeService(); 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MasterMindFactory factory = new MasterMindFactory();
		Scheme scheme = schemeService.read(7L);
		MasterMind masterMind = factory.createMasterMind(scheme);
		
		try {
			int[] colors = {4, 3, 2, 7, 0, 6, 1, 8};
			masterMind.check(colors);
			colors = new int[] {5, 9, 0, 10, 1, 2, 8, 4};
			masterMind.check(colors);
			colors = new int[] {7, 8, 3, 2, 1, 6, 0, 4};
			masterMind.check(colors);
		} catch (InvalidAttemptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("masterMind", masterMind);
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("schemeId"));
		doGet(request, response);
	}

}
