package com.zju.iot.antalg;

/**
 * @author Thea (theazhu0321@gmail.com)
 */
public interface MoveStrategy {

    /**
     * 选择下一个景点
     *
     * @param surrounding 当前环境
     * @param i           当前经过的景点个数
     * @param pheromone   当前蚂蚁所处景点到其他景点路径上的信息素
     * @return 下一个景点的索引
     */
    int selectNext(Surrounding surrounding, int i, double[] pheromone);
}
