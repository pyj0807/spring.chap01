package controllers.study;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import model.AlertService;

/*
 * ws 요청 받는 컨트롤러는 http 요청 받는 컨트롤러와 작성 요령이 다르다.
 * 
 * 1. TextWebSocketHandler 를 extends
 * 
 * 2. WebSocket 매핑은 어노테이션 (@GetMapping/ @RequestMapping) 이런 형태가 아니라 수동으로 설정을 해야 한다.
 */

@Controller
public class ZuluController extends TextWebSocketHandler {
	@Autowired
	Gson gson;
	
	@Autowired
	AlertService service;
	
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 클라이언트측에서 WebSocket 객체를 생성해서 연결이 될 때.
		service.addSocket(session);
		
		System.out.println("afterConnectionEstablished ..\n"+ session);
		Map data = new HashMap();
		data.put("mode", "welcome");
		data.put("count", service.size());
		
		service.sendAll(data);
	
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 클라이언트측에서 사용중인 WebSocket 이 종료 될때.
		System.out.println("afterConnectionClosed");
		service.removeSocket(session);
		
	
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 클라이언트측에서 WebSocket 객체를 통해 데이터를 전송했을때.
		String payload = message.getPayload();
		System.out.println("handleTextMessage : " + payload);
		Map data = new HashMap();
			data.put("mode", "login");
			data.put("actor", "박영준");
		TextMessage msg = new TextMessage(gson.toJson(data));
		session.sendMessage(msg);
	}
	

}
