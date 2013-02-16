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
  | REPEAT^ compoundstatement untiltype
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

untiltype :
  UNTIL^ booltype
 ;

booltype :
  expression relation^ expression
 ;

expression:
  unaryop ( pmterm  )*
  ;

pmterm:
  ( PLUS | MINUS ) term
 ;

unaryop :
      (( PLUS | MINUS )?)^ term
  ;

term :
   factor ( ( TIMES | DIVIDE )^ factor )*
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
