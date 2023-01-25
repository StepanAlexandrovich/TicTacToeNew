package tictactoe.environment;

import tictactoe.PS;
import tictactoe.matrix.Matrix;

public class Field {
    private HelperField helper = new HelperField();
    private Matrix matrix = new Matrix(PS.width,PS.height);

    private Step stepStart = new Step(0),step;

    public Field(){ reset(); }
    
    //// GET ////
    public int getLength(){ return matrix.getLength(); }
    public String getSymbol(){ return step.symbol ; }
    public String getSymbolNext(){ return PS.inversionSymbol(step.symbol); }
    public Matrix getMatrix(){ return matrix.copy(); }
    public int getResult(){ return helper.getWinner(matrix,step.symbol); }

    public boolean endGame(){
        if(getResult()==1 || step.index==matrix.getLength()){
            return true;
        }
        return false;
    }
    
    // action //
    public void reset(){
        matrix.fill(PS.symbolEmpty);
        step = stepStart;
    }

    public int move(int index){
        if(helper.legalMove(index,matrix)){
            step = step.next;
            
            step.move = index;
            step.symbol = PS.inversionSymbol(step.back.symbol );
            matrix.setSymbol(step.move,step.symbol);
            
            return step.move;
        }
        return -1; 
    }

    public void resetMove(){
        matrix.setSymbol(step.move,PS.symbolEmpty);
        step = step.back;
    }
     
}
