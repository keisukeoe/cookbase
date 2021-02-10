package model;

import java.util.List;
import javax.servlet.ServletContext;
import servlet.Register;

public class LoginLogic {


	public boolean execute(User user, List<User> memberList) {
		if(memberList != null) {//*1
			for(int i=0 ; i < memberList.size(); i++) {
				if(memberList.get(i).getName().equals(user.getName())) {//メンバーリストと名前が一致するか
					if(memberList.get(i).getPass().equals(user.getPass())) {//メンバーリストとパスワードが一致するか
						return true; //本人と一致
					}
				}
			}
		}
		return false; //不一致
	}
}

//*1 (memberList != null)…メンバーリストがnull(ユーザー登録者が0人)の状態でログインボタンが押された時、何もないアプリケーションスコープに対して処理を行おうとしてエラーを起こすため