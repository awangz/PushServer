package com.ctsi.push.demo;

import java.util.HashMap;

import com.ctsi.push.api.PushApi;
import com.ctsi.push.jpush.JPushApi;
import com.ctsi.push.message.CommandAction;
import com.ctsi.push.message.CommandMessage;
import com.ctsi.push.message.CommandMessageBuilder;
import com.ctsi.push.message.PushResponse;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

/**
 * Hello world!
 *
 */
public class App {
	private static final String masterSecret = "b857c8c5d033ff534828b795";

	private static final String appKey = "1008fb255a7f1b8bd339a745";

	static PushApi api = JPushApi.init(masterSecret, appKey);

	public static void main(String[] args) {
		System.out.println("Hello World!");
		CommandMessage message1 = CommandMessage.builder().toAlias("18911552163").noticeContent("测试", "123").build();
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("user", "liyao");
		map.put("id", "123");
		
		CommandMessage message2= CommandMessage.builder().timeExpire(300).toAlias("13311097869").noticeContent("测试title", "内容").commandAction(CommandAction.COMMAND_TYPE_URL, "http://www.baidu.com", map).build();
				
		try {
			PushResponse response = api.push(message2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
