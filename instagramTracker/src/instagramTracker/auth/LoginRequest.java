package instagramTracker.auth;

import instagramTracker.utils.Constants;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class LoginRequest {

	private String accessToken;
	private HttpsURLConnection connection;
	private final String secret = Constants.CLIENT_SECRET;
	private final String CLIENT_ID = Constants.CLIENT_ID;
	private final String REDIRECT_URI = "http%3A%2F%2Flocalhost%3A8000";

	public LoginRequest() {
		login();
	}

	private void login() {
		accessToken = getAccessToken();

		try {
			URL url = new URL("instagram");

			connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String retrieveAccessToken() {

		String request = "https://api.instagram.com/oauth/authorize/?client_id="
				+ CLIENT_ID
				+ "&redirect_uri="
				+ REDIRECT_URI
				+ "&response_type=token";

		try {
			URL url = new URL(request);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return request;

	}

	public String getAccessToken() {
		return accessToken;
	}
}
