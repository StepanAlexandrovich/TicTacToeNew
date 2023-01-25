package tictactoe.intelligence;

import tictactoe.PS;
import tictactoe.environment.Field;

public class Counter {
    private Field field;
    private int bestMove;
    
    public Counter(Field field){
        this.field = field;
    }
    
    public int process(){
        recursion(PS.getDepth());
        
        return bestMove;
    }
    
    private int recursion(int depth){
        
        int score = -1,maxScore = -2,bestMove = -1;
        for(int i = 0;i<field.getLength();i++){
            if(field.move(i)!=-1){
                if(depth==0||field.endGame()){ score = field.getResult();  }
                else                         { score = recursion(depth-1); }
                if(score>=maxScore){ maxScore = score; bestMove = i; }
                field.resetMove();  
            } 
        }
        this.bestMove = bestMove;
        
        return -maxScore;  
    }
    
}
