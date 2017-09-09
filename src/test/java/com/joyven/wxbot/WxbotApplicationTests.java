package com.joyven.wxbot;

import com.joyven.wxbot.http.RestHttpsClient;
import com.joyven.wxbot.pojo.WxInitBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxbotApplicationTests {
	@Resource
	private SimpMessagingTemplate template;
	@Test
	public void contextLoads() {
	}
	@Test
	public void testPostJson() throws MalformedURLException, URISyntaxException {
		String url = "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxinit?pass_ticket=79cCDNP8KQAFQQ594Yz%2B8%2BRvgOB86P0e08oenKNPTDuO8MHt%2FP%2B2OfR5IozWmIEt&skey=@crypt_e97c11e1_8050940a281e11f0aef586c556b58d52&r=1504676721368&lang=en_US";
		Map<String, WxInitBase> map = new HashMap<>();
		WxInitBase initBase = new WxInitBase();
		initBase.setDeviceID("e032006428343032");
		initBase.setSid("/B35lE7dPNdHsvjt");
		initBase.setSkey("@crypt_e97c11e1_8050940a281e11f0aef586c556b58d52");
		initBase.setUin(450859080);
		map.put("BaseRequest", initBase);

//		String url = "http://localhost:9090/oper/category/add";
//		Map<String, String> map = new HashMap<>();
//		map.put("subject", "社保公积金12345");
//		map.put("description", "社保公积金API接入文档12345");
		String res = RestHttpsClient.postJson(url, null, map);
		System.out.println(res);

	}

	@Test
	public void send() {
		template.convertAndSend("/queue/check","hahaha");
	}

}
