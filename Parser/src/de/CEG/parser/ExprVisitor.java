// Generated from Expr.g4 by ANTLR 4.7.1
package de.CEG.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#businessRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBusinessRule(ExprParser.BusinessRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#cause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCause(ExprParser.CauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#effect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEffect(ExprParser.EffectContext ctx);
}