package tictactoe;

public class PS {
    // final
    public final static int width = 3;
    public final static int height = 3;
    public final static int lengthVector = 3;
    public final static int multiplication = 100;
    public final static int widthMult = width*multiplication;
    public final static int heightMult = height*multiplication;

    public final static String symbolEmpty = "";
    public final static String symbolStart = "X";
    public final static String symbolFinish = "0";
    
    // dynamic
    private static int depth = 5;
    private static String symbolPC = symbolStart;
    private static String symbolUser = symbolFinish;

    public static String getSymbolPC()   { return symbolPC;   }
    public static String getSymbolUser() { return symbolUser; }
    public static int    getDepth()      { return depth;      }
    
    // function
    public static String inversionSymbol(String symbol){
        if(symbol.equals(symbolStart)) { 
            return symbolFinish; 
        }else { 
            return symbolStart ; 
        }
    }

    public static String switchPcUser(){
        symbolPC = inversionSymbol(symbolPC);
        symbolUser = inversionSymbol(symbolUser);
        return symbolUser;
    }

    public static int getLevel(){ return depth - 3; }

    public static int switchLevel(){
        if(depth<9) { depth++;   }
        else        { depth = 4; }
        return getLevel();
    }
    
}
