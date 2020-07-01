package cn.funeralobjects.car.demo.model;

import cn.funeralobjects.car.demo.SimpleCar;
import cn.funeralobjects.car.demo.enums.FixedSimpleOrientation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 简易移动指令
 * @author FuneralObjects
 * Create date: 2020/6/29 10:03 PM
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class SimpleMoveCommand extends MoveCommand<FixedSimpleOrientation> {

    /**
     * 转向步数
     */
    private int step;
    /**
     * true - 顺时针
     */
    private boolean clockwise;

    private int moveDistance;

    public MoveCommand<FixedSimpleOrientation> getMoveCommand(FixedSimpleOrientation orientation){
        return new MoveCommand<FixedSimpleOrientation>().setDistance(this.moveDistance * SimpleCar.DISTANCE_UNIT).setOrientation(orientation);
    }
}
