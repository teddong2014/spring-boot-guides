package com.ted;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {

	public static void main(String[] args) {
		String loginPage = get("http://localhost:7070/login");
		String cookie = loginPage.header("SET-COOKIE");
		String sessionId = cookie.split("; ")[0];
		String bodyStr = indexResponse.body().string();
		Pattern pattern = Pattern.compile("<input name=\"_csrf\" type=\"hidden\" value=\"(.{36})\" />");
		Matcher matcher = pattern.matcher(bodyStr);
		matcher.find();
		String loginCsrf = matcher.group(1);
	}

	public static String post(String url, Map<String, String> params) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new BasicNameValuePair(key, params.get(key)));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
		String body = invoke(httpclient, httpPost);
		try {
			httpclient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

	public static String get(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		String body = invoke(httpclient, httpGet);
		try {
			httpclient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

	public static String invoke(CloseableHttpClient httpclient, HttpUriRequest request) {
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity entity = response.getEntity();
		String body = null;
		try {
			body = EntityUtils.toString(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}
}
