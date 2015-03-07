package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SampleLogic;

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
		// セッションスコープからisRunningの値を取得
		boolean isRunning = false;
		HttpSession session = request.getSession();
		if(session.getAttribute("isRunning") != null){
			isRunning = (Boolean) session.getAttribute("isRunning");
		} else {
			// nullだったらfalseを保存しておく
			session.setAttribute("isRunning", isRunning);
		}
		// SampleJspへ表示を依頼
		RequestDispatcher rd = request.getRequestDispatcher("/SampleJsp.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, 
						  									   IOException {
		// リクエストスコープからisRunningの値を取得
		request.setCharacterEncoding("UTF-8");
		boolean isRunning = Boolean.valueOf(request.getParameter("isRunning"));
		// isRunningをセッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("isRunning", isRunning);
		// SampleLogicへ処理の依頼
		SampleLogic logic;
		if(isRunning == true){
			// これから開始せよというリクエストなら、新しくインスタンスを生成
			logic = new SampleLogic();
			session.setAttribute("logic", logic);
		}else{
			// これから終了せよというリクエストなら、既存のインスタンスを取得
			logic = (SampleLogic) session.getAttribute("logic");
		}
		boolean done = false;
		while(done == false){
			done = logic.doIt(request);
		}
		// SampleJspに表示を依頼
		RequestDispatcher rd = request.getRequestDispatcher("/SampleJsp.jsp");
		rd.forward(request, response);
	}

}
