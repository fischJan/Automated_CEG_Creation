// Generated from Expr.g4 by ANTLR 4.7.1
package de.CEG.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, SPECIALCHAR=6, START=7, END=8, 
		WORD=9, LOWERCASE=10, UPPERCASE=11, UMLAUTS=12, WS=13;
	public static final int
		RULE_businessRule = 0, RULE_cause = 1, RULE_effect = 2;
	public static final String[] ruleNames = {
		"businessRule", "cause", "effect"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'THEN'", "'ELSE'", "'AND'", "'OR'", null, null, "'IF'", "'END_IF'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "INT", "SPECIALCHAR", "START", "END", "WORD", 
		"LOWERCASE", "UPPERCASE", "UMLAUTS", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BusinessRuleContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(ExprParser.START, 0); }
		public CauseContext cause() {
			return getRuleContext(CauseContext.class,0);
		}
		public TerminalNode END() { return getToken(ExprParser.END, 0); }
		public List<EffectContext> effect() {
			return getRuleContexts(EffectContext.class);
		}
		public EffectContext effect(int i) {
			return getRuleContext(EffectContext.class,i);
		}
		public BusinessRuleContext businessRule() {
			return getRuleContext(BusinessRuleContext.class,0);
		}
		public BusinessRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_businessRule; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitBusinessRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BusinessRuleContext businessRule() throws RecognitionException {
		BusinessRuleContext _localctx = new BusinessRuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_businessRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			match(START);
			setState(7);
			cause(0);
			setState(8);
			match(T__0);
			setState(11);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case SPECIALCHAR:
			case WORD:
				{
				setState(9);
				effect(0);
				}
				break;
			case START:
				{
				setState(10);
				businessRule();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(13);
				match(T__1);
				setState(14);
				effect(0);
				}
			}

			setState(17);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CauseContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(ExprParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(ExprParser.WORD, i);
		}
		public List<TerminalNode> INT() { return getTokens(ExprParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ExprParser.INT, i);
		}
		public List<TerminalNode> SPECIALCHAR() { return getTokens(ExprParser.SPECIALCHAR); }
		public TerminalNode SPECIALCHAR(int i) {
			return getToken(ExprParser.SPECIALCHAR, i);
		}
		public List<CauseContext> cause() {
			return getRuleContexts(CauseContext.class);
		}
		public CauseContext cause(int i) {
			return getRuleContext(CauseContext.class,i);
		}
		public CauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitCause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CauseContext cause() throws RecognitionException {
		return cause(0);
	}

	private CauseContext cause(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CauseContext _localctx = new CauseContext(_ctx, _parentState);
		CauseContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_cause, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(21); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(20);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << SPECIALCHAR) | (1L << WORD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(23); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
			_ctx.stop = _input.LT(-1);
			setState(30);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CauseContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_cause);
					setState(25);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(26);
					_la = _input.LA(1);
					if ( !(_la==T__2 || _la==T__3) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(27);
					cause(2);
					}
					} 
				}
				setState(32);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EffectContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(ExprParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(ExprParser.WORD, i);
		}
		public List<TerminalNode> INT() { return getTokens(ExprParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(ExprParser.INT, i);
		}
		public List<TerminalNode> SPECIALCHAR() { return getTokens(ExprParser.SPECIALCHAR); }
		public TerminalNode SPECIALCHAR(int i) {
			return getToken(ExprParser.SPECIALCHAR, i);
		}
		public List<EffectContext> effect() {
			return getRuleContexts(EffectContext.class);
		}
		public EffectContext effect(int i) {
			return getRuleContext(EffectContext.class,i);
		}
		public EffectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitEffect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EffectContext effect() throws RecognitionException {
		return effect(0);
	}

	private EffectContext effect(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EffectContext _localctx = new EffectContext(_ctx, _parentState);
		EffectContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_effect, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(35); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(34);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << SPECIALCHAR) | (1L << WORD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(37); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
			_ctx.stop = _input.LT(-1);
			setState(44);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EffectContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_effect);
					setState(39);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(40);
					_la = _input.LA(1);
					if ( !(_la==T__2 || _la==T__3) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(41);
					effect(2);
					}
					} 
				}
				setState(46);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return cause_sempred((CauseContext)_localctx, predIndex);
		case 2:
			return effect_sempred((EffectContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean cause_sempred(CauseContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean effect_sempred(EffectContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\17\62\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\5\2\16\n\2\3\2\3\2\5\2\22\n\2\3\2\3\2"+
		"\3\3\3\3\6\3\30\n\3\r\3\16\3\31\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3"+
		"\3\4\3\4\6\4&\n\4\r\4\16\4\'\3\4\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\4"+
		"\2\4\4\6\5\2\4\6\2\4\4\2\7\b\13\13\3\2\5\6\2\64\2\b\3\2\2\2\4\25\3\2\2"+
		"\2\6#\3\2\2\2\b\t\7\t\2\2\t\n\5\4\3\2\n\r\7\3\2\2\13\16\5\6\4\2\f\16\5"+
		"\2\2\2\r\13\3\2\2\2\r\f\3\2\2\2\16\21\3\2\2\2\17\20\7\4\2\2\20\22\5\6"+
		"\4\2\21\17\3\2\2\2\21\22\3\2\2\2\22\23\3\2\2\2\23\24\7\n\2\2\24\3\3\2"+
		"\2\2\25\27\b\3\1\2\26\30\t\2\2\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2"+
		"\2\2\31\32\3\2\2\2\32 \3\2\2\2\33\34\f\3\2\2\34\35\t\3\2\2\35\37\5\4\3"+
		"\4\36\33\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\5\3\2\2\2\" \3\2"+
		"\2\2#%\b\4\1\2$&\t\2\2\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(."+
		"\3\2\2\2)*\f\3\2\2*+\t\3\2\2+-\5\6\4\4,)\3\2\2\2-\60\3\2\2\2.,\3\2\2\2"+
		"./\3\2\2\2/\7\3\2\2\2\60.\3\2\2\2\b\r\21\31 \'.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}