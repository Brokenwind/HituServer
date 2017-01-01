package com.zju.iot.antalg;

/**
 * 基本设置
 *
 * @author Thea (theazhu0321@gmail.com)
 */
public class Settings {
    public static final int WIDTH = 100;
    public static final int HEIGHT = 100;

    public static final int MIN_QUANTITY_OF_ANT = 11;
    public static final int MAX_ITERATIONS = 100;

    public static final double ALPHA = 1;  // 蚂蚁在运动过程中信息素在蚂蚁选择路径时的相对重要程度，alpha过大时，算法迭代到一定代数后将出现停滞现象
    public static final double BETA = 5;  // 启发式因子在蚂蚁选择路径时的相对重要程度

}
