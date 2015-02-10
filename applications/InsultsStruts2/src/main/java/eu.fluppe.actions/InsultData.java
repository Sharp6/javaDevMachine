package eu.fluppe.actions;

import java.util.ArrayList;

public class InsultData {
	private ArrayList<String> insults;

	public InsultData() {
		insults = new ArrayList<String>();
		insults.add("Ge hebt een lelijk gezicht.");
		insults.add("Ge zijt helemaal niet slim.");
		insults.add("Ge zijt lui.");
	}

	public ArrayList<String> getInsults() {
		return insults;
	}

	public void setInsults(ArrayList<String> insults) {
		this.insults = insults;
	}
}