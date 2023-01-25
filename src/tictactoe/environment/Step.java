package tictactoe.environment;

import tictactoe.PS;

class Step {
    Step next;
    Step back;
    
    String symbol = PS.symbolFinish;
    int index,move;
        
    Step(int index){
        if(index < 1000){
            this.index = index;
            
            next = new Step(index+1);
            next.back = this;
        } 
    }
    
}
