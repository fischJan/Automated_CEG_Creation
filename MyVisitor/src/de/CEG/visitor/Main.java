package de.CEG.visitor;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;
import org.jgrapht.io.StringComponentNameProvider;
import de.CEG.parser.ExprLexer;
import de.CEG.parser.ExprParser;

@SuppressWarnings("deprecation")
public class Main {

	public static void main(String[] args) throws Exception {
		// Import pseudo code section
		ANTLRInputStream input = new ANTLRFileStream("example.txt");
		ExprLexer lexer = new ExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);

		ParseTree tree = parser.businessRule();
		MyVisitor visitor = new MyVisitor();
		visitor.visit(tree);
		visitor.connectVertices();
		visitor.connectEffects();
		visitor.deleteUnnecessaryConnectors();
		visitor.connectBusinessRuleWithCauses();
		visitor.connectBusinessRulesWithEffectsAccordingToNesting();

		StringComponentNameProvider<Vertex> vertexLabelProvider = new StringComponentNameProvider<Vertex>();
		IntegerComponentNameProvider<Vertex> vertexIDProvider = new IntegerComponentNameProvider<Vertex>();
		StringComponentNameProvider<Relationship> edgeLabelProvider = new StringComponentNameProvider<Relationship>();

		DOTExporter<Vertex, Relationship> exporter = new DOTExporter<Vertex, Relationship>(vertexIDProvider,
				vertexLabelProvider, edgeLabelProvider);
		String targetDirectory = "output/graph/";
		new File(targetDirectory).mkdirs();
		// Export the final CEG as .dot file
		exporter.exportGraph(visitor.directedGraph, new FileWriter(targetDirectory + "cause-effect-graph.dot"));

		// show AST in GUI
		JFrame frame = new JFrame("Antlr AST");
		JPanel panel = new JPanel();
		TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
		viewr.setScale(1.5);
		panel.add(viewr);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}
