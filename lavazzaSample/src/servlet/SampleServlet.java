package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet({ "/SampleServlet", "/sampleservlet", "/sampleSample", "/abc" })
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) throws ServletException, 
						 									  IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/SampleJsp.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, 
						  									   IOException {
		boolean isRunnning = Boolean.valueOf(request.getParameter("isRunning"));
		// isRunningをセッションスコープに保存
		
		// isRunningがtrueならSampleLogicを始動
		
		// isRunningがfalseならSampleLogicを終了
		
		// SampleLogicへの依頼と同時にSampleJspに表示を依頼
	}

}
