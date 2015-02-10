package eu.fluppe;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {
//public class HelloAction {

	private String greeting;

	@Override
	public String execute() throws Exception {
		greeting = "Hello Struts 2";
		return "success";
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String aGreeting) {
		this.greeting = aGreeting;
	}
}