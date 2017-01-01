package com.zju.iot.antalg;

import com.zju.iot.common.utils.ParseUtil;
import com.zju.iot.entity.Route;
import com.zju.iot.entity.SelectedPoint;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 环境
 *
 * @author Thea (theazhu0321@gmail.com)
 */
public class Surrounding {
    private double rho = 0.5;  // 0<rho<1,表示路径上信息素的衰减系数（亦称挥发系数、蒸发系数），1-rho表示信息素的持久性系数
    private int n;
    private double[][] pheromones;        //保存所有外激素的列表
    private List<SelectedPoint> points;
    private Map<String, Route> routes;

    public Surrounding(List<SelectedPoint> points, Map<String, Route> routes) {
        this.n = points.size();
        this.points = points;
        this.routes = routes;
        pheromones = new double[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(pheromones[i], 1);
    }

    public double[] getPheromones(int index) {
        return pheromones[index];
    }

    public void updatePheromones(Ant[] ants) {
        double deltaPheromone[][] = new double[n][n];
        for (Ant ant : ants) {
            if (ant.isDead())
                continue;
            Ant.Node[] nodes = ant.getNodes();
            double p = ant.getPheromone();
            for (int j = 0; j < n - 1; j++)
                deltaPheromone[nodes[j].sceneryIndex][nodes[j + 1].sceneryIndex] += p;
            deltaPheromone[nodes[n - 1].sceneryIndex][nodes[0].sceneryIndex] += p;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pheromones[i][j] = (1 - rho) * pheromones[i][j] + deltaPheromone[i][j];
            }
        }
    }

    public List<SelectedPoint> getPoints() {
        return points;
    }

    public SelectedPoint getPoint(int index) {
        return points.get(index);
    }

    public int getPointCount() {
        return n;
    }

    public Map<String, Route> getRoutes() {
        return routes;
    }

    public int getDuration(SelectedPoint p1, SelectedPoint p2) {
        Route route = routes.get(ParseUtil.getRouteKey(p1.getMark(), p2.getMark()));
        if (route == null)
            return Integer.MAX_VALUE;
        return route.getDuration();
    }
}
