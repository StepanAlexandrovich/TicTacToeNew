package tictactoe;

import tictactoe.environment.Field;
import tictactoe.intelligence.Counter;
import tictactoe.visualization.FrameGame;
import tictactoe.visualization.FrameSettings;

class Cycle {
    private Field field = new Field();
    private Counter counter = new Counter(field);
    
    private FrameGame frame = new FrameGame();

    private void startPosition(){
        field.reset();
        frame.update(field.getMatrix());
    }

    private void movePlayer(){
        int index = -1;
        
        do{
           
            boolean b = field.getSymbolNext().equals(PS.getSymbolUser());
            if(b){ index = frame.getIndexUser(); }
            else { index = counter.process(); }
          
        }while(field.move(index)==-1);

        frame.update(field.getMatrix());
    }

    String getResult(){
        if(field.getResult() == 1){
            if(field.getSymbol().equals(PS.getSymbolPC()))  { return "YOU LOST"; }
            if(field.getSymbol().equals(PS.getSymbolUser())){ return "YOU WON";  } 
        }else{
            return "DRAW";
        }
                
        return "";
    }
    
    private String frameSettings(){
        return new FrameSettings(getResult()).process();
    }

    private void process(){
        startPosition();

        while(true){
            movePlayer();
            
            if(field.endGame()){
                switch(frameSettings()){
                    case "restart": startPosition();      break;
                    case "close":   System.exit(0); break;
                }
            }
        }

    }

    ///////////////////////////////////////////
    public static void main(String[] args) { new Cycle().process(); }
    
}
