// $ANTLR 3.2 Sep 23, 2009 12:02:23 Lex.g 2013-04-06 00:10:42

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class Lex extends Lexer {
    public static final int CLOSEPAREN=15;
    public static final int EXPONENT=28;
    public static final int GEQUALS=20;
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
    public static final int REALNUM=29;
    public static final int BEGIN=4;
    public static final int ASSIGN=26;
    public static final int IDENT=31;
    public static final int PLUS=22;
    public static final int REPEAT=11;
    public static final int OPENPAREN=14;
    public static final int COMMENT=33;
    public static final int TIMES=24;
    public static final int END=5;
    public static final int DIVIDE=25;
    public static final int STRING=32;

    // delegates
    // delegators

    public Lex() {;} 
    public Lex(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Lex(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Lex.g"; }

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:8:12: ( 'begin' )
            // Lex.g:8:14: 'begin'
            {
            match("begin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:9:12: ( 'end' )
            // Lex.g:9:14: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "WRITE"
    public final void mWRITE() throws RecognitionException {
        try {
            int _type = WRITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:10:12: ( 'write' )
            // Lex.g:10:14: 'write'
            {
            match("write"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WRITE"

    // $ANTLR start "WRITELN"
    public final void mWRITELN() throws RecognitionException {
        try {
            int _type = WRITELN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:11:12: ( 'writeln' )
            // Lex.g:11:14: 'writeln'
            {
            match("writeln"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WRITELN"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:12:12: ( 'else' )
            // Lex.g:12:14: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:13:12: ( 'if' )
            // Lex.g:13:14: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "READ"
    public final void mREAD() throws RecognitionException {
        try {
            int _type = READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:14:12: ( 'read' )
            // Lex.g:14:14: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "READ"

    // $ANTLR start "REPEAT"
    public final void mREPEAT() throws RecognitionException {
        try {
            int _type = REPEAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:15:12: ( 'repeat' )
            // Lex.g:15:14: 'repeat'
            {
            match("repeat"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REPEAT"

    // $ANTLR start "UNTIL"
    public final void mUNTIL() throws RecognitionException {
        try {
            int _type = UNTIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:16:12: ( 'until' )
            // Lex.g:16:14: 'until'
            {
            match("until"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNTIL"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:21:14: ( ';' )
            // Lex.g:21:16: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "OPENPAREN"
    public final void mOPENPAREN() throws RecognitionException {
        try {
            int _type = OPENPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:22:14: ( '(' )
            // Lex.g:22:16: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPENPAREN"

    // $ANTLR start "CLOSEPAREN"
    public final void mCLOSEPAREN() throws RecognitionException {
        try {
            int _type = CLOSEPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:23:14: ( ')' )
            // Lex.g:23:16: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSEPAREN"

    // $ANTLR start "GREATER"
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:24:14: ( '>' )
            // Lex.g:24:16: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER"

    // $ANTLR start "LESSER"
    public final void mLESSER() throws RecognitionException {
        try {
            int _type = LESSER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:25:14: ( '<' )
            // Lex.g:25:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESSER"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:26:14: ( '=' )
            // Lex.g:26:16: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "DEQUALS"
    public final void mDEQUALS() throws RecognitionException {
        try {
            int _type = DEQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:27:14: ( '!=' )
            // Lex.g:27:16: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEQUALS"

    // $ANTLR start "GEQUALS"
    public final void mGEQUALS() throws RecognitionException {
        try {
            int _type = GEQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:28:14: ( '>=' )
            // Lex.g:28:16: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GEQUALS"

    // $ANTLR start "LEQUALS"
    public final void mLEQUALS() throws RecognitionException {
        try {
            int _type = LEQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:29:14: ( '<=' )
            // Lex.g:29:16: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEQUALS"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:30:14: ( '+' )
            // Lex.g:30:16: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:31:14: ( '-' )
            // Lex.g:31:16: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "TIMES"
    public final void mTIMES() throws RecognitionException {
        try {
            int _type = TIMES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:32:14: ( '*' )
            // Lex.g:32:16: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TIMES"

    // $ANTLR start "DIVIDE"
    public final void mDIVIDE() throws RecognitionException {
        try {
            int _type = DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:33:14: ( '/' )
            // Lex.g:33:16: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIVIDE"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:34:14: ( ':=' )
            // Lex.g:34:16: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "REALNUM"
    public final void mREALNUM() throws RecognitionException {
        try {
            int _type = REALNUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:38:14: ( INT '.' INT ( EXPONENT )? )
            // Lex.g:38:17: INT '.' INT ( EXPONENT )?
            {
            mINT(); 
            match('.'); 
            mINT(); 
            // Lex.g:38:29: ( EXPONENT )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='e') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // Lex.g:38:30: EXPONENT
                    {
                    mEXPONENT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REALNUM"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // Lex.g:41:14: ( 'e' ( '-' )? INT )
            // Lex.g:41:16: 'e' ( '-' )? INT
            {
            match('e'); 
            // Lex.g:41:20: ( '-' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='-') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // Lex.g:41:21: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            mINT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            // Lex.g:44:14: ( ( '0' .. '9' )+ )
            // Lex.g:44:16: ( '0' .. '9' )+
            {
            // Lex.g:44:16: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Lex.g:44:17: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:46:14: ( CHAR ( INT | CHAR )* )
            // Lex.g:46:16: CHAR ( INT | CHAR )*
            {
            mCHAR(); 
            // Lex.g:46:21: ( INT | CHAR )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='A' && LA4_0<='Z')||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // Lex.g:46:23: INT
            	    {
            	    mINT(); 

            	    }
            	    break;
            	case 2 :
            	    // Lex.g:46:29: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            // Lex.g:49:14: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
            // Lex.g:49:16: ( 'A' .. 'Z' | 'a' .. 'z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:51:14: ( '\\'' ( '\\'' '\\'' | ~ '\\'' )* '\\'' )
            // Lex.g:51:16: '\\'' ( '\\'' '\\'' | ~ '\\'' )* '\\''
            {
            match('\''); 
            // Lex.g:51:21: ( '\\'' '\\'' | ~ '\\'' )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\'') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='\'') ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // Lex.g:51:22: '\\'' '\\''
            	    {
            	    match('\''); 
            	    match('\''); 

            	    }
            	    break;
            	case 2 :
            	    // Lex.g:51:34: ~ '\\''
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:53:14: ( '{' (~ '}' )* '}' )
            // Lex.g:53:16: '{' (~ '}' )* '}'
            {
            match('{'); 
            // Lex.g:53:20: (~ '}' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='|')||(LA6_0>='~' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Lex.g:53:21: ~ '}'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='|')||(input.LA(1)>='~' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('}'); 
            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Lex.g:55:14: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // Lex.g:55:16: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // Lex.g:55:16: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Lex.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // Lex.g:1:8: ( BEGIN | END | WRITE | WRITELN | ELSE | IF | READ | REPEAT | UNTIL | SEMICOLON | OPENPAREN | CLOSEPAREN | GREATER | LESSER | EQUALS | DEQUALS | GEQUALS | LEQUALS | PLUS | MINUS | TIMES | DIVIDE | ASSIGN | REALNUM | IDENT | STRING | COMMENT | WS )
        int alt8=28;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // Lex.g:1:10: BEGIN
                {
                mBEGIN(); 

                }
                break;
            case 2 :
                // Lex.g:1:16: END
                {
                mEND(); 

                }
                break;
            case 3 :
                // Lex.g:1:20: WRITE
                {
                mWRITE(); 

                }
                break;
            case 4 :
                // Lex.g:1:26: WRITELN
                {
                mWRITELN(); 

                }
                break;
            case 5 :
                // Lex.g:1:34: ELSE
                {
                mELSE(); 

                }
                break;
            case 6 :
                // Lex.g:1:39: IF
                {
                mIF(); 

                }
                break;
            case 7 :
                // Lex.g:1:42: READ
                {
                mREAD(); 

                }
                break;
            case 8 :
                // Lex.g:1:47: REPEAT
                {
                mREPEAT(); 

                }
                break;
            case 9 :
                // Lex.g:1:54: UNTIL
                {
                mUNTIL(); 

                }
                break;
            case 10 :
                // Lex.g:1:60: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 11 :
                // Lex.g:1:70: OPENPAREN
                {
                mOPENPAREN(); 

                }
                break;
            case 12 :
                // Lex.g:1:80: CLOSEPAREN
                {
                mCLOSEPAREN(); 

                }
                break;
            case 13 :
                // Lex.g:1:91: GREATER
                {
                mGREATER(); 

                }
                break;
            case 14 :
                // Lex.g:1:99: LESSER
                {
                mLESSER(); 

                }
                break;
            case 15 :
                // Lex.g:1:106: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 16 :
                // Lex.g:1:113: DEQUALS
                {
                mDEQUALS(); 

                }
                break;
            case 17 :
                // Lex.g:1:121: GEQUALS
                {
                mGEQUALS(); 

                }
                break;
            case 18 :
                // Lex.g:1:129: LEQUALS
                {
                mLEQUALS(); 

                }
                break;
            case 19 :
                // Lex.g:1:137: PLUS
                {
                mPLUS(); 

                }
                break;
            case 20 :
                // Lex.g:1:142: MINUS
                {
                mMINUS(); 

                }
                break;
            case 21 :
                // Lex.g:1:148: TIMES
                {
                mTIMES(); 

                }
                break;
            case 22 :
                // Lex.g:1:154: DIVIDE
                {
                mDIVIDE(); 

                }
                break;
            case 23 :
                // Lex.g:1:161: ASSIGN
                {
                mASSIGN(); 

                }
                break;
            case 24 :
                // Lex.g:1:168: REALNUM
                {
                mREALNUM(); 

                }
                break;
            case 25 :
                // Lex.g:1:176: IDENT
                {
                mIDENT(); 

                }
                break;
            case 26 :
                // Lex.g:1:182: STRING
                {
                mSTRING(); 

                }
                break;
            case 27 :
                // Lex.g:1:189: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 28 :
                // Lex.g:1:197: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\6\24\3\uffff\1\40\1\42\14\uffff\4\24\1\47\2\24\4\uffff"+
        "\1\24\1\54\2\24\1\uffff\4\24\1\uffff\1\63\1\24\1\65\2\24\1\70\1"+
        "\uffff\1\72\1\uffff\1\24\1\74\1\uffff\1\24\1\uffff\1\76\1\uffff"+
        "\1\77\2\uffff";
    static final String DFA8_eofS =
        "\100\uffff";
    static final String DFA8_minS =
        "\1\11\1\145\1\154\1\162\1\146\1\145\1\156\3\uffff\2\75\14\uffff"+
        "\1\147\1\144\1\163\1\151\1\60\1\141\1\164\4\uffff\1\151\1\60\1\145"+
        "\1\164\1\uffff\1\144\1\145\1\151\1\156\1\uffff\1\60\1\145\1\60\1"+
        "\141\1\154\1\60\1\uffff\1\60\1\uffff\1\164\1\60\1\uffff\1\156\1"+
        "\uffff\1\60\1\uffff\1\60\2\uffff";
    static final String DFA8_maxS =
        "\1\173\1\145\1\156\1\162\1\146\1\145\1\156\3\uffff\2\75\14\uffff"+
        "\1\147\1\144\1\163\1\151\1\172\1\160\1\164\4\uffff\1\151\1\172\1"+
        "\145\1\164\1\uffff\1\144\1\145\1\151\1\156\1\uffff\1\172\1\145\1"+
        "\172\1\141\1\154\1\172\1\uffff\1\172\1\uffff\1\164\1\172\1\uffff"+
        "\1\156\1\uffff\1\172\1\uffff\1\172\2\uffff";
    static final String DFA8_acceptS =
        "\7\uffff\1\12\1\13\1\14\2\uffff\1\17\1\20\1\23\1\24\1\25\1\26\1"+
        "\27\1\30\1\31\1\32\1\33\1\34\7\uffff\1\21\1\15\1\22\1\16\4\uffff"+
        "\1\6\4\uffff\1\2\6\uffff\1\5\1\uffff\1\7\2\uffff\1\1\1\uffff\1\3"+
        "\1\uffff\1\11\1\uffff\1\10\1\4";
    static final String DFA8_specialS =
        "\100\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\27\2\uffff\1\27\22\uffff\1\27\1\15\5\uffff\1\25\1\10\1\11"+
            "\1\20\1\16\1\uffff\1\17\1\uffff\1\21\12\23\1\22\1\7\1\13\1\14"+
            "\1\12\2\uffff\32\24\6\uffff\1\24\1\1\2\24\1\2\3\24\1\4\10\24"+
            "\1\5\2\24\1\6\1\24\1\3\3\24\1\26",
            "\1\30",
            "\1\32\1\uffff\1\31",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "",
            "",
            "",
            "\1\37",
            "\1\41",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\50\16\uffff\1\51",
            "\1\52",
            "",
            "",
            "",
            "",
            "\1\53",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\55",
            "\1\56",
            "",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\64",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "\1\66",
            "\1\67",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "\12\24\7\uffff\32\24\6\uffff\13\24\1\71\16\24",
            "",
            "\1\73",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "\1\75",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            "\12\24\7\uffff\32\24\6\uffff\32\24",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( BEGIN | END | WRITE | WRITELN | ELSE | IF | READ | REPEAT | UNTIL | SEMICOLON | OPENPAREN | CLOSEPAREN | GREATER | LESSER | EQUALS | DEQUALS | GEQUALS | LEQUALS | PLUS | MINUS | TIMES | DIVIDE | ASSIGN | REALNUM | IDENT | STRING | COMMENT | WS );";
        }
    }
 

}