package com.zju.iot.antalg;

import java.util.Comparator;

/**
 * @author Thea (theazhu0321@gmail.com)
 */
public class AntComparator implements Comparator<Ant> {

    public int compare(Ant ant1, Ant ant2) {
        if (ant1.isDead() && ant2.isDead())
            return 0;
        if (ant1.isDead())
            return -1;
        if (ant2.isDead())
            return 1;

        return ant2.getRouteTime() - ant1.getRouteTime();
    }
}
