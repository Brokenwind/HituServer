package com.zju.iot.antalg;

import com.zju.iot.entity.SelectedPoint;

import java.util.Random;

/**
 * 蚂蚁
 *
 * @author Thea (theazhu0321@gmail.com)
 */
public class Ant implements MoveStrategy {
    private int id;            //蚂蚁的编号
    private Node[] nodes;  // 蚂蚁经过的景点信息记录
    private boolean[] flag;  // 蚂蚁是否可以走某个景点
    private int currentScenery;  // 当前所处景点
    private int routeTime;  // 蚂蚁总花费时间
    private int waitTime;  // 蚂蚁总等待时间
    private int playTime;  // 蚂蚁游玩时间
    private boolean dead;  // 蚂蚁是否死亡
    private int phe;  // 蚂蚁释放的信息素量，对本算法的性能影响不大

    private MoveStrategy moveStrategy;  // 选择下一个景点的策略
    private Surrounding surrounding;

    private Ant(int id, Node[] nodes, int currentScenery, boolean[] flag, int routeTime, int waitTime, int
            playTime, boolean dead, int phe, Surrounding surrounding) {
        this.id = id;
        this.nodes = nodes;
        this.currentScenery = currentScenery;
        this.flag = flag;
        this.routeTime = routeTime;
        this.waitTime = waitTime;
        this.playTime = playTime;
        this.dead = dead;
        this.phe = phe;
        this.moveStrategy = this;
        this.surrounding = surrounding;
    }

    public boolean move(int turn, double[] pheromone) {
        //蚂蚁移动到下一个景点
        if (dead)
            return false;
        int position = moveStrategy.selectNext(surrounding, turn, pheromone);
        if (position == -1) {
            dead = true;
            return false;
        }

        flag[position] = true;
        updateRoute(surrounding, turn, position);
        currentScenery = position;

        if (turn == surrounding.getPointCount() - 1) {
            updateRoute(surrounding, turn + 1, 0);
            currentScenery = 0;
        }

        return dead;
    }

    public void updateRoute(Surrounding surrounding, int count, int next) {
        SelectedPoint s = nodes[count - 1].scenery;
        SelectedPoint e = surrounding.getPoint(next);
        int time = surrounding.getDuration(s, e);
        Node node = new Node(e, next);
        node.arrivedTime = nodes[count - 1].leaveTime() + time;
        node.playTime = e.getStayTime();
        node.waitTime = Math.max(0, e.getOpenTime() - node.arrivedTime);
        // 判断结束游玩时是否超出景点关门时间
        if (node.leaveTime() <= e.getCloseTime()) {
            nodes[count] = node;
            waitTime += node.waitTime;
            playTime += node.playTime;
            routeTime += time + node.waitTime + node.playTime;
        } else {
            dead = true;
        }
    }

    public int getCurrentScenery() {
        return currentScenery;
    }

    public boolean isDead() {
        return dead;
    }

    public int getRouteTime() {
        return routeTime;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public double getPheromone() {
        return phe / routeTime;
    }

    public int selectNext(Surrounding surrounding, int i, double[] pheromone) {
        // 状态转移规则
        int n = pheromone.length;
        double rand = new Random().nextDouble();
        double probability[] = new double[n];
        int position = -1;
        if (rand > 0.5) {  // 确定选择
            double max = 0;
            // 计算选择每条路径的概率
            for (int k = 0; k < n; k++) {
                if (flag[k])
                    continue;
                probability[k] = probability(pheromone[k], nodes[i - 1], surrounding.getPoint(k));
                if (probability[k] > max) {
                    max = probability[k];
                    position = k;
                }
            }
        } else {  // 轮盘选择
            double p = new Random().nextDouble();
            double sum = 0;
            for (int k = 0; k < n; k++) {
                if (flag[k])
                    continue;
                probability[k] = probability(pheromone[k], nodes[i - 1], surrounding.getPoint(k)) + sum;
                sum = probability[k];
            }
            for (int k = 0; k < n; k++) {
                if (!flag[k] && probability[k] > sum * p)
                    position = k;
            }
        }
        return position;
    }

    /**
     * 计算路径选择概率
     *
     * @param pheromone 此条路径上的信息素
     * @param previous  路径上最后一个景点信息
     * @param e         路径终点
     * @return 选择此条路径的概率
     */
    private double probability(double pheromone, Node previous, SelectedPoint e) {
        SelectedPoint s = previous.scenery;
        int time = surrounding.getDuration(s, e);
        int wait = e.getOpenTime() - previous.leaveTime() - time;
        wait = Math.max(0, wait);
        return Math.pow(pheromone, Settings.ALPHA) / (Math.pow(1 / (time + e.getStayTime() + wait), Settings
                .BETA));
    }

    /*public static int route(Scenery a, Scenery b) {
        // 景点a到景点b所花时间
        return traffic[a.getId()][b.getId()];
    }*/

    /*private static final int traffic[][] = {{0, 6, 60, 60}, {60, 0, 60, 30}, {30, 30, 0, 60},
            {60, 30, 60, 0}};*/

    public static class Node {
        SelectedPoint scenery;
        int sceneryIndex;
        int arrivedTime;
        int waitTime;
        int playTime;

        Node(SelectedPoint scenery, int index) {
            this.scenery = scenery;
            this.sceneryIndex = index;
        }

        int leaveTime() {
            return arrivedTime + waitTime + playTime;
        }
    }

    public static class Builder {
        private int id;            //蚂蚁的编号
        private Node[] nodes;  // 蚂蚁经过的景点信息记录
        private int currentScenery;
        private boolean[] flag;  // 蚂蚁是否可以走某个景点
        private int routeTime;  // 蚂蚁总花费时间
        private int waitTime;  // 蚂蚁总等待时间
        private int playTime;  // 蚂蚁游玩时间
        private boolean dead;  // 蚂蚁是否死亡
        private int phe;  // 蚂蚁释放的信息素量，对本算法的性能影响不大

        private Surrounding surrounding;

        public Builder(int n, Surrounding surrounding) {
            this.id = 0;
            nodes = new Node[n + 1];
            currentScenery = -1;
            flag = new boolean[n];
            routeTime = 0;
            waitTime = 0;
            playTime = 0;
            dead = false;
            phe = 100;
            this.surrounding = surrounding;
        }

        /**
         * 设置蚂蚁起点
         *
         * @param s         起始景点，一般为酒店
         * @param i         起始景点索引
         * @param startTime 行程开始时间，也是起始景点到达时间
         * @return 当前实例
         */
        public Builder outset(SelectedPoint s, int i, int startTime) {
            if (i < 0 || i >= flag.length)
                throw new ArrayIndexOutOfBoundsException("起始景点索引超出范围");
            currentScenery = i;
            Node node = new Node(s, i);
            node.arrivedTime = startTime;
            node.waitTime = 0;
            node.playTime = s.getStayTime();
            nodes[0] = node;
            flag[i] = true;
            return this;
        }

        public Ant create() {
            if (currentScenery == -1)
                throw new IllegalArgumentException("当前景点索引超出范围");
            return new Ant(id, nodes, currentScenery, flag, routeTime, waitTime, playTime, dead, phe, surrounding);
        }
    }
}
