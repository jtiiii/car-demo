package cn.funeralobjects.car.demo;

import cn.funeralobjects.car.demo.model.MoveCommand;
import cn.funeralobjects.car.demo.model.Orientation;

/**
 * @author FuneralObjects
 * Create date: 2020/6/29 7:56 PM
 */
public interface Car<T extends Orientation, M extends MoveCommand<T>> {
    void move(M moveCommand);
    int getPositionX();
    int getPositionY();
    T getOrientation();
}