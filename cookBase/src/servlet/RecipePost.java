package servlet;


import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.RecipeDAO;
import model.ValueCheck;


@WebServlet("/RecipePost")
@MultipartConfig(location="c:/tmp", maxFileSize=1048576)
public class RecipePost extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recipeSearch.jspからrecepiPOST.jspへ遷移するための仲介フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipePost.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String actionType = request.getParameter("action");

		if("upload".equals(actionType)) {
			Part part = request.getPart("photo_data");//料理写真

			//常に被らないファイル名を作成するためにタイムスタンプを使用
			long timeStamp = new Date().getTime();
			String name = timeStamp + "_" + this.getFileName(part);

			part.write(getServletContext().getRealPath("/uploaded") + "/" + name);

			request.setAttribute("upFile", name);	// アップロードファイル名をスコープに保存


		} else {

			String recipe_name = request.getParameter("recipe_name");//レシピ名
			String recipe_data = request.getParameter("recipe_data");//レシピ詳細

	        //レスポンス後に表示する結果メッセージ
	        String message = "";

			//入力値のチェック
	        String errMsg = ValueCheck.checkadd(recipe_name, recipe_data);

	        //入力値に問題がなければ投稿処理に入る
	        if("".equals(errMsg)) {
	        	//レシピテーブルへレシピ情報を登録
	        	RecipeDAO recipeDAO = new RecipeDAO();
	        	int insCnt = recipeDAO.post(recipe_name, recipe_data);

	        	//登録結果からメッセージを設定
	        	if(insCnt==1) {
	        		message+="投稿が完了しました。";
	        	} else {
	        		message+="投稿時に問題が発生しました。";
	        	}

	        } else {
	        	//入力値チェックエラーメッセージ
	        	message = errMsg;
	        }

	        //結果をリクエストスコープに保存
	        request.setAttribute("message",message);
		}

        //レシピ投稿画面にフォワード（自画面）
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recipePost.jsp");
		dispatcher.forward(request, response);


	}

	private String getFileName(Part part) {
		String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
	}



}
