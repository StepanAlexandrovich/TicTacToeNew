package tictactoe.matrix;

public class Matrix {
    private Point[] points;
    private int width,height,length;

    public Matrix(int width,int height){
        points = new PointMaker().createPoints(width,height);
        
        length = points.length;
        this.width = width;
        this.height = height; 
    }
    
    ///////   IN   //////
    private Point getPoint(int index){ 
        return points[index];
    }
    
    private Point getPoint(int x,int y){ 
        return points[width * y + x];
    }
    
    ///// OUTSIDE //////
    public int getLength(){ return length; }

    public int getX(int index){
       return getPoint(index).x; 
    }

    public int getY(int index){
       return getPoint(index).y; 
    }

    public String getSymbol(int index){
        return getPoint(index).symbol;
    }

    public String getSymbol(int x,int y){
        return getPoint(x,y).symbol;
    }

    public void setSymbol(int index,String symbol){
        getPoint(index).symbol = symbol;
    }

    public void setSymbol(int x,int y,String symbol){
        getPoint(x,y).symbol = symbol;
    }
    
    // check //
    public boolean range(int index){
        if(index>=0&&index<length){
            return true; 
        }
        return false;
    }

    public boolean range(int x,int y){
        if(x>=0&&x<width&&y>=0&&y<height){
            return true; 
        }
        return false;
    }
    
    // action //
    public Matrix fill(String symbol){
        for(Point point:points){
            point.symbol = symbol;
        }
        return this;
    }

    public Matrix copy(){
        Matrix matrix = new Matrix(width,height);
        for(int i = 0;i<length;i++){
            matrix.setSymbol(i,getSymbol(i));
        }
        return matrix;
    }
    
}
