grammar Expr;		
businessRule: START cause 'THEN' (effect | businessRule) ('ELSE' effect)? END ;

cause: (WORD|INT|SPECIALCHAR)+
      | cause ('AND'|'OR') cause
      ;

effect: (WORD|INT|SPECIALCHAR)+
      | effect ('AND'|'OR') effect
      ;

INT: [0-9]+ ;
SPECIALCHAR: ('=' | '/' | '%' | '#' | '<' | '>' | '[' | ']' | '_' | '.' | '?' | ',' | '"' | '„' | '“' | '(' | ')')+ ;
START: 'IF' ;
END: 'END_IF' ;
WORD: (LOWERCASE | UPPERCASE | UMLAUTS | SPECIALCHAR | INT)+ ;
LOWERCASE: [a-z] ;
UPPERCASE: [A-Z] ;
UMLAUTS: [_\u00DC\u00FC\u00D6\u00F6\u00C4\u00E4\u00DF] ;
WS: [ \t\n\r] + -> skip;
