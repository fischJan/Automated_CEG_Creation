package de.CEG.visitor;

import org.jgrapht.graph.DefaultEdge;

public class Relationship extends DefaultEdge {
	
	private String label;
	
	public Relationship(String einLabel) {
		this.label = einLabel;
	}
	
	@Override
	public String toString() {
		return label;
	}

}
