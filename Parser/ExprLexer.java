// Generated from Expr.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, SPECIALCHAR=6, START=7, END=8, 
		WORD=9, LOWERCASE=10, UPPERCASE=11, UMLAUTS=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "INT", "SPECIALCHAR", "START", "END", 
		"WORD", "LOWERCASE", "UPPERCASE", "UMLAUTS", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'THEN'", "'ELSE'", "'AND'", "'OR'", null, null, "'IF'", "'END-IF'"
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


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17X\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\6\6\60\n\6\r\6\16\6\61\3\7\6\7\65\n\7"+
		"\r\7\16\7\66\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\6\nH\n\n\r\n\16\nI\3\13\3\13\3\f\3\f\3\r\3\r\3\16\6\16S\n\16\r\16\16"+
		"\16T\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\3\2\b\3\2\62;\r\2$%\'\'*+..\60\61>A]]__aa\u201e\u201e\u2020"+
		"\u2020\3\2c|\3\2C\\\n\2aa\u00c6\u00c6\u00d8\u00d8\u00de\u00de\u00e1\u00e1"+
		"\u00e6\u00e6\u00f8\u00f8\u00fe\u00fe\5\2\13\f\17\17\"\"\2_\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\3\35\3\2\2\2\5\"\3\2\2\2\7\'\3\2\2\2\t+\3\2\2\2\13/\3\2"+
		"\2\2\r\64\3\2\2\2\178\3\2\2\2\21;\3\2\2\2\23G\3\2\2\2\25K\3\2\2\2\27M"+
		"\3\2\2\2\31O\3\2\2\2\33R\3\2\2\2\35\36\7V\2\2\36\37\7J\2\2\37 \7G\2\2"+
		" !\7P\2\2!\4\3\2\2\2\"#\7G\2\2#$\7N\2\2$%\7U\2\2%&\7G\2\2&\6\3\2\2\2\'"+
		"(\7C\2\2()\7P\2\2)*\7F\2\2*\b\3\2\2\2+,\7Q\2\2,-\7T\2\2-\n\3\2\2\2.\60"+
		"\t\2\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\f\3\2\2"+
		"\2\63\65\t\3\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2"+
		"\2\67\16\3\2\2\289\7K\2\29:\7H\2\2:\20\3\2\2\2;<\7G\2\2<=\7P\2\2=>\7F"+
		"\2\2>?\7/\2\2?@\7K\2\2@A\7H\2\2A\22\3\2\2\2BH\5\25\13\2CH\5\27\f\2DH\5"+
		"\31\r\2EH\5\r\7\2FH\5\13\6\2GB\3\2\2\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2G"+
		"F\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\24\3\2\2\2KL\t\4\2\2L\26\3\2"+
		"\2\2MN\t\5\2\2N\30\3\2\2\2OP\t\6\2\2P\32\3\2\2\2QS\t\7\2\2RQ\3\2\2\2S"+
		"T\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\b\16\2\2W\34\3\2\2\2\b\2\61"+
		"\66GIT\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}