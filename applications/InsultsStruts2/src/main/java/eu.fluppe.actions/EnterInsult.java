package eu.fluppe.actions;

import java.util.ArrayList;
//import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

//public class EnterInsult implements Action {
public class EnterInsult extends ActionSupport implements SessionAware {

	private String enteredInsult;
	private InsultData insultData;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {
		if(session.containsKey("insultData")) {
			insultData = (InsultData) session.get("insultData");
		} else {
			insultData = new InsultData();
		}
		
		InsultMemoryService insultMemoryService = new InsultMemoryService(insultData);
		if(enteredInsult != null) {
			insultMemoryService.rememberInsult(enteredInsult);	
		}	

		session.put("insultData", insultData);
		
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getEnteredInsult() {
		return enteredInsult;
	}

	public void setEnteredInsult(String enteredInsult) {
		this.enteredInsult = enteredInsult;
	}

	public ArrayList<String> getInsults() {
		return insultData.getInsults();
	}

	public void setInsults(ArrayList<String> insults) {
		this.insultData.setInsults(insults);
	}
}