package tictactoe.intelligence;

import tictactoe.PS;
import tictactoe.environment.Field;
import tictactoe.matrix.Matrix;

class Estimate {
    private int[] progression = progression();
    private Matrix matrix;

    int process(Field field){
        matrix = field.getMatrix();

        int score = 0;
        for(int i = 0;i<field.getLength();i++){

            for(int a=-1;a<=1;a++){
                for(int b=-1;b<=1;b++){
                    if(!(a==0&&b==0)){
                        int x = matrix.getX(i);
                        int y = matrix.getY(i);
                        
                        score +=  progression[ score(x,y,a,b,field.getSymbol())*2 ]
                                - progression[ score(x,y,a,b,field.getSymbolNext())*2+1 ];
                    }
                }
            }
        }

        return score;
    }

    private int score(int x,int y,int a,int b,String symbol){
        int score = 0;
        for(int i = 0;i<PS.lengthVector;i++ ) {
            int newX = x + a * i;
            int newY = y + b * i;

            if (!matrix.range(newX, newY) ||
                    (matrix.getSymbol(newX, newY) != symbol &&
                            matrix.getSymbol(newX, newY) != PS.symbolEmpty)) {
                return 0;
            } else if (matrix.getSymbol(newX, newY).equals(symbol)) { score++; }

        }
        return score;
    }
    
    private int[] progression(){
        int[]array = new int[12];
        double a = 80000;
        for(int i = 11;i>=0;i--) {
            a = a / 3;
            array[i] = (int) a;
        }

        return array;        
    }

}
