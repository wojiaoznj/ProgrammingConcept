package com.diagens.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ZNJ
 * @create 2019-02-26 15:19
 */
public class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories=new ArrayList<Factory<? extends Part>>();

    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteerinBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random rand=new Random(47);
    public static Part createRandom(){
        int n=rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}
