package cn.funeralobjects.car.demo.service;

import cn.funeralobjects.car.demo.model.CarPosition;
import cn.funeralobjects.car.demo.model.MoveCommand;
import cn.funeralobjects.car.demo.model.Orientation;

/**
 * @author FuneralObjects
 * Create date: 2020/6/29 9:45 PM
 */
public interface CarMoveService {

    /**
     * 移动
     * @param command 移动命令
     * @param carPosition 当前位置
     * @return 移动结束后的位置
     */
    default <T extends Orientation>  CarPosition<T> move(MoveCommand<T> command, CarPosition<T> carPosition){
       double x = command.getDistance() * Math.cos(Math.PI * command.getOrientation().getDegree()/180) + carPosition.getX();
       double y = command.getDistance() * Math.sin(Math.PI * command.getOrientation().getDegree()/180) + carPosition.getY();
       return new CarPosition<T>().setOrientation(command.getOrientation()).setX(x).setY(y);
    }
}
