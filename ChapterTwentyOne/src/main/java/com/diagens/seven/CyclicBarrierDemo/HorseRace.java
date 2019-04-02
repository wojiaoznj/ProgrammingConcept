package com.diagens.seven.CyclicBarrierDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-29 15:31
 */
//赛马
public class HorseRace {
    //总长75
    static final int FINISH_LINE=75;
    //参赛的马群
    private List<Horse> horses=new ArrayList<Horse>();
    private ExecutorService service= Executors.newCachedThreadPool();
    //每跑完一轮等待
    private CyclicBarrier barrier;

    public HorseRace(int nHorses,final int pause) {
        //7个参与者
        barrier=new CyclicBarrier(nHorses, new Runnable() {
            //当所有的参与者都处于await的时候，自动触发
            public void run() {
                StringBuilder sb = new StringBuilder();
                //打印总路程
                for (int i = 0; i < FINISH_LINE; i++) {
                    sb.append("=");
                }
                System.out.println(sb);
                //打印每匹马跑的路线
                for (Horse hors : horses) {
                    System.out.println(hors.tracks());
                }
                //判断当前是否有马跑完
                for (Horse hors : horses) {
                    //如果有则结束比赛，宣布获胜者
                    if(hors.getStrides()>=FINISH_LINE){
                        System.out.println(hors+" won!");
                        service.shutdownNow();
                        return;
                    }
                }
                //暂停以后，CyclicBarrier会自动运行其余参与者的run
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                }
            }
        });

        //先执行一次各个参与者的run，之后等其全部await触发CyclicBarrier的run
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            service.execute(horse);
        }
    }

    public static void main(String [] args){
        //七匹马
        int nHorses=7;
        //每次间歇1000毫秒
        int pause=1000;
        new HorseRace(nHorses,pause);
    }
}
