package miniBook;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class NaverApiCaller {
	String clientID = "hEXQ0_5PvioNhHNeXSFx";
	String secret = "m8VlYwqi8t";
	static int counter;

	public List<Book> call(String query) {
		List<Book> list = new ArrayList<Book>();
		int respCode = 0;
		InputStream is = null;
		try {
			query = URLEncoder.encode(query, "utf-8");
			String url = "https://openapi.naver.com/v1/search/book.json?query=" + query + "&display=100";

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("X-Naver-Client-Id", clientID);
			conn.setRequestProperty("X-Naver-Client-Secret", secret);
			respCode = conn.getResponseCode(); // 200
			is = conn.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(respCode + "수신 성공");
		if (respCode == HttpURLConnection.HTTP_OK) {
			StringBuilder sb = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is));) {
				String tmp = null;
				while (null != (tmp = br.readLine())) {
					sb.append(tmp);
				}
				list = StringJSON2List(sb.toString());
//				oos.writeObject(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public List<Book> StringJSON2List(String str) {
		JSONObject jObject = new JSONObject(str);
		JSONArray jArray = (JSONArray) jObject.get("items");
		List<Book> list = new ArrayList<>();

		for (int i = 0; i < jArray.length(); i++) {
			JSONObject item = (JSONObject) jArray.get(i);
			String title = item.getString("title");
			String author = item.getString("author");
			String isbn = item.getString("isbn");
			String publisher = item.getString("publisher");
			String description = item.getString("description");
//			String pubdate = item.getString("pubdate"); // ? 안쓰는듯
			Integer discount = item.getInt("discount");

			Book book = new Book(String.format("%04d", ++counter), title, author, publisher, isbn, description,
					discount, 0, false, false);
			list.add(book);
			System.out.println(list);
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		NaverApiCaller nac = new NaverApiCaller();
		String[] queries = { "어린왕자" };
		List<Book> results = new ArrayList<Book>();
		Arrays.asList(queries).forEach(s -> results.addAll(nac.call(s)));

		results.forEach(System.out::println);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"));
		oos.writeObject(results);
		oos.close();
	}
}
