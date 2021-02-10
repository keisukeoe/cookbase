package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Recipe;

/**
 * recipeテーブルへのアクセスを担当するDAOクラスです。
 */
public class RecipeDAO {
	private final String url = "jdbc:postgresql://localhost:5432/cookbase";
    private final String user = "postgres";
    private final String password = "test";

    /**
	 * recipeテーブルからレシピ名でデータを検索し、検索結果を返します。
	 */
    public List<Recipe> search(String name){
    	Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        List<Recipe> rRecords = null;

        try {
        	/* JDBCドライバの定義 */
	         Class.forName("org.postgresql.Driver");

	         /* PostgreSQLへの接続 */
	         con = DriverManager.getConnection(url, user, password);

	         /* SELECT文の準備 */
	         String sql = "SELECT * ";
	                sql+= "FROM recipe ";
	                sql+= "WHERE name like ? ";
	                sql+= "ORDER BY recipe_id ";
	         st = con.prepareStatement(sql);
	   	     st.setString(1, "%" + name + "%");

	   	     /* SELECT文の実行 */
	   	     rs = st.executeQuery();

	   	     /* 結果をリストに移し替える */
	   	     rRecords = makeResultData(rs);

        }catch(Exception e) {
        	System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
        }finally {
        	 /* PostgreSQLとの接続を切断 */
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}

			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {}
			}

			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
        }
			return rRecords;
       }

    /***
     * レシピテーブルに料理を1件追加
     */
    public int post(String recipe_name, String recipe_data) {
    	Connection con = null;
        PreparedStatement st = null;
        int insCnt = 0;		// 更新件数

        try {
        	/* JDBCドライバの定義 */
	         Class.forName("org.postgresql.Driver");

	         /* PostgreSQLへの接続 */
	         con = DriverManager.getConnection(url, user, password);

	         /* INSERT分の準備 */
	         String sql="";
	                sql+="INSERT INTO recipe(name, recipe_data) ";
	                sql+="VALUES(?, ?);";

	         st = con.prepareStatement(sql);
	   	     st.setString(1, recipe_name);
	   	     st.setString(2, recipe_data);


	   	     /* INSERT文の実行 */
	   	     insCnt = st.executeUpdate();

        }catch(Exception e) {
        	System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
        }finally {
        	if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {}
			}

			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
        }

        return insCnt;
    }



    /***
     * 検索結果をリストで返す
     */
    public ArrayList<Recipe> makeResultData(ResultSet rs) throws Exception{
    	//検索結果を格納するリストを準備
    	ArrayList<Recipe> rRecords = new ArrayList<Recipe>();

    	//1行分のデータを読む（読めなくなるまで）
    	while(rs.next()) {
    		String name = rs.getString("name");
    		String recipe_data = rs.getString("recipe_data");

    		//1行分のデータを格納するインスタンス(要JavaBeans)
    		Recipe rRecord = new Recipe(name, recipe_data);

    		//1行分のインスタンスをリストに格納
    		rRecords.add(rRecord);
    	}

    	return rRecords;
    }


}
