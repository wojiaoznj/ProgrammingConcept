package com.diagens.five;

/**
 * @author ZNJ
 * @create 2019/2/19-23:41
 */
public class ParcelSix {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;

            public PDestination(String label) {
                this.label = label;
            }

            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        ParcelSix ps=new ParcelSix();
        ps.destination("Hello,World");
    }
}
