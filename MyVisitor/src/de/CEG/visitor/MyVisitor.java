package de.CEG.visitor;

import java.util.ArrayList;
import org.antlr.v4.runtime.ParserRuleContext;
import org.jgrapht.*;
import org.jgrapht.graph.*;
import de.CEG.parser.ExprBaseVisitor;
import de.CEG.parser.ExprParser.BusinessRuleContext;
import de.CEG.parser.ExprParser.CauseContext;
import de.CEG.parser.ExprParser.EffectContext;
import java.util.List;

public class MyVisitor extends ExprBaseVisitor<String> {

	// List of business rules (needed to visualize nestings)
	List<BusinessRuleContext> businessRules = new ArrayList<BusinessRuleContext>();

	// List of content nodes (causes)
	List<CauseContext> causes = new ArrayList<CauseContext>();

	// List of assignment nodes (causes)
	List<CauseContext> connector = new ArrayList<CauseContext>();

	// List of assignment nodes (effects)
	List<EffectContext> connectorEffects = new ArrayList<EffectContext>();

	// List of content nodes (effects)
	List<EffectContext> effects = new ArrayList<EffectContext>();

	// List of "single" causes (connected by assignment nodes_dis)
	List<Vertex> isolatedCauses = new ArrayList<Vertex>();

	// List of "single" effects (connected by assignment nodes_dis)
	List<Vertex> isolatedEffects = new ArrayList<Vertex>();

	Graph<Vertex, Relationship> directedGraph = new DefaultDirectedGraph<Vertex, Relationship>(Relationship.class);

	@Override
	public String visitCause(CauseContext ctx) {
		// Post Order!
		visitChildren(ctx);

		// Detect causes and create vertex for each cause.
		if (!ctx.getChild(1).toString().equals("AND") && !ctx.getChild(1).toString().equals("OR")) {
			causes.add(ctx);
			Vertex newVertex = new Vertex(ctx.hashCode(), ctx.getText(), findMyBusinessRule(ctx), false, "Cause");
			directedGraph.addVertex(newVertex);

		} else if (ctx.getChild(1).toString().equals("AND")) {
			// Detect assignment nodes_con and create vertex to visualize CEG
			// connections_con (needed if we have a combination of related causes and single
			// causes).
			connector.add(ctx);
			Vertex newVertex = new Vertex(ctx.hashCode(), "AND", findMyBusinessRule(ctx), false, "Cause-Connector");
			directedGraph.addVertex(newVertex);

		} else if (ctx.getChild(1).toString().equals("OR")) {
			// Detect assignment nodes_dis.
			connector.add(ctx);

		}
		return null;
	}

	// Establish connections between causes. Related causes are associated by CEG
	// connections_con, while single causes are connected via CEG connections_dis.
	public void connectVertices() {

		for (CauseContext singleCause : causes) {
			Vertex correspondingVertex = null;

			for (Vertex einVertex : directedGraph.vertexSet()) {
				if (singleCause.hashCode() == einVertex.key) {
					correspondingVertex = einVertex;
				}
			}

			// 1. Case: Content node, located on the "left side" of the parent node and the
			// parent node is assignment node_con. --> search for assignment node_con at the
			// lowest depth.
			if (singleCause.parent.getChild(1).toString().equals("AND")
					&& singleCause.equals(singleCause.parent.getChild(0))) {

				ParserRuleContext potentialANDVertex;

				potentialANDVertex = singleCause.getParent();
				while (this.hasParentCause(potentialANDVertex)
						&& potentialANDVertex.parent.getChild(1).toString().equals("AND")) {
					potentialANDVertex = potentialANDVertex.getParent();
				}

				for (Vertex einVertex : directedGraph.vertexSet()) {
					if (potentialANDVertex.hashCode() == einVertex.key) {
						directedGraph.addEdge(correspondingVertex, einVertex, new Relationship(""));
					}
				}
			}

			// 2. Case: Content node, located on the "right side" of the parent node and the
			// parent node is assignment node_con. --> same procedure as in case 1.
			if (singleCause.parent.getChild(1).toString().equals("AND")
					&& singleCause.equals(singleCause.parent.getChild(2))) {

				ParserRuleContext potentialANDVertex;

				potentialANDVertex = singleCause.getParent();

				while (this.hasParentCause(potentialANDVertex)
						&& potentialANDVertex.parent.getChild(1).toString().equals("AND")) {
					potentialANDVertex = potentialANDVertex.getParent();
				}

				for (Vertex einVertex : directedGraph.vertexSet()) {
					if (potentialANDVertex.hashCode() == einVertex.key) {
						directedGraph.addEdge(correspondingVertex, einVertex, new Relationship(""));
					}
				}
			}

			// 3. Case: Content node, located on the "right side" of the parent node and the
			// parent node is assignment node_dis. Causes is either isolated or belongs to
			// the parent node (assignment node_con) of its current parent node.
			if (singleCause.parent.getChild(1).toString().equals("OR")
					&& singleCause.equals(singleCause.parent.getChild(2))) {

				ParserRuleContext potentialANDVertex;

				potentialANDVertex = singleCause.getParent().getParent();

				if (potentialANDVertex.getChild(1).toString().equals("AND")) {

					while (this.hasParentCause(potentialANDVertex)
							&& potentialANDVertex.parent.getChild(1).toString().equals("AND")) {
						potentialANDVertex = potentialANDVertex.getParent();
					}

					for (Vertex einVertex : directedGraph.vertexSet()) {
						if (potentialANDVertex.hashCode() == einVertex.key) {
							directedGraph.addEdge(correspondingVertex, einVertex, new Relationship(""));
						}
					}

				} else {
					isolatedCauses.add(correspondingVertex);
				}
			}

			// 4. Fall: Content node, located on the "left side" of the parent node and the
			// parent node is assignment node_dis. --> cause is isolated.

			if (singleCause.parent.getChild(1).toString().equals("OR")
					&& singleCause.equals(singleCause.parent.getChild(0))) {
				isolatedCauses.add(correspondingVertex);
			}

			// 5. Fall: Content node and no parent cause node.
			if (hasParentCause(singleCause) == false) {
				isolatedCauses.add(correspondingVertex);
			}
		}
	}

	// Establish connections between effects. Same cases as described above.
	public void connectEffects() {

		for (EffectContext singleEffect : effects) {
			Vertex correspondingVertex = null;

			for (Vertex einVertex : directedGraph.vertexSet()) {
				if (singleEffect.hashCode() == einVertex.key) {
					correspondingVertex = einVertex;
				}
			}

			if (singleEffect.parent.getChild(1).toString().equals("AND")
					&& singleEffect.equals(singleEffect.parent.getChild(0))) {

				ParserRuleContext potentialANDVertex;

				potentialANDVertex = singleEffect.getParent();
				while (this.hasParentEffect(potentialANDVertex)
						&& potentialANDVertex.parent.getChild(1).toString().equals("AND")) {
					potentialANDVertex = potentialANDVertex.getParent();
				}

				for (Vertex einVertex : directedGraph.vertexSet()) {
					if (potentialANDVertex.hashCode() == einVertex.key) {
						directedGraph.addEdge(einVertex, correspondingVertex, new Relationship(""));
					}
				}
			}

			if (singleEffect.parent.getChild(1).toString().equals("AND")
					&& singleEffect.equals(singleEffect.parent.getChild(2))) {

				ParserRuleContext potentialANDVertex;

				potentialANDVertex = singleEffect.getParent();

				while (this.hasParentEffect(potentialANDVertex)
						&& potentialANDVertex.parent.getChild(1).toString().equals("AND")) {
					potentialANDVertex = potentialANDVertex.getParent();
				}

				for (Vertex einVertex : directedGraph.vertexSet()) {
					if (potentialANDVertex.hashCode() == einVertex.key) {
						directedGraph.addEdge(einVertex, correspondingVertex, new Relationship(""));
					}
				}
			}

			if (singleEffect.parent.getChild(1).toString().equals("OR")
					&& singleEffect.equals(singleEffect.parent.getChild(2))) {

				ParserRuleContext potentialANDVertex;

				potentialANDVertex = singleEffect.getParent().getParent();

				if (potentialANDVertex.getChild(1).toString().equals("AND")) {

					while (this.hasParentEffect(potentialANDVertex)
							&& potentialANDVertex.parent.getChild(1).toString().equals("AND")) {
						potentialANDVertex = potentialANDVertex.getParent();
					}

					for (Vertex einVertex : directedGraph.vertexSet()) {
						if (potentialANDVertex.hashCode() == einVertex.key) {
							directedGraph.addEdge(einVertex, correspondingVertex, new Relationship(""));
						}

					}

				} else {
					isolatedEffects.add(correspondingVertex);
				}
			}

			if (singleEffect.parent.getChild(1).toString().equals("OR")
					&& singleEffect.equals(singleEffect.parent.getChild(0))) {
				isolatedEffects.add(correspondingVertex);
			}

			if (hasParentEffect(singleEffect) == false) {
				isolatedEffects.add(correspondingVertex);
			}
		}
	}

	// This method checks, whether the parent node is a assignment node_con linking
	// related causes. This helper method is necessary to find the assignment
	// node_con at the lowest depth and to ensure the minimum number of intermediate
	// nodes.
	public boolean hasParentCause(ParserRuleContext parserRuleContext) {

		if (this.connector.contains(parserRuleContext.getParent())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasParentEffect(ParserRuleContext parserRuleContext) {

		if (this.connectorEffects.contains(parserRuleContext.getParent())) {
			return true;
		} else {
			return false;
		}
	}

	public void deleteUnnecessaryConnectors() {

		List<Vertex> unnecessaryConnectors = new ArrayList<Vertex>();

		for (Vertex einVertex : directedGraph.vertexSet()) {
			if (einVertex.content.equals("AND")) {
				if (directedGraph.edgesOf(einVertex).isEmpty()) {
					unnecessaryConnectors.add(einVertex);
				}
			}
		}

		for (Vertex einVertex : unnecessaryConnectors) {
			directedGraph.removeVertex(einVertex);
		}
	}

	// Method creates vertices for each effect. Similar implementation to method
	// "visitCause".
	@Override
	public String visitEffect(EffectContext ctx) {

		Vertex newVertex;

		// Post Order!
		visitChildren(ctx);

		if (!ctx.getChild(1).toString().equals("AND") && !ctx.getChild(1).toString().equals("OR")) {
			effects.add(ctx);
			if (isElseEffect(ctx) == true) {
				newVertex = new Vertex(ctx.hashCode(), ctx.getText(), findMyBusinessRule(ctx), true, "Effect");
			} else {
				newVertex = new Vertex(ctx.hashCode(), ctx.getText(), findMyBusinessRule(ctx), false, "Effect");
			}
			directedGraph.addVertex(newVertex);

		} else if (ctx.getChild(1).toString().equals("AND")) {
			connectorEffects.add(ctx);
			if (isElseEffect(ctx) == true) {
				newVertex = new Vertex(ctx.hashCode(), "AND", findMyBusinessRule(ctx), true, "Effect-Connector");
			} else {

				newVertex = new Vertex(ctx.hashCode(), "AND", findMyBusinessRule(ctx), false, "Effect-Connector");
			}
			directedGraph.addVertex(newVertex);

		} else if (ctx.getChild(1).toString().equals("OR")) {
			connectorEffects.add(ctx);

		}
		return null;
	}

	// Establish connections between business rules and causes.
	public void connectBusinessRuleWithCauses() {

		for (BusinessRuleContext singleBusinessRule : businessRules) {

			Vertex correspondingVertex = null;

			for (Vertex einVertex : directedGraph.vertexSet()) {
				if (singleBusinessRule.hashCode() == einVertex.key) {
					correspondingVertex = einVertex;
				}
			}

			for (Vertex einVertex : directedGraph.vertexSet()) {

				boolean multipleCausePerBusinessRule = false;

				if (einVertex.content.equals("AND") && einVertex.businessRule.equals(correspondingVertex.businessRule)
						&& einVertex.type == "Cause-Connector") {
					for (Vertex einVerodertesVertex : this.isolatedCauses) {
						if (einVerodertesVertex.businessRule.equals(einVertex.businessRule)
								&& einVerodertesVertex != einVertex) {
							multipleCausePerBusinessRule = true;
						}
					}

					for (Vertex einBeliebigesVertex : directedGraph.vertexSet()) {
						if (einVertex.businessRule.equals(einBeliebigesVertex.businessRule)
								&& einBeliebigesVertex != einVertex && einBeliebigesVertex.type == "Cause-Connector") {

							multipleCausePerBusinessRule = true;
						}
					}

					if (multipleCausePerBusinessRule == true) {
						directedGraph.addEdge(einVertex, correspondingVertex, new Relationship("OR"));
					} else {
						directedGraph.addEdge(einVertex, correspondingVertex, new Relationship(""));
					}
				}
			}

			for (Vertex einVertex : isolatedCauses) {

				boolean multipleCausePerBusinessRule = false;

				if (einVertex.businessRule.equals(correspondingVertex.businessRule)) {

					for (Vertex einVerodertesVertex : this.isolatedCauses) {
						if (einVerodertesVertex.businessRule.equals(einVertex.businessRule)
								&& einVerodertesVertex != einVertex) {
							multipleCausePerBusinessRule = true;
						}
					}

					for (Vertex einBeliebigesVertex : directedGraph.vertexSet()) {
						if (einVertex.businessRule.equals(einBeliebigesVertex.businessRule)
								&& einBeliebigesVertex != einVertex && einBeliebigesVertex.type == "Cause-Connector") {

							multipleCausePerBusinessRule = true;
						}
					}

					if (multipleCausePerBusinessRule == true) {
						directedGraph.addEdge(einVertex, correspondingVertex, new Relationship("OR"));
					} else {
						directedGraph.addEdge(einVertex, correspondingVertex, new Relationship(""));
					}
				}
			}
		}
	}

	// Connect business rules with individual effects as well as nested business
	// rules.
	public void connectBusinessRulesWithEffectsAccordingToNesting() {
		for (BusinessRuleContext singleBusinessRule : businessRules) {
			Vertex correspondingVertexToBusinessRule = null;
			int depthOfBusinessRule = singleBusinessRule.depth();

			for (Vertex einVertex : directedGraph.vertexSet()) {
				if (singleBusinessRule.hashCode() == einVertex.key) {
					correspondingVertexToBusinessRule = einVertex;
				}
			}

			for (EffectContext singleEffect : connectorEffects) {

				if (singleEffect.getChild(1).toString().equals("AND")) {
					for (Vertex einVertex : directedGraph.vertexSet()) {
						if (singleEffect.hashCode() == einVertex.key) {
							for (BusinessRuleContext aBusinessRule : businessRules) {
								if (einVertex.businessRule.equals(aBusinessRule.getText())) {
									int depthOfEffect = aBusinessRule.depth();

									if (depthOfEffect > depthOfBusinessRule) {
										directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex,
												new Relationship(""));
									}

									if (depthOfEffect == depthOfBusinessRule) {
										boolean multipleEffectsPerBusinessRule = false;

										for (Vertex einVerodertesVertex : this.isolatedEffects) {
											if (einVerodertesVertex.businessRule.equals(einVertex.businessRule)
													&& einVerodertesVertex != einVertex
													&& einVerodertesVertex.type == "Effect"
													&& einVerodertesVertex.elseEffect == false) {
												multipleEffectsPerBusinessRule = true;
											}
										}

										for (Vertex einBeliebigesVertex : directedGraph.vertexSet()) {
											if (einVertex.businessRule.equals(einBeliebigesVertex.businessRule)
													&& einBeliebigesVertex != einVertex
													&& einBeliebigesVertex.type == "Effect-Connector"
													&& einBeliebigesVertex.elseEffect == false) {

												multipleEffectsPerBusinessRule = true;
											}
										}

										if (multipleEffectsPerBusinessRule == true) {

											if (einVertex.elseEffect == false) {

												directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex,
														new Relationship("OR"));
											} else {
												directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex,
														new Relationship("NOT"));
											}
										} else {

											if (einVertex.elseEffect == false) {

												directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex,
														new Relationship(""));
											} else {
												directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex,
														new Relationship("NOT"));
											}
										}
									}
								}
							}
						}
					}
				}
			}

			for (Vertex einVertex : isolatedEffects) {
				for (BusinessRuleContext aBusinessRule : businessRules) {
					if (einVertex.businessRule.equals(aBusinessRule.getText())) {
						int depthOfEffect = aBusinessRule.depth();

						if (depthOfEffect > depthOfBusinessRule) {
							directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex, new Relationship(""));
						}

						if (depthOfEffect == depthOfBusinessRule) {
							boolean multipleEffectsPerBusinessRule = false;

							for (Vertex einVerodertesVertex : this.isolatedEffects) {
								if (einVerodertesVertex.businessRule.equals(einVertex.businessRule)
										&& einVerodertesVertex != einVertex && einVerodertesVertex.type == "Effect"
										&& einVerodertesVertex.elseEffect == false) {
									multipleEffectsPerBusinessRule = true;
								}
							}

							for (Vertex einBeliebigesVertex : directedGraph.vertexSet()) {
								if (einVertex.businessRule.equals(einBeliebigesVertex.businessRule)
										&& einBeliebigesVertex != einVertex
										&& einBeliebigesVertex.type == "Effect-Connector"
										&& einBeliebigesVertex.elseEffect == false) {

									multipleEffectsPerBusinessRule = true;
								}
							}

							if (multipleEffectsPerBusinessRule == true) {

								if (einVertex.elseEffect == false) {

									directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex,
											new Relationship("OR"));
								} else {
									directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex,
											new Relationship("NOT"));
								}
							} else {

								if (einVertex.elseEffect == false) {

									directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex,
											new Relationship(""));
								} else {
									directedGraph.addEdge(correspondingVertexToBusinessRule, einVertex,
											new Relationship("NOT"));
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public String visitBusinessRule(BusinessRuleContext ctx) {
		businessRules.add(ctx);
		Vertex newVertex = new Vertex(ctx.hashCode(), "BR" + businessRules.size(), ctx.getText(), false,
				"BusinessRule");
		directedGraph.addVertex(newVertex);
		return super.visitBusinessRule(ctx);
	}

	// Search for every vertex the corresponding business rule and establish a
	// connection in case of nestings.
	public String findMyBusinessRule(ParserRuleContext parserRuleContext) {

		String nameOfBusinessRule = "";

		ParserRuleContext potentialBusinessRule = parserRuleContext.getParent();

		while (potentialBusinessRule != null) {

			if (this.businessRules.contains(potentialBusinessRule)) {
				nameOfBusinessRule = potentialBusinessRule.getText();
				break;
			} else {
				potentialBusinessRule = potentialBusinessRule.getParent();
			}
		}

		return nameOfBusinessRule;

	}

	public boolean isElseEffect(ParserRuleContext parserRuleContext) {

		// Check whether the business rule contains "Else" effects.
		boolean matches = false;

		for (BusinessRuleContext singleBusinessRule : businessRules) {
			if (singleBusinessRule.getChildCount() == 7) {

				String text = singleBusinessRule.getChild(5).getText();

				matches = text.toLowerCase().contains(parserRuleContext.getText().toLowerCase());

				if (matches == true) {
					break;
				}
			}
		}
		return matches;
	}
}
