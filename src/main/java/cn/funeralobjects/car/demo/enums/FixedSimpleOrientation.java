package cn.funeralobjects.car.demo.enums;

import cn.funeralobjects.car.demo.model.Orientation;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * 固定方向
 * @author FuneralObjects
 * Create date: 2020/6/29 8:01 PM
 */
public enum FixedSimpleOrientation implements Orientation {
    /**
     * 东
     */
    EAST(0D),
    /**
     * 北
     */
    NORTH(90D),
    /**
     * 西
     */
    WEST(180D),
    /**
     * 南
     */
    SOUTH(270D);
    /**
     * 方向对象
     */
    private final double degree;
    /**
     * 逆时针方向顺序
     */
    private final static List<FixedSimpleOrientation> LIST;
    /**
     * 已逆时针方向顺序的LIST位置
     */
    private final static ConcurrentMap<FixedSimpleOrientation, Integer> NODE_INDEX;

    static{
        NODE_INDEX = new ConcurrentHashMap<>(FixedSimpleOrientation.values().length);
        LIST = Arrays.stream(FixedSimpleOrientation.values())
                .sorted( (o1,o2) -> (int) (o1.getDegree() - o2.getDegree()))
                .collect(Collectors.toList());

        for (int i = 0; i < LIST.size(); i++) {
            NODE_INDEX.put(LIST.get(i),i);
        }

    }

    FixedSimpleOrientation(double degree) {
        this.degree = degree;
    }

    /**
     * 转向（默认1步）
     * @param fixedOrientation 转向前方向
     * @param clockwise true - 顺时针，false - 时针
     * @return 最后方向
     */
    public static FixedSimpleOrientation turn(FixedSimpleOrientation fixedOrientation, boolean clockwise){
        return turn(fixedOrientation, clockwise, 1);

    }

    /**
     * 转向
     * @param fixedOrientation 转向前方向
     * @param clockwise true - 顺时针，false - 时针
     * @param step 转向步数
     * @return 最后方向
     */
    public static FixedSimpleOrientation turn(FixedSimpleOrientation fixedOrientation, boolean clockwise, int step){
        if(fixedOrientation == null){
            return null;
        }
        if(step < 0){
            throw new IllegalArgumentException("step不能小于0");
        }
        if(step == 0){
            return fixedOrientation;
        }
        int index = NODE_INDEX.get(fixedOrientation);
        step = step % LIST.size();
        index = clockwise
                ? LIST.size() + index - step
                : index + step;
        index = index % LIST.size();
        return LIST.get(index);
    }

    @Override
    public double getDegree() {
        return degree;
    }
}
