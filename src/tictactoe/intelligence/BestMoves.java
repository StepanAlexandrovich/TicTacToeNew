package tictactoe.intelligence;

import tictactoe.environment.Field;
import java.util.ArrayList;

public class BestMoves {
    private Estimate estimate = new Estimate();

    public int maxScore(Integer[] scores){
        int maxScore = -200000000;
        for(int i = 0;i<scores.length;i++){
            if(scores[i]!=null&&scores[i]>maxScore){
                maxScore = scores[i];
            }
        }
        return maxScore;
    }

    ArrayList<Integer> moves(Integer[] scores){
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int maxScore = maxScore(scores);
        for(int i = 0;i<scores.length;i++){
            //if(scores[i]!=null&&scores[i]<=maxScore&&scores[i]>maxScore-10) {
            if(scores[i]!=null && scores[i]==maxScore) {
                moves.add(i);
            }
        }
        return moves;
    }

    ArrayList<Integer> process(Field field){

        Integer[] scores = new Integer[field.getLength()];
        for(int i = 0;i<field.getLength();i++){
            if(field.move(i)!=-1){
                scores[i] = estimate.process(field);
                field.resetMove();
            }
        }

        return moves(scores);
    }

}
