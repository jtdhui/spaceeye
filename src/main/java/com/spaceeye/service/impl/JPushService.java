package com.spaceeye.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;



import cn.jpush.api.JPushClient;
import cn.jpush.api.common.ClientConfig;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JPushService {
	
	 private static final Logger log = Logger.getLogger(JPushService.class);  
	 private final static String appKey = "1cfa7b67942c01375250e839";    
	    private final static String masterSecret = "bc9a14343895926f9868572c"; 
	    
	    public static void main( String[] args )
	    {
	    	Map<String,String> map =new HashMap<String,String>();
	    	map.put("title","推送信息");
	    	map.put("url", "www.baidu.com");
	    	map.put("cat","0");
	    	sendPushAll(map);    
	    }
	    /**
	     * 极光推送
	     */
	    public static void sendPushAll(Map<String,String> map){
	        PushResult result = push(map);
	        if(result != null && result.isResultOK()){
	            log.info("信息推送成功！");
	        }else{
	            log.info("信息推送失败！");
	        }
	    }
	    
	    /**
	     * 生成极光推送对象PushPayload（采用java SDK）
	     * @param alias
	     * @param alert
	     * @return PushPayload
	     */
	    public static PushPayload buildPushObject_android_ios_alias_alert(Map<String,String> map){
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.android_ios())
	                .setAudience(Audience.all())
	                .setNotification(Notification.newBuilder()
	                        .addPlatformNotification(AndroidNotification.newBuilder().addExtras(map)
//	                                .addExtra("type", "infomation")
//	                                .addExtra("url", map.get("url"))
//	                                .addExtra("cat", map.get("cat"))
	                                .setAlert(map.get("title"))
	                                .build())
	                         .addPlatformNotification(IosNotification.newBuilder().addExtras(map)
//	                                .addExtra("type", "infomation")
//	                                .addExtra("url", map.get("url"))
//	                                .addExtra("cat", map.get("cat"))
	                                .setAlert(map.get("title"))
	                                .build())
	                        .build())
	                .setOptions(Options.newBuilder()
	                        .setApnsProduction(false)//true-推送生产环境 false-推送开发环境（测试使用参数）
	                        .setTimeToLive(90)//消息在JPush服务器的失效时间（测试使用参数）
	                        .build())
	                .build();
	    }
	    /**
	     * 极光推送方法(采用java SDK)
	     * @param alias
	     * @param alert
	     * @return PushResult
	     */
	    public static PushResult push(Map<String,String> map){
	        ClientConfig clientConfig = ClientConfig.getInstance();
	        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
	        PushPayload payload = buildPushObject_android_ios_alias_alert(map);
	        try {
	            return jpushClient.sendPush(payload);
	        } catch (APIConnectionException e) {
	            log.error("Connection error. Should retry later. ", e);
	            return null;
	        } catch (APIRequestException e) {
	            log.error("Error response from JPush server. Should review and fix it. ", e);
	            log.info("HTTP Status: " + e.getStatus());
	            log.info("Error Code: " + e.getErrorCode());
	            log.info("Error Message: " + e.getErrorMessage());
	            log.info("Msg ID: " + e.getMsgId());
	            return null;
	        }    
	    }

}
