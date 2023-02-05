package tictactoe.visualization;

import tictactoe.Helper;
import tictactoe.PS;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameSettings extends JFrame{
    private Listener listener = new Listener();
    private Button button;
    
    private boolean process = true;
    private String text = "";

    public FrameSettings(String text){
       super(text); 

       add(new Button("restart","restart"));
       add(new Button("switchX0", PS.getSymbolUser()));
       add(new Button("switchLevel","level"+PS.getLevel()));
       add(new Button("close","close"));

       this.setLocation(450,500);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       this.setLayout(new FlowLayout(FlowLayout.CENTER));
       
       this.setSize(300,100);
       this.setVisible(true);
    }
    
    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {
            button = (Button)arg0.getSource();
            
            switch(button.text){
                case "switchX0":    switchX0();       break;
                case "switchLevel": switchLevel();    break;
                default : finishProcess(button.text); break;
            }     
        }
        
    }

    private class Button extends JButton{
        String text;
        Button(String text,String textVisible){
            this.text = text;
            this.setText(textVisible);
            this.addActionListener(listener);
        }
    }
    
    private void switchX0(){
        ((JButton)button).setText(PS.switchPcUser());
    }
                        
    private void switchLevel(){
        ((JButton)button).setText("level"+(PS.switchLevel()));
    }
    
    private void finishProcess(String text){
        this.text = text;
        process = false;
    }
    public String process(){
        while(process){
            Helper.sleep(10);
        }
        this.dispose();
        return text;
    }

}
