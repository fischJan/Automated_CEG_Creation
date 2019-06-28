// Generated from Expr.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#businessRule}.
	 * @param ctx the parse tree
	 */
	void enterBusinessRule(ExprParser.BusinessRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#businessRule}.
	 * @param ctx the parse tree
	 */
	void exitBusinessRule(ExprParser.BusinessRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#cause}.
	 * @param ctx the parse tree
	 */
	void enterCause(ExprParser.CauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#cause}.
	 * @param ctx the parse tree
	 */
	void exitCause(ExprParser.CauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#effect}.
	 * @param ctx the parse tree
	 */
	void enterEffect(ExprParser.EffectContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#effect}.
	 * @param ctx the parse tree
	 */
	void exitEffect(ExprParser.EffectContext ctx);
}