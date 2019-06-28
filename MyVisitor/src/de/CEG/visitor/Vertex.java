package de.CEG.visitor;

public class Vertex {

	int key;
	String content;
	String businessRule;
	boolean elseEffect;
	String type;

	public Vertex(int id, String aContent, String myBusinessRule, boolean isElseEffect, String aType) {
		key = id;
		content = aContent;
		businessRule = myBusinessRule;
		elseEffect = isElseEffect;
		type = aType;
	}

	public String toString() {
		return content;
	}

}
