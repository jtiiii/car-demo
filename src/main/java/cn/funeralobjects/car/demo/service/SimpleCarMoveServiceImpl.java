package cn.funeralobjects.car.demo.service;

import cn.funeralobjects.car.demo.enums.FixedSimpleOrientation;
import cn.funeralobjects.car.demo.model.CarPosition;
import cn.funeralobjects.car.demo.model.SimpleCarPosition;
import cn.funeralobjects.car.demo.model.SimpleMap;
import cn.funeralobjects.car.demo.model.SimpleMoveCommand;

/**
 * @author FuneralObjects
 * Create date: 2020/6/29 10:29 PM
 */
public class SimpleCarMoveServiceImpl implements CarMoveService {

    public SimpleCarPosition move(SimpleMoveCommand command, SimpleCarPosition position, SimpleMap map){
        if(command == null){
            throw new IllegalArgumentException("command 不能为null");
        }
        if(position == null){
            throw new IllegalArgumentException("position 不能为Null");
        }
        CarPosition<FixedSimpleOrientation> carPosition = this.move(command.getMoveCommand(FixedSimpleOrientation.turn(position.getCarPosition().getOrientation(),command.isClockwise(),command.getStep())),position.getCarPosition());

        SimpleCarPosition result = new SimpleCarPosition()
                .setOrientation(carPosition.getOrientation())
                .setX((int) carPosition.getX())
                .setY((int) carPosition.getY());
        if(result.getX() < 0 || result.getX() > map.getX() || result.getY() < 0 || result.getY() > map.getY()){
            throw new RuntimeException("车辆无法移动，已超出边界。");
        }
        return result;
    }
}
