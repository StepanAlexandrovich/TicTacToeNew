package tictactoe.visualization;

import tictactoe.PS;
import tictactoe.matrix.Matrix;

import java.awt.*;
import java.awt.image.BufferedImage;

class Render {
    private int mult = PS.multiplication;
    private Color background = Color.WHITE;

    private BufferedImage image = new BufferedImage(
            getWidth(),getHeight(),
            BufferedImage.TYPE_INT_ARGB);
    private Graphics2D g = image.createGraphics();

    int getWidth(){ return PS.widthMult+1; }
    int getHeight(){ return PS.heightMult+1; }

    BufferedImage getImage(){
        return image;
    }

    void process(Matrix matrix,int lastMove){
        g.setStroke(new BasicStroke(4));

        for(int i = 0;i<matrix.getLength();i++){
            String symbol = matrix.getSymbol(i);

            int x = matrix.getX(i)*mult;
            int y = matrix.getY(i)*mult;

            switch (symbol) {
                case PS.symbolEmpty:
                    cell(x,y,background,Color.BLACK);
                    break;
                case PS.symbolStart:
                    cell(x,y,Color.MAGENTA,Color.BLACK);
                    cross(x,y,Color.BLACK);
                    break;
                case PS.symbolFinish:
                    cell(x,y,Color.CYAN,Color.BLACK);
                    zero(x,y,Color.BLACK);
                    break;
            }

            if(i==lastMove){
                g.setColor(Color.BLACK);
                g.drawRect(x+2,y+2,mult-4,mult-4);
            }

        }
    }

    void cell(int x,int y,Color filling,Color border){
        g.setColor(filling);
        g.fillRect(x,y,mult,mult);
        g.setColor(border);
        g.drawRect(x,y,mult,mult);
    }

    void cross(int x,int y,Color color){
        g.setColor(color);
        g.drawLine(x,y,x + mult,y + mult);
        g.drawLine(x+mult,y,x,y + mult);
    }

    void zero(int x,int y,Color color){
        g.setColor(color);
        g.drawOval(x+2,y+2,mult-4,mult-4);
    }

}
