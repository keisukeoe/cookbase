package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ユーザー登録画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String pass = request.getParameter("pass");

		//Userインスタンスの（ユーザー情報）の生成
		User user = new User(name, pass);

		//ユーザー登録処理・・・アプリケーションスコープ内の他のユーザ情報と照合
		//メンバーリストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<User> memberList = (List<User>)application.getAttribute("memberList");

		//アプリケーションスコープが初回nullの時
		if(memberList==null) {
			memberList = new ArrayList<>();
			application.setAttribute("memberList", memberList);
		}



		//ユーザー登録
		if((user.getName().length()==0 || user.getName()==null) || (user.getPass().length()==0 || user.getPass()==null)) {
			//名前かパスワードが未記入
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "名前とパスワードは必須項目です");

		}else if(userRegistCheck(user, memberList)){//すでに同名のユーザーがアプリケーションスコープに登録されていた場合

			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "そのユーザーは既に登録されています");

		}else {//アプリケーションスコープに同じ名前がない場合

			//ユーザー登録成功
			//アプリケーションスコープに保存
			memberList.add(user);
			application.setAttribute("memberList", memberList);
			//サクセスメッセージをリクエストスコープに保存
			request.setAttribute("successMsg", "登録が完了しました。ログイン画面よりご入場ください");
		}

		//登録画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);


	}

	//同名登録ユーザーチェック
	public boolean userRegistCheck(User user, List<User> memberList) {

		for(int i=0 ; i < memberList.size(); i++) {
			if(memberList.get(i).getName().equals(user.getName())) {
				return true;
			}
		}
		return false;
	}
}
