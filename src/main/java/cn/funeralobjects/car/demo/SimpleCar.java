package cn.funeralobjects.car.demo;

import cn.funeralobjects.car.demo.enums.FixedSimpleOrientation;
import cn.funeralobjects.car.demo.model.*;
import cn.funeralobjects.car.demo.service.SimpleCarMoveServiceImpl;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author FuneralObjects
 * Create date: 2020/6/29 9:44 PM
 */
@Data
@Accessors(chain = true)
public class SimpleCar implements Car<FixedSimpleOrientation, SimpleMoveCommand> {

    public static final double DISTANCE_UNIT = 1;

    private SimpleCarPosition position;
    private SimpleCarMoveServiceImpl carMoveService;
    private SimpleMap map;

    public SimpleCar(SimpleCarPosition position, SimpleCarMoveServiceImpl carMoveService, SimpleMap map) {
        this.position = position;
        this.carMoveService = carMoveService;
        this.map = map;
    }
    @Override
    public void move(SimpleMoveCommand moveCommand) {
        position = carMoveService.move(moveCommand, this.position, this.map);

    }

    @Override
    public int getPositionX() {
        return position.getX();
    }

    @Override
    public int getPositionY() {
        return position.getY();
    }

    @Override
    public FixedSimpleOrientation getOrientation() {
        return position.getOrientation();
    }

}
