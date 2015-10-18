/* The following code was generated by JFlex 1.6.1 */

package scanner;

import java_cup.runtime.*;
import parser.*;
import Tables.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>C:/Users/jona/Documents/NetBeansProjects/Compilador_T2/Compilador/src/scanner/Lexer.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\27\1\22\1\70\1\27\1\23\22\0\1\27\2\0\1\25"+
    "\1\0\1\26\2\0\1\36\1\37\1\32\1\30\1\53\1\31\1\0"+
    "\1\24\1\2\11\3\1\34\1\52\1\0\1\35\3\0\3\1\1\15"+
    "\1\46\1\10\1\50\1\21\1\7\2\1\1\44\1\1\1\51\1\14"+
    "\1\1\1\47\1\16\1\6\1\45\1\17\1\13\1\20\3\1\1\40"+
    "\1\0\1\41\1\33\1\67\1\0\3\54\1\62\1\4\1\57\1\54"+
    "\1\66\1\56\2\54\1\5\1\54\1\11\1\61\2\54\1\63\1\55"+
    "\1\12\1\64\1\60\1\65\3\54\1\42\1\0\1\43\7\0\1\70"+
    "\u1fa2\0\1\70\1\70\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\2\3\5\1\2\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\1\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\4\1\1\21\1\22\10\3\1\23"+
    "\6\0\2\6\1\24\1\0\1\25\2\0\1\26\1\27"+
    "\2\0\1\23\6\3\1\30\1\31\5\0\1\32\1\33"+
    "\1\0\1\34\1\35\1\30\1\31\3\3\1\36\1\37"+
    "\3\0\1\36\1\37\2\3\1\0\1\40\1\3\1\40"+
    "\2\41";

  private static int [] zzUnpackAction() {
    int [] result = new int[97];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\71\0\71\0\162\0\253\0\344\0\u011d\0\u0156"+
    "\0\u018f\0\u01c8\0\u0201\0\71\0\u023a\0\u0273\0\u02ac\0\71"+
    "\0\71\0\u02e5\0\71\0\u031e\0\71\0\71\0\71\0\71"+
    "\0\71\0\71\0\u0357\0\u0390\0\u03c9\0\u0402\0\71\0\71"+
    "\0\u043b\0\u0474\0\u04ad\0\u04e6\0\u051f\0\u0558\0\u0591\0\u05ca"+
    "\0\71\0\u0603\0\u063c\0\u0675\0\u06ae\0\u06e7\0\u0720\0\71"+
    "\0\u0759\0\71\0\u0792\0\71\0\u07cb\0\u0804\0\71\0\71"+
    "\0\u083d\0\u0876\0\344\0\u08af\0\u08e8\0\u0921\0\u095a\0\u0993"+
    "\0\u09cc\0\71\0\71\0\u0a05\0\u0a3e\0\u0a77\0\u0ab0\0\u0ae9"+
    "\0\71\0\71\0\u0b22\0\71\0\71\0\344\0\344\0\u0b5b"+
    "\0\u0b94\0\u0bcd\0\344\0\71\0\u0c06\0\u0c3f\0\u0c78\0\71"+
    "\0\344\0\u0cb1\0\u0cea\0\u0d23\0\71\0\u0d5c\0\344\0\71"+
    "\0\344";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[97];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\2\2\1\3\1\4\1\5\1\6\1\2\1\7\1\10"+
    "\2\6\1\11\2\2\1\12\1\2\1\13\1\2\1\14"+
    "\1\15\1\16\1\2\1\17\1\14\1\20\1\21\1\22"+
    "\1\23\1\24\1\2\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\1\2\1\34\1\2\1\35\1\36\1\37"+
    "\1\40\2\6\1\41\1\42\1\43\2\6\1\44\1\6"+
    "\1\45\1\6\1\2\74\0\2\4\66\0\1\6\2\46"+
    "\1\6\1\47\14\6\22\0\1\47\5\6\2\0\13\6"+
    "\1\50\2\0\1\6\2\46\16\6\22\0\6\6\2\0"+
    "\13\6\1\50\11\0\1\51\1\52\37\0\1\52\5\0"+
    "\1\51\25\0\1\53\44\0\1\53\23\0\1\54\44\0"+
    "\1\54\13\0\1\55\41\0\1\55\43\0\1\56\44\0"+
    "\1\56\24\0\1\14\73\0\1\57\43\0\22\17\1\60"+
    "\1\61\45\17\32\0\1\62\72\0\1\63\101\0\1\64"+
    "\1\65\27\0\1\66\36\0\1\66\2\0\1\67\66\0"+
    "\1\70\1\71\70\0\1\72\23\0\1\6\2\46\4\6"+
    "\1\73\1\74\10\6\22\0\5\6\1\74\2\0\3\6"+
    "\1\73\7\6\1\50\2\0\1\6\2\46\10\6\1\75"+
    "\5\6\22\0\6\6\2\0\5\6\1\75\5\6\1\50"+
    "\2\0\1\6\2\46\10\6\1\76\5\6\22\0\6\6"+
    "\2\0\5\6\1\76\5\6\1\50\2\0\1\6\2\46"+
    "\1\77\15\6\22\0\2\6\1\77\3\6\2\0\13\6"+
    "\1\50\2\0\1\6\2\46\15\6\1\100\22\0\6\6"+
    "\2\0\12\6\1\100\1\50\3\0\2\46\66\0\1\6"+
    "\2\46\2\6\1\101\13\6\22\0\6\6\2\0\1\6"+
    "\1\101\11\6\1\50\2\0\1\50\2\46\16\50\22\0"+
    "\6\50\2\0\13\50\14\0\1\102\32\0\1\102\41\0"+
    "\1\103\44\0\1\103\14\0\1\104\46\0\1\104\24\0"+
    "\1\105\32\0\1\105\32\0\1\106\46\0\1\106\12\0"+
    "\25\107\1\110\43\107\22\0\1\60\103\0\1\111\102\0"+
    "\1\112\27\0\1\113\46\0\1\113\62\0\1\114\70\0"+
    "\1\115\22\0\1\6\2\46\6\6\1\116\7\6\22\0"+
    "\1\6\1\116\4\6\2\0\13\6\1\50\2\0\1\6"+
    "\2\46\12\6\1\117\3\6\22\0\6\6\2\0\7\6"+
    "\1\117\3\6\1\50\2\0\1\6\2\46\3\6\1\120"+
    "\12\6\22\0\6\6\2\0\2\6\1\120\10\6\1\50"+
    "\2\0\1\6\2\46\6\6\1\121\7\6\22\0\1\6"+
    "\1\121\4\6\2\0\13\6\1\50\2\0\1\6\2\46"+
    "\3\6\1\122\12\6\22\0\6\6\2\0\2\6\1\122"+
    "\10\6\1\50\2\0\1\6\2\46\1\123\15\6\22\0"+
    "\2\6\1\123\3\6\2\0\13\6\1\50\16\0\1\124"+
    "\44\0\1\124\25\0\1\125\44\0\1\125\11\0\1\126"+
    "\36\0\1\126\24\0\25\107\1\127\43\107\24\0\1\60"+
    "\1\110\47\0\1\130\41\0\1\130\23\0\1\6\2\46"+
    "\11\6\1\131\4\6\22\0\6\6\2\0\6\6\1\131"+
    "\4\6\1\50\2\0\1\6\2\46\13\6\1\132\2\6"+
    "\22\0\6\6\2\0\10\6\1\132\2\6\1\50\2\0"+
    "\1\6\2\46\1\6\1\133\14\6\22\0\1\133\5\6"+
    "\2\0\13\6\1\50\17\0\1\134\44\0\1\134\11\0"+
    "\1\135\41\0\1\135\22\0\24\107\1\60\1\127\43\107"+
    "\1\0\1\6\2\46\12\6\1\136\3\6\22\0\6\6"+
    "\2\0\7\6\1\136\3\6\1\50\2\0\1\6\2\46"+
    "\1\137\15\6\22\0\2\6\1\137\3\6\2\0\13\6"+
    "\1\50\12\0\1\140\37\0\1\140\20\0\1\6\2\46"+
    "\5\6\1\141\10\6\22\0\5\6\1\141\2\0\13\6"+
    "\1\50\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3477];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\10\1\1\11\3\1\2\11\1\1\1\11"+
    "\1\1\6\11\4\1\2\11\10\1\1\11\6\0\1\11"+
    "\1\1\1\11\1\0\1\11\2\0\2\11\2\0\7\1"+
    "\2\11\5\0\2\11\1\0\2\11\6\1\1\11\3\0"+
    "\1\11\3\1\1\0\1\11\2\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[97];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 200) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.out.println("Error Lexico: linea "+(yyline)+" columna "+(yycolumn)+ " token: "+yytext());
            }
          case 34: break;
          case 2: 
            { return new Symbol(sym.NUM,yyline,yycolumn,yytext());
            }
          case 35: break;
          case 3: 
            { return new Symbol(sym.ID,yyline,yycolumn,yytext());
            }
          case 36: break;
          case 4: 
            { /*Ignorar*/
            }
          case 37: break;
          case 5: 
            { return new Symbol(sym.DIVISION,yyline,yycolumn,yytext());
            }
          case 38: break;
          case 6: 
            { /*ignorar*/
            }
          case 39: break;
          case 7: 
            { return new Symbol(sym.SUMA,yyline,yycolumn,yytext());
            }
          case 40: break;
          case 8: 
            { return new Symbol(sym.RESTA,yyline,yycolumn,yytext());
            }
          case 41: break;
          case 9: 
            { return new Symbol(sym.MULTIPLICACION,yyline,yycolumn,yytext());
            }
          case 42: break;
          case 10: 
            { return new Symbol(sym.EXPONENCIACION_1,yyline,yycolumn,yytext());
            }
          case 43: break;
          case 11: 
            { return new Symbol(sym.PARENT_IZQ,yyline,yycolumn,yytext());
            }
          case 44: break;
          case 12: 
            { return new Symbol(sym.PARENT_DER,yyline,yycolumn,yytext());
            }
          case 45: break;
          case 13: 
            { return new Symbol(sym.CORCH_IZQ,yyline,yycolumn,yytext());
            }
          case 46: break;
          case 14: 
            { return new Symbol(sym.CORCH_DER,yyline,yycolumn,yytext());
            }
          case 47: break;
          case 15: 
            { return new Symbol(sym.LLAVE_IZQ,yyline,yycolumn,yytext());
            }
          case 48: break;
          case 16: 
            { return new Symbol(sym.LLAVE_DER,yyline,yycolumn,yytext());
            }
          case 49: break;
          case 17: 
            { return new Symbol(sym.PUNTOCOMA,yyline,yycolumn,yytext());
            }
          case 50: break;
          case 18: 
            { return new Symbol(sym.COMA,yyline,yycolumn,yytext());
            }
          case 51: break;
          case 19: 
            { return new Symbol(sym.IF,yyline,yycolumn,yytext());
            }
          case 52: break;
          case 20: 
            { return new Symbol(sym.EXPONENCIACION_2,yyline,yycolumn,yytext());
            }
          case 53: break;
          case 21: 
            { return new Symbol(sym.MENOR,yyline,yycolumn,yytext());
            }
          case 54: break;
          case 22: 
            { return new Symbol(sym.IGUALIGUAL,yyline,yycolumn,yytext());
            }
          case 55: break;
          case 23: 
            { return new Symbol(sym.MAYOR,yyline,yycolumn,yytext());
            }
          case 56: break;
          case 24: 
            { return new Symbol(sym.INT,yyline,yycolumn,yytext());
            }
          case 57: break;
          case 25: 
            { return new Symbol(sym.FOR,yyline,yycolumn,yytext());
            }
          case 58: break;
          case 26: 
            { return new Symbol(sym.ASSIGN,yyline,yycolumn,yytext());
            }
          case 59: break;
          case 27: 
            { return new Symbol(sym.MENIGUAL,yyline,yycolumn,yytext());
            }
          case 60: break;
          case 28: 
            { return new Symbol(sym.MAYIGUAL,yyline,yycolumn,yytext());
            }
          case 61: break;
          case 29: 
            { return new Symbol(sym.DISTINTO,yyline,yycolumn,yytext());
            }
          case 62: break;
          case 30: 
            { return new Symbol(sym.ELSE,yyline,yycolumn,yytext());
            }
          case 63: break;
          case 31: 
            { return new Symbol(sym.VOID,yyline,yycolumn,yytext());
            }
          case 64: break;
          case 32: 
            { return new Symbol(sym.WHILE,yyline,yycolumn,yytext());
            }
          case 65: break;
          case 33: 
            { return new Symbol(sym.RETURN,yyline,yycolumn,yytext());
            }
          case 66: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
