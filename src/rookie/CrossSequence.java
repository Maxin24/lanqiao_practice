package rookie;

import java.util.Scanner;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author liujx
 */
public class CrossSequence {
    private static int crossMul(Point p1,Point p2){
        return p1.getX()*p2.getY()-p1.getY()*p2.getX();
    }


    public static void main(String[] args){
        int xa,ya,xb,yb,xc,yc,xd,yd;
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            xa=scanner.nextInt();
            ya=scanner.nextInt();
            xb=scanner.nextInt();
            yb=scanner.nextInt();
            xc=scanner.nextInt();
            yc=scanner.nextInt();
            xd=scanner.nextInt();
            yd=scanner.nextInt();

            Point pointA=new Point(xa,ya);
            Point pointB=new Point(xb,yb);
            Point pointC=new Point(xc,yc);
            Point pointD=new Point(xd,yd);

            Point vectorAB=new Point(pointB.getX()-pointA.getX(),pointB.getY()- pointA.getY());
            Point vectorCD=new Point(pointD.getX()- pointC.getX(), pointD.getY()- pointC.getY());
            Point vectorBC=new Point(pointC.getX()- pointB.getX(), pointC.getY()-pointB.getY());
            Point vectorAD=new Point(pointD.getX()-pointA.getX(),pointD.getY()- pointC.getY());
            Point vectorAC=new Point(pointC.getX()-pointA.getX(),pointC.getY()-pointA.getY());

            //平行
            if(crossMul(vectorAB,vectorCD)==0){
                //共线
                if(crossMul(vectorAD,vectorBC)==0){
                    boolean flag=(min(pointA.getX(),pointB.getX())<min(pointC.getX(),pointD.getX()) && max(pointA.getX(),pointB.getX())>=min(pointC.getX(),pointD.getX()))
                            || (min(pointC.getX(),pointD.getX())<min(pointA.getX(),pointB.getX()) && max(pointC.getX(),pointD.getX())>=min(pointA.getX(),pointB.getX()))
                            || (min(pointA.getY(),pointB.getY())<min(pointC.getY(),pointD.getY()) && max(pointA.getY(),pointB.getY())>=min(pointC.getY(),pointD.getY()))
                            || (min(pointC.getY(),pointD.getY())<min(pointA.getY(),pointB.getY()) && max(pointC.getY(),pointD.getY())>=min(pointA.getY(),pointB.getY()));
                    if(flag){
                        System.out.println("yes");
                    }else{
                        System.out.println("no");
                    }
                }else{
                    System.out.println("no");
                }
                continue;
            }

            if(crossMul(vectorAC,vectorAB)*crossMul(vectorAD,vectorAB)<=0 && crossMul(vectorAC,vectorCD)*crossMul(vectorBC,vectorCD)<=0){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }
    }
}

class Point{
    private int x,y;
    public Point(int x,int y){
        this.x=x;this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
