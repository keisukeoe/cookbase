package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecipeDAO;
import model.Recipe;


@WebServlet("/RecipeSearch")
public class RecipeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//index.jspからrecepiSearch.jspへ遷移するための仲介フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipeSearch.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String recipe_name = request.getParameter("recipe_name");

		//検索条件に該当するレシピ情報をレシピテーブルから検索
		RecipeDAO recipeDAO = new RecipeDAO();
		List<Recipe> recipeList = recipeDAO.search(recipe_name);

		//検索結果をリクエストスコープに保存
		request.setAttribute("recipeList",recipeList);

		//フォワード（検索結果画面）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchResult.jsp");
		dispatcher.forward(request, response);

	}

}
