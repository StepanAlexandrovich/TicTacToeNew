package tictactoe.intelligence;

import tictactoe.PS;
import tictactoe.environment.Field;
import tictactoe.matrix.Matrix;

public class Counter {
    private Field field = new Field();
    private int bestMove;
    private BestMoves bestMoves = new BestMoves();

    public int process(Matrix matrix, String symbol){
        field.setStart(matrix, symbol);
        recursion(PS.getDepth());

        return bestMove;
    }

    private int recursion(int depth){

        int score = -1,maxScore = -2,bestMove = -1;
        for(int i:bestMoves.process(field)){
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
