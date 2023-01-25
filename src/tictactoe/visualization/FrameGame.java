package tictactoe.visualization;

import tictactoe.PS;
import tictactoe.matrix.Matrix;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class FrameGame extends JFrame{
    private Render render = new Render();
    private int indexUser = -1;
    private JLabel extra;

    private int heightExtra = render.getWidth()/10;

    public FrameGame(){
        Panel panel = new Panel();

        panel.addComponent(
                new CanvasGame(),0,0,render.getWidth(),render.getHeight()
        );
        panel.addComponent(
                extra = new Extra(),0,render.getHeight(),render.getWidth(),heightExtra
        );

        addComponent(panel,render.getWidth(),render.getHeight() + heightExtra);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public int getIndexUser(){ return indexUser; }

    void setIndexUser(int x,int y){
        indexUser = y*PS.width+x;
    }

    public void setText(String text){
        extra.setText(text);
    }

    public void update(Matrix matrix,int lastMove){
        indexUser = -1;
        render.process(matrix,lastMove);
        repaint();
    }
    ///////////////////////
    void addComponent(JComponent component,int width,int height){
        component.setLayout(null);
        component.setPreferredSize(new Dimension(width,height));
        add(component);
        pack();
    }
    //// COMPONENTS ////
    private class Panel extends JPanel{
        void addComponent(JComponent component,int x,int y,int width,int height){
            component.setBounds(x,y,width,height);
            add(component);
        }
    }

    private class CanvasGame extends JLabel{
        CanvasGame(){
            super(new ImageIcon(render.getImage()));
            addMouseListener(new Mouse(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    int x = e.getX()/PS.multiplication;
                    int y = e.getY()/PS.multiplication;
                    setIndexUser(x,y);
                }
            });
        }

    }

    private class Extra extends JLabel{
        Extra(){
            Font font = new Font("SansSerif", Font.BOLD, 15);
            setFont(font);
        }
    }

}
