package eu.fluppe.actions;

import java.util.ArrayList;

public class InsultMemoryService {
	private InsultData insultData;

	public InsultMemoryService(InsultData anInsultData) {
		this.insultData = anInsultData;

	}

	public void rememberInsult(String anInsult) {
		ArrayList<String> insults = insultData.getInsults();
		insults.add(anInsult);
		insultData.setInsults(insults);
		return;
	}
}