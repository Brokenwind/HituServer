package com.zju.iot.service;

import com.zju.iot.antalg.Ant;
import com.zju.iot.antalg.AntComparator;
import com.zju.iot.antalg.Surrounding;
import com.zju.iot.common.Message;
import com.zju.iot.common.Status;
import com.zju.iot.entity.Route;
import com.zju.iot.entity.SelectedPoint;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static com.zju.iot.antalg.Settings.MAX_ITERATIONS;
import static com.zju.iot.antalg.Settings.MIN_QUANTITY_OF_ANT;

/**
 * Created by amei on 16-12-25.
 */
@Component
public class CalculateService {
    @Inject
    private RouteService routeService;
    @Inject
    private SelectedPointService pointService;

    private Message message = new Message();

    /**
     * 规划算法调用处
     *
     * @param planID
     * @return
     */
    public Message programme(String planID) {
        ArrayList<SelectedPoint> points = pointService.getPointsByPlanID(planID);
        HashMap<String, Route> routes = routeService.getRoutesByPoints(points);
        for (SelectedPoint point : points)
            System.out.println(point.toString());
        for (Route route : routes.values())
            System.out.println(route.toString());
        if (points.isEmpty() || routes.isEmpty()) {
            message.setMessage(Status.ILLEGAL_PARAMS);
            return message;
        }
        // 景点个数
        int n = points.size();
        // 蚁群中蚂蚁的数量，当m接近或等于景点个数n时，本算法可以在最少的迭代次数内找到最优解
        int m = Math.max(n, MIN_QUANTITY_OF_ANT);

        // 初始化环境
        Surrounding surrounding = new Surrounding(points, routes);

        // 各次循环的最优路径
        Ant.Node routeBest[][] = new Ant.Node[MAX_ITERATIONS][n];
        // 各次循环的最优路径花费的时间
        int timeBest[] = new int[MAX_ITERATIONS];
        int allDeadCount = 0;
        int counter = 0;  // 循环计数器
        // 开始循环
        while (counter < MAX_ITERATIONS) {
            // 蚂蚁数组
            Ant[] ants = new Ant[m];
            int deadCount = 0;
            for (int i = 0; i < m; i++) {
                ants[i] = new Ant.Builder(n, surrounding).outset(points.get(0), 0, 420).create();
            }

            // 路径循环
            for (int i = 1; i < n - 1; i++) {
                for (int j = 0; j < m; j++) {
                    Ant ant = ants[j];
                    if (!ant.isDead()) {
                        ant.move(i, surrounding.getPheromones(ant.getCurrentScenery()));
                        if (ant.isDead())
                            deadCount++;
                    }
                }
            }

            // 记录最优路径
            Comparator<Ant> comparator = new AntComparator();
            Ant minAnt = ants[0];
            for (int i = 1; i < m; i++) {
                if (comparator.compare(ants[i], minAnt) > 0)
                    minAnt = ants[i];
            }
            timeBest[counter] = minAnt.isDead() ? Integer.MAX_VALUE : minAnt.getRouteTime();
            routeBest[counter] = minAnt.getNodes();

            // 更新信息素
            surrounding.updatePheromones(ants);

            // 判断本次迭代蚂蚁是否都死亡
            if (deadCount == m)
                allDeadCount++;

            counter++;
        }

        if (allDeadCount == MAX_ITERATIONS) {
            System.out.println("找不到最短路径");
            message.setMessage(Status.NO_RESULT);
            return message;
        }

        double min = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            if (min > timeBest[i]) {
                min = timeBest[i];
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("找不到最短路径");
            message.setMessage(Status.NO_RESULT);
            return message;
        }
        System.out.print("最短路径： ");
        List<Route> result = new ArrayList<Route>();
        for (int i = 0; i < n - 1; i++) {
            System.out.print(routeBest[index][i].getSceneryIndex() + " ");
            Route route = surrounding.getRoute(routeBest[index][i].getScenery(), routeBest[index][i + 1].getScenery());
            if (route != null)
                result.add(route);
            else {
                System.out.println("此路不通");
                message.setMessage(Status.NO_RESULT);
                return message;
            }
        }
        message.setMessage(Status.RETURN_OK);
        message.setResult(result);
        System.out.println("");
        System.out.print("最短路径时间： " + timeBest[index]);
        return message;
    }

}
