// COMS22303: Lexical analyser

lexer grammar Lex;

//---------------------------------------------------------------------------
// KEYWORDS
//---------------------------------------------------------------------------
BEGIN      : 'begin' ;
END        : 'end' ;
WRITE      : 'write' ;
WRITELN    : 'writeln' ;
ELSE       : 'else' ;
IF         : 'if' ;
READ       : 'read' ;
REPEAT     : 'repeat' ;
UNTIL      : 'until' ;

//---------------------------------------------------------------------------
// OPERATORS
//---------------------------------------------------------------------------
SEMICOLON    : ';'  ;
OPENPAREN    : '('  ;
CLOSEPAREN   : ')'  ;
GREATER      : '>'  ;
LESSER       : '<'  ;
EQUALS       : '='  ;
DEQUALS      : '!=' ;
GEQUALS      : '>=' ;
LEQUALS      : '<=' ;
PLUS         : '+'  ;
MINUS        : '-'  ;
TIMES        : '*'  ;
DIVIDE       : '/'  ;
ASSIGN       : ':=' ;



REALNUM      :  INT '.' INT (EXPONENT)?;

fragment 
EXPONENT     : 'e' ('-')? INT ;

fragment 
INT          : ('0'..'9')+ ;

IDENT        : CHAR ( INT | CHAR )* ;

fragment
CHAR         : ('A'..'Z' | 'a'..'z') ;

STRING       : '\'' ('\'' '\'' | ~'\'')* '\'';

COMMENT      : '{' (~'}')* '}' {skip();} ;

WS           : (' ' | '\t' | '\r' | '\n' )+ {skip();} ;
