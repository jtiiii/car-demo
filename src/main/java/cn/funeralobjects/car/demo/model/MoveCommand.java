package cn.funeralobjects.car.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 移动命令
 * @author FuneralObjects
 * Create date: 2020/6/29 8:00 PM
 */
@Data
@Accessors(chain = true)
public class MoveCommand<T extends Orientation> {
    /**
     * 方向
     */
    private T orientation;
    /**
     * 距离
     */
    private double distance;
}
