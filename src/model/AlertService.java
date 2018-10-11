package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;



@Service
public class AlertService {
	List<WebSocketSession> list;
	
	@Autowired
	Gson gson;
	
	
	
	
	public AlertService() {
		list = new ArrayList<>();
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean addSocket(WebSocketSession tartget) {
		
		return list.add(tartget);
	}
	
	public boolean removeSocket(WebSocketSession tartget) {
		return list.remove(tartget);
	}
	
	public void sendAll(String txt) {
		for (int i = 0; i < list.size(); i++) {
			TextMessage msg = new TextMessage(txt);
			try {
				list.get(i).sendMessage(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void sendAll(Map map) {
		sendAll(gson.toJson(map));
	}
	
}
