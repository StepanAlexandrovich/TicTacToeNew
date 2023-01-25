package tictactoe.environment;

import tictactoe.PS;

class Step {
    Step next;
    Step back;
    
    String symbol = PS.symbolFinish;
    int move,result;
        
    Step(int index){
        if(index < 1000){
            next = new Step(index+1);
            next.back = this;
        } 
    }
    
}
