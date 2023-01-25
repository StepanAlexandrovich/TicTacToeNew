package tictactoe.matrix;

class PointMaker {
    Point[] createPoints(int width,int height){
        int length = width*height;
        Point[] points = new Point[length];
        for(int i = 0;i<length;i++){ 
            points[i] = new Point(); 
        }
        
        int index = 0;
        for(int y = 0;y<height;y++){
            for(int x = 0;x<width;x++){
                points[index].index = index;
                points[index].x = x;
                points[index].y = y;
                index++;
            }
        }
        
        return points;
    }
}
