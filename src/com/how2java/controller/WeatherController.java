package com.how2java.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
@Controller
public class WeatherController {
	@ResponseBody
	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	
	public String getWeather() {
		URL url = null;
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		try {		//http://api.help.bj.cn/api/
					//http://ip.ws.126.net/ipquery
			url = new URL("http://api.help.bj.cn/api/");
			in = new BufferedReader(new InputStreamReader(url.openStream(), "GBK"));
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		String data = sb.toString();
		int b = data.indexOf("{");
		String temp = data.substring(b);
		JSONObject json = JSONObject.parseObject(temp);
		// String parString = json.getString("")
		return json.toString();

	}


}
