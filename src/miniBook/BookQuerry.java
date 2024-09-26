package miniBook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BookQuerry {
	String clientID = "tqo7kxREe4GFC4lx0fAK";
	String secret = "jcYW9V3xwB";

	public void call() throws Exception {
		String query = "폭풍의 언덕";
		query = URLEncoder.encode(query, "utf-8");
		String url = "https://openapi.naver.com/v1/search/book.json?query=" + query + "&display=100";

		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("X-Naver-Client-Id", clientID);
		conn.setRequestProperty("X-Naver-Client-Secret", secret);

		int respCode = conn.getResponseCode(); // 200
		System.out.println(respCode);
		if (respCode == HttpURLConnection.HTTP_OK) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
				String tmp = null;
				while (null != (tmp = br.readLine())) {
					System.out.println(tmp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
