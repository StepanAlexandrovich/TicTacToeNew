package tictactoe;

import tictactoe.environment.Field;
import tictactoe.intelligence.Counter;
import tictactoe.visualization.FrameGame;
import tictactoe.visualization.FrameSettings;

class Cycle {
    private Field field = new Field();
    private Counter counter = new Counter();

    private FrameGame frame = new FrameGame();

    private int lastMove = -1;

    private void startPosition(){
        field.reset();
        lastMove = -1;

        frame.update(field.getMatrix(),lastMove);
    }

    private void movePlayer(String text){
        frame.setText(text + " is thinking");

        do{
            int index = -1;

            switch(text){
                case "pc":   index = counter.process(field.getMatrix(),PS.getSymbolPC()); break;
                case "user": index = frame.getIndexUser(); break;
            }
            lastMove = field.move(index);

        }while(lastMove ==-1);

        frame.setText("");

        frame.update(field.getMatrix(),lastMove);
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
            if(PS.getSymbolUser().equals(field.getSymbolNext())){
                movePlayer("user");
            }else{
                movePlayer("pc");
            }

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
