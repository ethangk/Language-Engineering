// $ANTLR 3.2 Sep 23, 2009 12:02:23 Syn.g 2013-04-06 00:10:43

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class Syn extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BEGIN", "END", "WRITE", "WRITELN", "ELSE", "IF", "READ", "REPEAT", "UNTIL", "SEMICOLON", "OPENPAREN", "CLOSEPAREN", "GREATER", "LESSER", "EQUALS", "DEQUALS", "GEQUALS", "LEQUALS", "PLUS", "MINUS", "TIMES", "DIVIDE", "ASSIGN", "INT", "EXPONENT", "REALNUM", "CHAR", "IDENT", "STRING", "COMMENT", "WS"
    };
    public static final int CLOSEPAREN=15;
    public static final int GEQUALS=20;
    public static final int EXPONENT=28;
    public static final int ELSE=8;
    public static final int CHAR=30;
    public static final int INT=27;
    public static final int SEMICOLON=13;
    public static final int EQUALS=18;
    public static final int MINUS=23;
    public static final int EOF=-1;
    public static final int WRITE=6;
    public static final int LEQUALS=21;
    public static final int IF=9;
    public static final int DEQUALS=19;
    public static final int WS=34;
    public static final int GREATER=16;
    public static final int LESSER=17;
    public static final int WRITELN=7;
    public static final int READ=10;
    public static final int UNTIL=12;
    public static final int BEGIN=4;
    public static final int REALNUM=29;
    public static final int ASSIGN=26;
    public static final int IDENT=31;
    public static final int PLUS=22;
    public static final int REPEAT=11;
    public static final int OPENPAREN=14;
    public static final int END=5;
    public static final int TIMES=24;
    public static final int COMMENT=33;
    public static final int DIVIDE=25;
    public static final int STRING=32;

    // delegates
    // delegators


        public Syn(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public Syn(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return Syn.tokenNames; }
    public String getGrammarFileName() { return "Syn.g"; }


    	private String cleanString(String s){
    		String tmp;
    		tmp = s.replaceAll("^'", "");
    		s = tmp.replaceAll("'$", "");
    		tmp = s.replaceAll("''", "'");
    		return tmp;
    	}


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // Syn.g:21:1: program : compoundstatement ;
    public final Syn.program_return program() throws RecognitionException {
        Syn.program_return retval = new Syn.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Syn.compoundstatement_return compoundstatement1 = null;



        try {
            // Syn.g:21:9: ( compoundstatement )
            // Syn.g:22:5: compoundstatement
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_compoundstatement_in_program47);
            compoundstatement1=compoundstatement();

            state._fsp--;

            adaptor.addChild(root_0, compoundstatement1.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class compoundstatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compoundstatement"
    // Syn.g:25:1: compoundstatement : BEGIN ( statement SEMICOLON )* END ;
    public final Syn.compoundstatement_return compoundstatement() throws RecognitionException {
        Syn.compoundstatement_return retval = new Syn.compoundstatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token BEGIN2=null;
        Token SEMICOLON4=null;
        Token END5=null;
        Syn.statement_return statement3 = null;


        Object BEGIN2_tree=null;
        Object SEMICOLON4_tree=null;
        Object END5_tree=null;

        try {
            // Syn.g:25:19: ( BEGIN ( statement SEMICOLON )* END )
            // Syn.g:26:5: BEGIN ( statement SEMICOLON )* END
            {
            root_0 = (Object)adaptor.nil();

            BEGIN2=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_compoundstatement62); 
            BEGIN2_tree = (Object)adaptor.create(BEGIN2);
            root_0 = (Object)adaptor.becomeRoot(BEGIN2_tree, root_0);

            // Syn.g:26:12: ( statement SEMICOLON )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=WRITE && LA1_0<=WRITELN)||(LA1_0>=IF && LA1_0<=REPEAT)||LA1_0==IDENT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Syn.g:26:14: statement SEMICOLON
            	    {
            	    pushFollow(FOLLOW_statement_in_compoundstatement67);
            	    statement3=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement3.getTree());
            	    SEMICOLON4=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_compoundstatement69); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            END5=(Token)match(input,END,FOLLOW_END_in_compoundstatement75); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "compoundstatement"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // Syn.g:29:1: statement : ( variable ASSIGN expression | READ OPENPAREN variable CLOSEPAREN | REPEAT compoundstatement UNTIL booltype | IF booltype compoundstatement ( ELSE compoundstatement )? | WRITE OPENPAREN ( expression | string ) CLOSEPAREN | WRITELN );
    public final Syn.statement_return statement() throws RecognitionException {
        Syn.statement_return retval = new Syn.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASSIGN7=null;
        Token READ9=null;
        Token OPENPAREN10=null;
        Token CLOSEPAREN12=null;
        Token REPEAT13=null;
        Token UNTIL15=null;
        Token IF17=null;
        Token ELSE20=null;
        Token WRITE22=null;
        Token OPENPAREN23=null;
        Token CLOSEPAREN26=null;
        Token WRITELN27=null;
        Syn.variable_return variable6 = null;

        Syn.expression_return expression8 = null;

        Syn.variable_return variable11 = null;

        Syn.compoundstatement_return compoundstatement14 = null;

        Syn.booltype_return booltype16 = null;

        Syn.booltype_return booltype18 = null;

        Syn.compoundstatement_return compoundstatement19 = null;

        Syn.compoundstatement_return compoundstatement21 = null;

        Syn.expression_return expression24 = null;

        Syn.string_return string25 = null;


        Object ASSIGN7_tree=null;
        Object READ9_tree=null;
        Object OPENPAREN10_tree=null;
        Object CLOSEPAREN12_tree=null;
        Object REPEAT13_tree=null;
        Object UNTIL15_tree=null;
        Object IF17_tree=null;
        Object ELSE20_tree=null;
        Object WRITE22_tree=null;
        Object OPENPAREN23_tree=null;
        Object CLOSEPAREN26_tree=null;
        Object WRITELN27_tree=null;

        try {
            // Syn.g:29:11: ( variable ASSIGN expression | READ OPENPAREN variable CLOSEPAREN | REPEAT compoundstatement UNTIL booltype | IF booltype compoundstatement ( ELSE compoundstatement )? | WRITE OPENPAREN ( expression | string ) CLOSEPAREN | WRITELN )
            int alt4=6;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt4=1;
                }
                break;
            case READ:
                {
                alt4=2;
                }
                break;
            case REPEAT:
                {
                alt4=3;
                }
                break;
            case IF:
                {
                alt4=4;
                }
                break;
            case WRITE:
                {
                alt4=5;
                }
                break;
            case WRITELN:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // Syn.g:30:5: variable ASSIGN expression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_statement91);
                    variable6=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable6.getTree());
                    ASSIGN7=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_statement93); 
                    ASSIGN7_tree = (Object)adaptor.create(ASSIGN7);
                    root_0 = (Object)adaptor.becomeRoot(ASSIGN7_tree, root_0);

                    pushFollow(FOLLOW_expression_in_statement96);
                    expression8=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression8.getTree());

                    }
                    break;
                case 2 :
                    // Syn.g:31:5: READ OPENPAREN variable CLOSEPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    READ9=(Token)match(input,READ,FOLLOW_READ_in_statement102); 
                    READ9_tree = (Object)adaptor.create(READ9);
                    root_0 = (Object)adaptor.becomeRoot(READ9_tree, root_0);

                    OPENPAREN10=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_statement105); 
                    pushFollow(FOLLOW_variable_in_statement108);
                    variable11=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable11.getTree());
                    CLOSEPAREN12=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_statement110); 

                    }
                    break;
                case 3 :
                    // Syn.g:32:5: REPEAT compoundstatement UNTIL booltype
                    {
                    root_0 = (Object)adaptor.nil();

                    REPEAT13=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_statement117); 
                    REPEAT13_tree = (Object)adaptor.create(REPEAT13);
                    root_0 = (Object)adaptor.becomeRoot(REPEAT13_tree, root_0);

                    pushFollow(FOLLOW_compoundstatement_in_statement120);
                    compoundstatement14=compoundstatement();

                    state._fsp--;

                    adaptor.addChild(root_0, compoundstatement14.getTree());
                    UNTIL15=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_statement122); 
                    pushFollow(FOLLOW_booltype_in_statement125);
                    booltype16=booltype();

                    state._fsp--;

                    adaptor.addChild(root_0, booltype16.getTree());

                    }
                    break;
                case 4 :
                    // Syn.g:33:5: IF booltype compoundstatement ( ELSE compoundstatement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    IF17=(Token)match(input,IF,FOLLOW_IF_in_statement131); 
                    IF17_tree = (Object)adaptor.create(IF17);
                    root_0 = (Object)adaptor.becomeRoot(IF17_tree, root_0);

                    pushFollow(FOLLOW_booltype_in_statement134);
                    booltype18=booltype();

                    state._fsp--;

                    adaptor.addChild(root_0, booltype18.getTree());
                    pushFollow(FOLLOW_compoundstatement_in_statement143);
                    compoundstatement19=compoundstatement();

                    state._fsp--;

                    adaptor.addChild(root_0, compoundstatement19.getTree());
                    // Syn.g:35:5: ( ELSE compoundstatement )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==ELSE) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // Syn.g:35:6: ELSE compoundstatement
                            {
                            ELSE20=(Token)match(input,ELSE,FOLLOW_ELSE_in_statement150); 
                            pushFollow(FOLLOW_compoundstatement_in_statement160);
                            compoundstatement21=compoundstatement();

                            state._fsp--;

                            adaptor.addChild(root_0, compoundstatement21.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // Syn.g:37:5: WRITE OPENPAREN ( expression | string ) CLOSEPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    WRITE22=(Token)match(input,WRITE,FOLLOW_WRITE_in_statement168); 
                    WRITE22_tree = (Object)adaptor.create(WRITE22);
                    root_0 = (Object)adaptor.becomeRoot(WRITE22_tree, root_0);

                    OPENPAREN23=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_statement171); 
                    // Syn.g:37:23: ( expression | string )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==OPENPAREN||(LA3_0>=PLUS && LA3_0<=MINUS)||LA3_0==REALNUM||LA3_0==IDENT) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==STRING) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // Syn.g:37:25: expression
                            {
                            pushFollow(FOLLOW_expression_in_statement176);
                            expression24=expression();

                            state._fsp--;

                            adaptor.addChild(root_0, expression24.getTree());

                            }
                            break;
                        case 2 :
                            // Syn.g:37:38: string
                            {
                            pushFollow(FOLLOW_string_in_statement180);
                            string25=string();

                            state._fsp--;

                            adaptor.addChild(root_0, string25.getTree());

                            }
                            break;

                    }

                    CLOSEPAREN26=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_statement184); 

                    }
                    break;
                case 6 :
                    // Syn.g:38:5: WRITELN
                    {
                    root_0 = (Object)adaptor.nil();

                    WRITELN27=(Token)match(input,WRITELN,FOLLOW_WRITELN_in_statement191); 
                    WRITELN27_tree = (Object)adaptor.create(WRITELN27);
                    root_0 = (Object)adaptor.becomeRoot(WRITELN27_tree, root_0);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class relation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relation"
    // Syn.g:42:1: relation : ( GREATER | LESSER | EQUALS | DEQUALS | GEQUALS | LEQUALS );
    public final Syn.relation_return relation() throws RecognitionException {
        Syn.relation_return retval = new Syn.relation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set28=null;

        Object set28_tree=null;

        try {
            // Syn.g:42:10: ( GREATER | LESSER | EQUALS | DEQUALS | GEQUALS | LEQUALS )
            // Syn.g:
            {
            root_0 = (Object)adaptor.nil();

            set28=(Token)input.LT(1);
            if ( (input.LA(1)>=GREATER && input.LA(1)<=LEQUALS) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set28));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relation"

    public static class booltype_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "booltype"
    // Syn.g:52:1: booltype : expression relation expression ;
    public final Syn.booltype_return booltype() throws RecognitionException {
        Syn.booltype_return retval = new Syn.booltype_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Syn.expression_return expression29 = null;

        Syn.relation_return relation30 = null;

        Syn.expression_return expression31 = null;



        try {
            // Syn.g:52:10: ( expression relation expression )
            // Syn.g:53:3: expression relation expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_booltype251);
            expression29=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression29.getTree());
            pushFollow(FOLLOW_relation_in_booltype253);
            relation30=relation();

            state._fsp--;

            root_0 = (Object)adaptor.becomeRoot(relation30.getTree(), root_0);
            pushFollow(FOLLOW_expression_in_booltype256);
            expression31=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression31.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "booltype"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // Syn.g:56:1: expression : unaryop ( ( PLUS | MINUS ) term )* ;
    public final Syn.expression_return expression() throws RecognitionException {
        Syn.expression_return retval = new Syn.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS33=null;
        Token MINUS34=null;
        Syn.unaryop_return unaryop32 = null;

        Syn.term_return term35 = null;


        Object PLUS33_tree=null;
        Object MINUS34_tree=null;

        try {
            // Syn.g:56:11: ( unaryop ( ( PLUS | MINUS ) term )* )
            // Syn.g:58:3: unaryop ( ( PLUS | MINUS ) term )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unaryop_in_expression270);
            unaryop32=unaryop();

            state._fsp--;

            adaptor.addChild(root_0, unaryop32.getTree());
            // Syn.g:58:11: ( ( PLUS | MINUS ) term )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=PLUS && LA6_0<=MINUS)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Syn.g:58:12: ( PLUS | MINUS ) term
            	    {
            	    // Syn.g:58:12: ( PLUS | MINUS )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==PLUS) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==MINUS) ) {
            	        alt5=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // Syn.g:58:13: PLUS
            	            {
            	            PLUS33=(Token)match(input,PLUS,FOLLOW_PLUS_in_expression274); 
            	            PLUS33_tree = (Object)adaptor.create(PLUS33);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS33_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // Syn.g:58:21: MINUS
            	            {
            	            MINUS34=(Token)match(input,MINUS,FOLLOW_MINUS_in_expression279); 
            	            MINUS34_tree = (Object)adaptor.create(MINUS34);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS34_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_term_in_expression283);
            	    term35=term();

            	    state._fsp--;

            	    adaptor.addChild(root_0, term35.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class pmterm_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pmterm"
    // Syn.g:61:1: pmterm : ( PLUS | MINUS ) term ;
    public final Syn.pmterm_return pmterm() throws RecognitionException {
        Syn.pmterm_return retval = new Syn.pmterm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS36=null;
        Token MINUS37=null;
        Syn.term_return term38 = null;


        Object PLUS36_tree=null;
        Object MINUS37_tree=null;

        try {
            // Syn.g:61:7: ( ( PLUS | MINUS ) term )
            // Syn.g:62:3: ( PLUS | MINUS ) term
            {
            root_0 = (Object)adaptor.nil();

            // Syn.g:62:3: ( PLUS | MINUS )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==PLUS) ) {
                alt7=1;
            }
            else if ( (LA7_0==MINUS) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // Syn.g:62:5: PLUS
                    {
                    PLUS36=(Token)match(input,PLUS,FOLLOW_PLUS_in_pmterm299); 
                    PLUS36_tree = (Object)adaptor.create(PLUS36);
                    root_0 = (Object)adaptor.becomeRoot(PLUS36_tree, root_0);


                    }
                    break;
                case 2 :
                    // Syn.g:62:13: MINUS
                    {
                    MINUS37=(Token)match(input,MINUS,FOLLOW_MINUS_in_pmterm304); 
                    MINUS37_tree = (Object)adaptor.create(MINUS37);
                    root_0 = (Object)adaptor.becomeRoot(MINUS37_tree, root_0);


                    }
                    break;

            }

            pushFollow(FOLLOW_term_in_pmterm309);
            term38=term();

            state._fsp--;

            adaptor.addChild(root_0, term38.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pmterm"

    public static class unaryop_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryop"
    // Syn.g:67:1: unaryop : ( PLUS term | MINUS term -> ^( MINUS REALNUM[\"0.0\"] term ) | term );
    public final Syn.unaryop_return unaryop() throws RecognitionException {
        Syn.unaryop_return retval = new Syn.unaryop_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS39=null;
        Token MINUS41=null;
        Syn.term_return term40 = null;

        Syn.term_return term42 = null;

        Syn.term_return term43 = null;


        Object PLUS39_tree=null;
        Object MINUS41_tree=null;
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
        try {
            // Syn.g:68:5: ( PLUS term | MINUS term -> ^( MINUS REALNUM[\"0.0\"] term ) | term )
            int alt8=3;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt8=1;
                }
                break;
            case MINUS:
                {
                alt8=2;
                }
                break;
            case OPENPAREN:
            case REALNUM:
            case IDENT:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // Syn.g:68:9: PLUS term
                    {
                    root_0 = (Object)adaptor.nil();

                    PLUS39=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryop327); 
                    pushFollow(FOLLOW_term_in_unaryop330);
                    term40=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term40.getTree());

                    }
                    break;
                case 2 :
                    // Syn.g:69:9: MINUS term
                    {
                    MINUS41=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryop340);  
                    stream_MINUS.add(MINUS41);

                    pushFollow(FOLLOW_term_in_unaryop342);
                    term42=term();

                    state._fsp--;

                    stream_term.add(term42.getTree());


                    // AST REWRITE
                    // elements: MINUS, term
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 69:20: -> ^( MINUS REALNUM[\"0.0\"] term )
                    {
                        // Syn.g:69:23: ^( MINUS REALNUM[\"0.0\"] term )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_MINUS.nextNode(), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(REALNUM, "0.0"));
                        adaptor.addChild(root_1, stream_term.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // Syn.g:70:9: term
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_term_in_unaryop363);
                    term43=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term43.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryop"

    public static class term_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "term"
    // Syn.g:73:1: term : factor ( ( TIMES | DIVIDE ) factor )* ;
    public final Syn.term_return term() throws RecognitionException {
        Syn.term_return retval = new Syn.term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token TIMES45=null;
        Token DIVIDE46=null;
        Syn.factor_return factor44 = null;

        Syn.factor_return factor47 = null;


        Object TIMES45_tree=null;
        Object DIVIDE46_tree=null;

        try {
            // Syn.g:73:6: ( factor ( ( TIMES | DIVIDE ) factor )* )
            // Syn.g:74:4: factor ( ( TIMES | DIVIDE ) factor )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_factor_in_term379);
            factor44=factor();

            state._fsp--;

            adaptor.addChild(root_0, factor44.getTree());
            // Syn.g:74:11: ( ( TIMES | DIVIDE ) factor )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=TIMES && LA10_0<=DIVIDE)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Syn.g:74:13: ( TIMES | DIVIDE ) factor
            	    {
            	    // Syn.g:74:13: ( TIMES | DIVIDE )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==TIMES) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==DIVIDE) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // Syn.g:74:15: TIMES
            	            {
            	            TIMES45=(Token)match(input,TIMES,FOLLOW_TIMES_in_term385); 
            	            TIMES45_tree = (Object)adaptor.create(TIMES45);
            	            root_0 = (Object)adaptor.becomeRoot(TIMES45_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // Syn.g:74:24: DIVIDE
            	            {
            	            DIVIDE46=(Token)match(input,DIVIDE,FOLLOW_DIVIDE_in_term390); 
            	            DIVIDE46_tree = (Object)adaptor.create(DIVIDE46);
            	            root_0 = (Object)adaptor.becomeRoot(DIVIDE46_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_factor_in_term395);
            	    factor47=factor();

            	    state._fsp--;

            	    adaptor.addChild(root_0, factor47.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "term"

    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // Syn.g:77:1: constant : REALNUM ;
    public final Syn.constant_return constant() throws RecognitionException {
        Syn.constant_return retval = new Syn.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token REALNUM48=null;

        Object REALNUM48_tree=null;

        try {
            // Syn.g:77:9: ( REALNUM )
            // Syn.g:78:5: REALNUM
            {
            root_0 = (Object)adaptor.nil();

            REALNUM48=(Token)match(input,REALNUM,FOLLOW_REALNUM_in_constant411); 
            REALNUM48_tree = (Object)adaptor.create(REALNUM48);
            adaptor.addChild(root_0, REALNUM48_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constant"

    public static class variable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable"
    // Syn.g:81:1: variable : identifier ;
    public final Syn.variable_return variable() throws RecognitionException {
        Syn.variable_return retval = new Syn.variable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Syn.identifier_return identifier49 = null;



        try {
            // Syn.g:81:9: ( identifier )
            // Syn.g:82:5: identifier
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_variable426);
            identifier49=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier49.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable"

    public static class identifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "identifier"
    // Syn.g:85:1: identifier : IDENT ;
    public final Syn.identifier_return identifier() throws RecognitionException {
        Syn.identifier_return retval = new Syn.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENT50=null;

        Object IDENT50_tree=null;

        try {
            // Syn.g:85:11: ( IDENT )
            // Syn.g:86:5: IDENT
            {
            root_0 = (Object)adaptor.nil();

            IDENT50=(Token)match(input,IDENT,FOLLOW_IDENT_in_identifier440); 
            IDENT50_tree = (Object)adaptor.create(IDENT50);
            adaptor.addChild(root_0, IDENT50_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "identifier"

    public static class factor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor"
    // Syn.g:89:1: factor : ( variable | constant | OPENPAREN expression CLOSEPAREN );
    public final Syn.factor_return factor() throws RecognitionException {
        Syn.factor_return retval = new Syn.factor_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OPENPAREN53=null;
        Token CLOSEPAREN55=null;
        Syn.variable_return variable51 = null;

        Syn.constant_return constant52 = null;

        Syn.expression_return expression54 = null;


        Object OPENPAREN53_tree=null;
        Object CLOSEPAREN55_tree=null;

        try {
            // Syn.g:89:8: ( variable | constant | OPENPAREN expression CLOSEPAREN )
            int alt11=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt11=1;
                }
                break;
            case REALNUM:
                {
                alt11=2;
                }
                break;
            case OPENPAREN:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // Syn.g:90:5: variable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_factor455);
                    variable51=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable51.getTree());

                    }
                    break;
                case 2 :
                    // Syn.g:91:5: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_factor461);
                    constant52=constant();

                    state._fsp--;

                    adaptor.addChild(root_0, constant52.getTree());

                    }
                    break;
                case 3 :
                    // Syn.g:92:5: OPENPAREN expression CLOSEPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    OPENPAREN53=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_factor467); 
                    pushFollow(FOLLOW_expression_in_factor470);
                    expression54=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression54.getTree());
                    CLOSEPAREN55=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_factor472); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "factor"

    protected static class string_scope {
        String tmp;
    }
    protected Stack string_stack = new Stack();

    public static class string_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string"
    // Syn.g:95:1: string : s= STRING -> STRING[$string::tmp] ;
    public final Syn.string_return string() throws RecognitionException {
        string_stack.push(new string_scope());
        Syn.string_return retval = new Syn.string_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;

        Object s_tree=null;
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // Syn.g:97:5: (s= STRING -> STRING[$string::tmp] )
            // Syn.g:98:5: s= STRING
            {
            s=(Token)match(input,STRING,FOLLOW_STRING_in_string501);  
            stream_STRING.add(s);

             ((string_scope)string_stack.peek()).tmp = cleanString((s!=null?s.getText():null)); 


            // AST REWRITE
            // elements: STRING
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 98:54: -> STRING[$string::tmp]
            {
                adaptor.addChild(root_0, (Object)adaptor.create(STRING, ((string_scope)string_stack.peek()).tmp));

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            string_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "string"

    // Delegated rules


 

    public static final BitSet FOLLOW_compoundstatement_in_program47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEGIN_in_compoundstatement62 = new BitSet(new long[]{0x0000000080000EE0L});
    public static final BitSet FOLLOW_statement_in_compoundstatement67 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SEMICOLON_in_compoundstatement69 = new BitSet(new long[]{0x0000000080000EE0L});
    public static final BitSet FOLLOW_END_in_compoundstatement75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_statement91 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ASSIGN_in_statement93 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_expression_in_statement96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_statement102 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_OPENPAREN_in_statement105 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_variable_in_statement108 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLOSEPAREN_in_statement110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPEAT_in_statement117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_compoundstatement_in_statement120 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_UNTIL_in_statement122 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_booltype_in_statement125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement131 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_booltype_in_statement134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_compoundstatement_in_statement143 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ELSE_in_statement150 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_compoundstatement_in_statement160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_statement168 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_OPENPAREN_in_statement171 = new BitSet(new long[]{0x00000001A0C04000L});
    public static final BitSet FOLLOW_expression_in_statement176 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_string_in_statement180 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLOSEPAREN_in_statement184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITELN_in_statement191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relation0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_booltype251 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_relation_in_booltype253 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_expression_in_booltype256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryop_in_expression270 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_PLUS_in_expression274 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_MINUS_in_expression279 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_term_in_expression283 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_PLUS_in_pmterm299 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_MINUS_in_pmterm304 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_term_in_pmterm309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryop327 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_term_in_unaryop330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryop340 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_term_in_unaryop342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_unaryop363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_term379 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_TIMES_in_term385 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_DIVIDE_in_term390 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_factor_in_term395 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_REALNUM_in_constant411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variable426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_identifier440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_factor455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_factor461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPENPAREN_in_factor467 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_expression_in_factor470 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLOSEPAREN_in_factor472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string501 = new BitSet(new long[]{0x0000000000000002L});

}