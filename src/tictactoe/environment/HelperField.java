package tictactoe.environment;

import tictactoe.matrix.*;
import tictactoe.PS;

class HelperField {
    private Matrix matrix;
    private String symbolEmpty = PS.symbolEmpty;
    
    private boolean check(int x,int y,int a,int b,String symbol){ 
        for(int i = 0;i<PS.lengthVector;i++ ){
            int newX = x+a*i;
            int newY = y+b*i;
            
            if(!matrix.range(newX,newY) || 
                    matrix.getSymbol(newX,newY)!=symbol){ 
                return false; 
            }
        }
        return true;
    }
    
    ////////////////////////////////////////////
    
    int getWinner(Matrix matrix,String symbol){
        this.matrix = matrix;
        
        for(int i = 0;i<matrix.getLength();i++){
            
            for(int a=-1;a<=1;a++){
                for(int b=-1;b<=1;b++){
                    if(!(a==0&&b==0)){ 
                        if(check(matrix.getX(i),matrix.getY(i),a,b,symbol))  { return 1; }
                    }
                }    
            }
                   
        }
        
        return 0;
    }
      
    boolean legalMove(int index,Matrix matrix){
        if(
                matrix.range(index)&&
                matrix.getSymbol(index).equals(symbolEmpty)){
              
            return true;
        }
        return false;
    }
      
}
