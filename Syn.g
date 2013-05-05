// COMS22303: Syntax analyser

parser grammar Syn;

options {
  tokenVocab = Lex;
  output = AST;
}

@members
{
	private String cleanString(String s){
		String tmp;
		tmp = s.replaceAll("^'", "");
		s = tmp.replaceAll("'$", "");
		tmp = s.replaceAll("''", "'");
		return tmp;
	}
}

program :
    compoundstatement
  ;

compoundstatement :
    BEGIN^ ( statement SEMICOLON! )* END!
  ;

statement :
    variable ASSIGN^ expression
  | READ^ OPENPAREN! variable CLOSEPAREN!
  | REPEAT^ compoundstatement UNTIL! booltype
  | WHILE^ booltype compoundstatement
  | IF^ booltype
       compoundstatement
    (ELSE!
       compoundstatement)?
  | WRITE^ OPENPAREN! ( expression | string ) CLOSEPAREN!
  | WRITELN^
  ;


relation :
    GREATER
  | LESSER
  | EQUALS
  | DEQUALS
  | GEQUALS
  | LEQUALS
 ;


booltype :
  expression relation^ expression
 ;

expression:
  //(PLUS! | MINUS^)? term ( (PLUS | MINUS)^ term )*
  unaryop ((PLUS^ | MINUS^) term)*
  ;

pmterm:
  ( PLUS^ | MINUS^ ) term
 ;



unaryop
    :   PLUS! term
    |   MINUS term -> ^(MINUS REALNUM["0.0"] term)
    |   term
    ;

term :
   factor ( ( TIMES^ | DIVIDE^ ) factor )*
 ;

constant:
    REALNUM 
  ;

variable:
    identifier
  ;

identifier:
    IDENT
  ;

factor :
    variable
  | constant
  | OPENPAREN! expression CLOSEPAREN!
 ;

string
    scope { String tmp;}
    :
    s=STRING { $string::tmp = cleanString($s.text); }-> STRING[$string::tmp]
  ;
