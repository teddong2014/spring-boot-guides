package com.ted;
import java.util.ArrayList;

import java.util.List;

import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;

import org.apache.http.NameValuePair;

import org.apache.http.client.CookieStore;

import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.impl.cookie.BasicClientCookie;

import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EntityUtils;

public class PengTest {

	/*@SuppressWarnings("deprecation")

	public static void main(String[] args) throws Exception {

		DefaultHttpClient httpclient = new DefaultHttpClient();

		try {

			HttpPost httpPost = new HttpPost("http://localhost:7070/login");

			List<NameValuePair> params = new ArrayList<NameValuePair>();

			params.add(new BasicNameValuePair("Menu", "CASE"));

			params.add(new BasicNameValuePair("IsFullTextSearch", "False"));

			params.add(new BasicNameValuePair("MatchType", "Exact"));

			params.add(new BasicNameValuePair("Keywords", "%E4%B8%93%E5%88%A9"));

			params.add(new BasicNameValuePair("OrderByIndex", "0"));

			params.add(new BasicNameValuePair("GroupByIndex", "0"));

			params.add(new BasicNameValuePair("ShowType", "1"));

			params.add(new BasicNameValuePair("ClassCodeKey", ",,+"));

			params.add(new BasicNameValuePair("Library", "PFNL"));

			params.add(new BasicNameValuePair("SubKeyword",
					"%E5%9C%A8%E7%BB%93%E6%9E%9C%E7%9A%84%E6%A0%87%E9%A2%98%E4%B8%AD%E6%A3%80%E7%B4%A2"));

			params.add(new BasicNameValuePair("GroupIndex", "0"));

			params.add(new BasicNameValuePair("GroupValue", "06"));

			params.add(new BasicNameValuePair("X-Requested-With", "XMLHttpRequest"));

			params.add(new BasicNameValuePair("Pager.PageSize", "50"));

			params.add(new BasicNameValuePair("Pager.PageIndex", "1"));

			httpPost.setEntity(new UrlEncodedFormEntity(params));

			CookieStore cookieStore = httpclient.getCookieStore();

			BasicClientCookie cookie1 = new BasicClientCookie("IIIV1101195008",
					"#BEGMD5#dda89f3329f62414865b0a33134d3f81#ENDMD5#2-lib|1052124|32|48|96|0");

			cookie1.setDomain(".lib.ecnu.edu.cn");

			cookie1.setPath("/");

			cookieStore.addCookie(cookie1);

			BasicClientCookie cookie2 = new BasicClientCookie("ASP.NET_SessionId", "gvtlnknerbngei3t2wzywiyc");

			cookie2.setDomain("0-www.pkulaw.cn.libecnu.lib.ecnu.edu.cn");

			cookie2.setPath("/");

			cookieStore.addCookie(cookie2);

			BasicClientCookie cookie3 = new BasicClientCookie("FWinCookie", "1");

			cookie3.setDomain("0-www.pkulaw.cn.libecnu.lib.ecnu.edu.cn");

			cookie3.setPath("/");

			cookieStore.addCookie(cookie3);

			BasicClientCookie cookie4 = new BasicClientCookie("Hm_lvt_58c470ff9657d300e66c7f33590e53a8",
					"1462509927,1462510208,1462510573,1462510597");

			cookie4.setDomain("0-www.pkulaw.cn.libecnu.lib.ecnu.edu.cn");

			cookie4.setPath("/");

			cookieStore.addCookie(cookie4);

			BasicClientCookie cookie5 = new BasicClientCookie("Hm_lpvt_58c470ff9657d300e66c7f33590e53a8", "1462511229");

			cookie5.setDomain("0-www.pkulaw.cn.libecnu.lib.ecnu.edu.cn");

			cookie5.setPath("/");

			cookieStore.addCookie(cookie5);

			BasicClientCookie cookie6 = new BasicClientCookie("bdyh_record",
					"1970324843207951%2C1970324843207950%2C1970324844973695%2C1970324844973694%2C1970324839426726%2C1970324839426735%2C1970324839426758%2C1970324844973697%2C");

			cookie6.setDomain("0-www.pkulaw.cn.libecnu.lib.ecnu.edu.cn");

			cookie6.setPath("/");

			cookieStore.addCookie(cookie6);

			httpclient.setCookieStore(cookieStore);

			// Execute the request

			HttpResponse response = httpclient.execute(httpPost);

			System.out.println(response.getStatusLine());

			HttpEntity entity2 = response.getEntity();

			System.out.println(EntityUtils.toString(entity2, "utf-8"));

		} finally {

			httpclient.close();

		}

	}*/

}
