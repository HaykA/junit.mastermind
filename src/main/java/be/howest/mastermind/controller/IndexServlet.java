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
import be.howest.mastermind.exceptions.MasterMindCheckException;
import be.howest.services.SchemeService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index.htm")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	
	private final SchemeService schemeService = new SchemeService(); 

    /**
     * Default constructor. 
     */
    public IndexServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MasterMindFactory factory = new MasterMindFactory();
		Scheme scheme = schemeService.read(7L);
		MasterMind masterMind = factory.createMasterMind(scheme);
		
		try {
			int[] colors = {4, 3, 2, 7, 0, 1, 6, 8};
			masterMind.check(colors);
			colors = new int[] {5, 9, 0, 10, 1, 2, 8, 4};
			masterMind.check(colors);
			colors = new int[] {7, 8, 3, 2, 1, 6, 0, 4};
			masterMind.check(colors);
		} catch (MasterMindCheckException e) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
