package com.diagens.three.concurrency;

/**
 * @author ZNJ
 * @create 2019-03-27 11:46
 */
public class Pair {
    private int x,y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX(){x++;}

    public void incrementY(){y++;}

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y+
                '}';
    }
    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair Values not equal:"+Pair.this);
        }
    }

    public void checkState(){
        if(x!=y){
            throw new PairValuesNotEqualException();
        }
    }
}
