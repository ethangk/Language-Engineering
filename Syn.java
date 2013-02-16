// $ANTLR 3.2 Sep 23, 2009 12:02:23 Syn.g 2013-02-16 13:13:33

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
    // Syn.g:29:1: statement : ( variable ASSIGN expression | READ OPENPAREN variable CLOSEPAREN | REPEAT compoundstatement untiltype | IF booltype compoundstatement ( ELSE compoundstatement )? | WRITE OPENPAREN ( expression | string ) CLOSEPAREN | WRITELN );
    public final Syn.statement_return statement() throws RecognitionException {
        Syn.statement_return retval = new Syn.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ASSIGN7=null;
        Token READ9=null;
        Token OPENPAREN10=null;
        Token CLOSEPAREN12=null;
        Token REPEAT13=null;
        Token IF16=null;
        Token ELSE19=null;
        Token WRITE21=null;
        Token OPENPAREN22=null;
        Token CLOSEPAREN25=null;
        Token WRITELN26=null;
        Syn.variable_return variable6 = null;

        Syn.expression_return expression8 = null;

        Syn.variable_return variable11 = null;

        Syn.compoundstatement_return compoundstatement14 = null;

        Syn.untiltype_return untiltype15 = null;

        Syn.booltype_return booltype17 = null;

        Syn.compoundstatement_return compoundstatement18 = null;

        Syn.compoundstatement_return compoundstatement20 = null;

        Syn.expression_return expression23 = null;

        Syn.string_return string24 = null;


        Object ASSIGN7_tree=null;
        Object READ9_tree=null;
        Object OPENPAREN10_tree=null;
        Object CLOSEPAREN12_tree=null;
        Object REPEAT13_tree=null;
        Object IF16_tree=null;
        Object ELSE19_tree=null;
        Object WRITE21_tree=null;
        Object OPENPAREN22_tree=null;
        Object CLOSEPAREN25_tree=null;
        Object WRITELN26_tree=null;

        try {
            // Syn.g:29:11: ( variable ASSIGN expression | READ OPENPAREN variable CLOSEPAREN | REPEAT compoundstatement untiltype | IF booltype compoundstatement ( ELSE compoundstatement )? | WRITE OPENPAREN ( expression | string ) CLOSEPAREN | WRITELN )
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
                    // Syn.g:32:5: REPEAT compoundstatement untiltype
                    {
                    root_0 = (Object)adaptor.nil();

                    REPEAT13=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_statement117); 
                    REPEAT13_tree = (Object)adaptor.create(REPEAT13);
                    root_0 = (Object)adaptor.becomeRoot(REPEAT13_tree, root_0);

                    pushFollow(FOLLOW_compoundstatement_in_statement120);
                    compoundstatement14=compoundstatement();

                    state._fsp--;

                    adaptor.addChild(root_0, compoundstatement14.getTree());
                    pushFollow(FOLLOW_untiltype_in_statement122);
                    untiltype15=untiltype();

                    state._fsp--;

                    adaptor.addChild(root_0, untiltype15.getTree());

                    }
                    break;
                case 4 :
                    // Syn.g:33:5: IF booltype compoundstatement ( ELSE compoundstatement )?
                    {
                    root_0 = (Object)adaptor.nil();

                    IF16=(Token)match(input,IF,FOLLOW_IF_in_statement128); 
                    IF16_tree = (Object)adaptor.create(IF16);
                    root_0 = (Object)adaptor.becomeRoot(IF16_tree, root_0);

                    pushFollow(FOLLOW_booltype_in_statement131);
                    booltype17=booltype();

                    state._fsp--;

                    adaptor.addChild(root_0, booltype17.getTree());
                    pushFollow(FOLLOW_compoundstatement_in_statement140);
                    compoundstatement18=compoundstatement();

                    state._fsp--;

                    adaptor.addChild(root_0, compoundstatement18.getTree());
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
                            ELSE19=(Token)match(input,ELSE,FOLLOW_ELSE_in_statement147); 
                            pushFollow(FOLLOW_compoundstatement_in_statement157);
                            compoundstatement20=compoundstatement();

                            state._fsp--;

                            adaptor.addChild(root_0, compoundstatement20.getTree());

                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // Syn.g:37:5: WRITE OPENPAREN ( expression | string ) CLOSEPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    WRITE21=(Token)match(input,WRITE,FOLLOW_WRITE_in_statement165); 
                    WRITE21_tree = (Object)adaptor.create(WRITE21);
                    root_0 = (Object)adaptor.becomeRoot(WRITE21_tree, root_0);

                    OPENPAREN22=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_statement168); 
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
                            pushFollow(FOLLOW_expression_in_statement173);
                            expression23=expression();

                            state._fsp--;

                            adaptor.addChild(root_0, expression23.getTree());

                            }
                            break;
                        case 2 :
                            // Syn.g:37:38: string
                            {
                            pushFollow(FOLLOW_string_in_statement177);
                            string24=string();

                            state._fsp--;

                            adaptor.addChild(root_0, string24.getTree());

                            }
                            break;

                    }

                    CLOSEPAREN25=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_statement181); 

                    }
                    break;
                case 6 :
                    // Syn.g:38:5: WRITELN
                    {
                    root_0 = (Object)adaptor.nil();

                    WRITELN26=(Token)match(input,WRITELN,FOLLOW_WRITELN_in_statement188); 
                    WRITELN26_tree = (Object)adaptor.create(WRITELN26);
                    root_0 = (Object)adaptor.becomeRoot(WRITELN26_tree, root_0);


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

        Token set27=null;

        Object set27_tree=null;

        try {
            // Syn.g:42:10: ( GREATER | LESSER | EQUALS | DEQUALS | GEQUALS | LEQUALS )
            // Syn.g:
            {
            root_0 = (Object)adaptor.nil();

            set27=(Token)input.LT(1);
            if ( (input.LA(1)>=GREATER && input.LA(1)<=LEQUALS) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set27));
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

    public static class untiltype_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "untiltype"
    // Syn.g:51:1: untiltype : UNTIL booltype ;
    public final Syn.untiltype_return untiltype() throws RecognitionException {
        Syn.untiltype_return retval = new Syn.untiltype_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token UNTIL28=null;
        Syn.booltype_return booltype29 = null;


        Object UNTIL28_tree=null;

        try {
            // Syn.g:51:11: ( UNTIL booltype )
            // Syn.g:52:3: UNTIL booltype
            {
            root_0 = (Object)adaptor.nil();

            UNTIL28=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_untiltype247); 
            UNTIL28_tree = (Object)adaptor.create(UNTIL28);
            root_0 = (Object)adaptor.becomeRoot(UNTIL28_tree, root_0);

            pushFollow(FOLLOW_booltype_in_untiltype250);
            booltype29=booltype();

            state._fsp--;

            adaptor.addChild(root_0, booltype29.getTree());

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
    // $ANTLR end "untiltype"

    public static class booltype_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "booltype"
    // Syn.g:55:1: booltype : expression relation expression ;
    public final Syn.booltype_return booltype() throws RecognitionException {
        Syn.booltype_return retval = new Syn.booltype_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Syn.expression_return expression30 = null;

        Syn.relation_return relation31 = null;

        Syn.expression_return expression32 = null;



        try {
            // Syn.g:55:10: ( expression relation expression )
            // Syn.g:56:3: expression relation expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_booltype262);
            expression30=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression30.getTree());
            pushFollow(FOLLOW_relation_in_booltype264);
            relation31=relation();

            state._fsp--;

            root_0 = (Object)adaptor.becomeRoot(relation31.getTree(), root_0);
            pushFollow(FOLLOW_expression_in_booltype267);
            expression32=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression32.getTree());

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
    // Syn.g:59:1: expression : unaryop ( pmterm )* ;
    public final Syn.expression_return expression() throws RecognitionException {
        Syn.expression_return retval = new Syn.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Syn.unaryop_return unaryop33 = null;

        Syn.pmterm_return pmterm34 = null;



        try {
            // Syn.g:59:11: ( unaryop ( pmterm )* )
            // Syn.g:60:3: unaryop ( pmterm )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unaryop_in_expression278);
            unaryop33=unaryop();

            state._fsp--;

            adaptor.addChild(root_0, unaryop33.getTree());
            // Syn.g:60:11: ( pmterm )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==OPENPAREN||LA5_0==REALNUM||LA5_0==IDENT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Syn.g:60:13: pmterm
            	    {
            	    pushFollow(FOLLOW_pmterm_in_expression282);
            	    pmterm34=pmterm();

            	    state._fsp--;

            	    adaptor.addChild(root_0, pmterm34.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // Syn.g:63:1: pmterm : term ;
    public final Syn.pmterm_return pmterm() throws RecognitionException {
        Syn.pmterm_return retval = new Syn.pmterm_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Syn.term_return term35 = null;



        try {
            // Syn.g:63:7: ( term )
            // Syn.g:64:3: term
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_term_in_pmterm298);
            term35=term();

            state._fsp--;

            adaptor.addChild(root_0, term35.getTree());

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
    // Syn.g:67:1: unaryop : ( ( PLUS | MINUS )? ) term ;
    public final Syn.unaryop_return unaryop() throws RecognitionException {
        Syn.unaryop_return retval = new Syn.unaryop_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set36=null;
        Syn.term_return term37 = null;


        Object set36_tree=null;

        try {
            // Syn.g:67:9: ( ( ( PLUS | MINUS )? ) term )
            // Syn.g:68:7: ( ( PLUS | MINUS )? ) term
            {
            root_0 = (Object)adaptor.nil();

            // Syn.g:68:7: ( ( PLUS | MINUS )? )
            // Syn.g:68:8: ( PLUS | MINUS )?
            {
            // Syn.g:68:8: ( PLUS | MINUS )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=PLUS && LA6_0<=MINUS)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Syn.g:
                    {
                    set36=(Token)input.LT(1);
                    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
                        input.consume();
                        adaptor.addChild(root_0, (Object)adaptor.create(set36));
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            }

            pushFollow(FOLLOW_term_in_unaryop328);
            term37=term();

            state._fsp--;

            adaptor.addChild(root_0, term37.getTree());

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
    // Syn.g:71:1: term : factor ( ( TIMES | DIVIDE ) factor )* ;
    public final Syn.term_return term() throws RecognitionException {
        Syn.term_return retval = new Syn.term_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set39=null;
        Syn.factor_return factor38 = null;

        Syn.factor_return factor40 = null;


        Object set39_tree=null;

        try {
            // Syn.g:71:6: ( factor ( ( TIMES | DIVIDE ) factor )* )
            // Syn.g:72:4: factor ( ( TIMES | DIVIDE ) factor )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_factor_in_term342);
            factor38=factor();

            state._fsp--;

            adaptor.addChild(root_0, factor38.getTree());
            // Syn.g:72:11: ( ( TIMES | DIVIDE ) factor )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=TIMES && LA7_0<=DIVIDE)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Syn.g:72:13: ( TIMES | DIVIDE ) factor
            	    {
            	    set39=(Token)input.LT(1);
            	    set39=(Token)input.LT(1);
            	    if ( (input.LA(1)>=TIMES && input.LA(1)<=DIVIDE) ) {
            	        input.consume();
            	        root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set39), root_0);
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_factor_in_term357);
            	    factor40=factor();

            	    state._fsp--;

            	    adaptor.addChild(root_0, factor40.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // Syn.g:75:1: constant : REALNUM ;
    public final Syn.constant_return constant() throws RecognitionException {
        Syn.constant_return retval = new Syn.constant_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token REALNUM41=null;

        Object REALNUM41_tree=null;

        try {
            // Syn.g:75:9: ( REALNUM )
            // Syn.g:76:5: REALNUM
            {
            root_0 = (Object)adaptor.nil();

            REALNUM41=(Token)match(input,REALNUM,FOLLOW_REALNUM_in_constant373); 
            REALNUM41_tree = (Object)adaptor.create(REALNUM41);
            adaptor.addChild(root_0, REALNUM41_tree);


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
    // Syn.g:79:1: variable : identifier ;
    public final Syn.variable_return variable() throws RecognitionException {
        Syn.variable_return retval = new Syn.variable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Syn.identifier_return identifier42 = null;



        try {
            // Syn.g:79:9: ( identifier )
            // Syn.g:80:5: identifier
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_identifier_in_variable388);
            identifier42=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier42.getTree());

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
    // Syn.g:83:1: identifier : IDENT ;
    public final Syn.identifier_return identifier() throws RecognitionException {
        Syn.identifier_return retval = new Syn.identifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDENT43=null;

        Object IDENT43_tree=null;

        try {
            // Syn.g:83:11: ( IDENT )
            // Syn.g:84:5: IDENT
            {
            root_0 = (Object)adaptor.nil();

            IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_identifier402); 
            IDENT43_tree = (Object)adaptor.create(IDENT43);
            adaptor.addChild(root_0, IDENT43_tree);


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
    // Syn.g:87:1: factor : ( variable | constant | OPENPAREN expression CLOSEPAREN );
    public final Syn.factor_return factor() throws RecognitionException {
        Syn.factor_return retval = new Syn.factor_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token OPENPAREN46=null;
        Token CLOSEPAREN48=null;
        Syn.variable_return variable44 = null;

        Syn.constant_return constant45 = null;

        Syn.expression_return expression47 = null;


        Object OPENPAREN46_tree=null;
        Object CLOSEPAREN48_tree=null;

        try {
            // Syn.g:87:8: ( variable | constant | OPENPAREN expression CLOSEPAREN )
            int alt8=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt8=1;
                }
                break;
            case REALNUM:
                {
                alt8=2;
                }
                break;
            case OPENPAREN:
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
                    // Syn.g:88:5: variable
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_factor417);
                    variable44=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable44.getTree());

                    }
                    break;
                case 2 :
                    // Syn.g:89:5: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_factor423);
                    constant45=constant();

                    state._fsp--;

                    adaptor.addChild(root_0, constant45.getTree());

                    }
                    break;
                case 3 :
                    // Syn.g:90:5: OPENPAREN expression CLOSEPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    OPENPAREN46=(Token)match(input,OPENPAREN,FOLLOW_OPENPAREN_in_factor429); 
                    pushFollow(FOLLOW_expression_in_factor432);
                    expression47=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression47.getTree());
                    CLOSEPAREN48=(Token)match(input,CLOSEPAREN,FOLLOW_CLOSEPAREN_in_factor434); 

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
    // Syn.g:93:1: string : s= STRING -> STRING[$string::tmp] ;
    public final Syn.string_return string() throws RecognitionException {
        string_stack.push(new string_scope());
        Syn.string_return retval = new Syn.string_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token s=null;

        Object s_tree=null;
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // Syn.g:95:5: (s= STRING -> STRING[$string::tmp] )
            // Syn.g:96:5: s= STRING
            {
            s=(Token)match(input,STRING,FOLLOW_STRING_in_string463);  
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
            // 96:54: -> STRING[$string::tmp]
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
    public static final BitSet FOLLOW_untiltype_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_statement128 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_booltype_in_statement131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_compoundstatement_in_statement140 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ELSE_in_statement147 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_compoundstatement_in_statement157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_statement165 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_OPENPAREN_in_statement168 = new BitSet(new long[]{0x00000001A0C04000L});
    public static final BitSet FOLLOW_expression_in_statement173 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_string_in_statement177 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLOSEPAREN_in_statement181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITELN_in_statement188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relation0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNTIL_in_untiltype247 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_booltype_in_untiltype250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_booltype262 = new BitSet(new long[]{0x00000000003F0000L});
    public static final BitSet FOLLOW_relation_in_booltype264 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_expression_in_booltype267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryop_in_expression278 = new BitSet(new long[]{0x00000000A0C04002L});
    public static final BitSet FOLLOW_pmterm_in_expression282 = new BitSet(new long[]{0x00000000A0C04002L});
    public static final BitSet FOLLOW_term_in_pmterm298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unaryop315 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_term_in_unaryop328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_term342 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_set_in_term346 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_factor_in_term357 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_REALNUM_in_constant373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_variable388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_identifier402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_factor417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_factor423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPENPAREN_in_factor429 = new BitSet(new long[]{0x00000000A0C04000L});
    public static final BitSet FOLLOW_expression_in_factor432 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLOSEPAREN_in_factor434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_string463 = new BitSet(new long[]{0x0000000000000002L});

}