package com.sp1.checkDeck;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class jsonTest
{
	
	public void makeJson() throws JSONException
	{

		JSONObject root = new JSONObject();
		JSONArray data = new JSONArray();
		String fcmtoken = null;
		String packageName = null;
		String[] url_array = { "kakao.com", "naver.com", "plantynet.com"};
		
		    JSONObject jsonObject = new JSONObject();
		    jsonObject.put("contentID", "test_contentId");
		    jsonObject.put("content", "test_content");
		    jsonObject.put("urls", new JSONArray(url_array));
		    jsonObject.put("checkResult", "test_checkResult");
		    jsonObject.put("userID", "admin");
		    jsonObject.put("messageType", "test_messageType");
		    data.put(jsonObject);

		    root.put("packageName", "test_packageName");
		    root.put("fcmToken", "test_fcmToken");
		    root.put("data", data);
		    String result = root.toString();
		    
		    System.out.println(result);
	}
	
	@Test
	void test() throws JSONException
	{
		makeJson();
	}
	
}
