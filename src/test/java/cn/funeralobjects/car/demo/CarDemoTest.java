package cn.funeralobjects.car.demo;

import cn.funeralobjects.car.demo.enums.FixedSimpleOrientation;
import cn.funeralobjects.car.demo.model.SimpleCarPosition;
import cn.funeralobjects.car.demo.model.SimpleMap;
import cn.funeralobjects.car.demo.model.SimpleMoveCommand;
import cn.funeralobjects.car.demo.service.SimpleCarMoveServiceImpl;

/**
 * @author FuneralObjects
 * Create date: 2020/6/29 10:47 PM
 */
public class CarDemoTest {
    public static void main(String[] args){

        String positionFormat = "\n\r-车辆位置-\n\rx:%s y:%s\n\r朝向: %s";
        String commandFormat = "\n\r-车辆移动-\n\r%s调整%s个朝向单位 - 移动%s个距离单位";

        //停车场长宽
        Integer parkLength = 10;
        Integer parkWidth = 14;

        //初始化位置
        SimpleCarPosition initialPosition = new SimpleCarPosition()
                .setX(0)
                .setY(0)
                .setOrientation(FixedSimpleOrientation.NORTH);
        //初始化车辆
        SimpleCar car = new SimpleCar(initialPosition, new SimpleCarMoveServiceImpl(),
                new SimpleMap().setX(parkLength).setY(parkWidth));

        System.out.println(String.format(positionFormat,car.getPositionX(),car.getPositionY(), car.getOrientation().name()));

        //移动命令
        SimpleMoveCommand command = new SimpleMoveCommand()
                .setClockwise(true) // 顺时针
                .setStep(1) //转移一个方向
                .setMoveDistance(5); //移动距离

        System.out.println(String.format(commandFormat, command.isClockwise()? "顺时针":"逆时针",command.getStep(), command.getMoveDistance()));
        car.move(command);
        System.out.println(String.format(positionFormat,car.getPositionX(),car.getPositionY(), car.getOrientation().name()));

        command.setClockwise(false).setMoveDistance(6);

        System.out.println(String.format(commandFormat, command.isClockwise()? "顺时针":"逆时针",command.getStep(), command.getMoveDistance()));
        car.move(command);
        System.out.println(String.format(positionFormat,car.getPositionX(),car.getPositionY(), car.getOrientation().name()));


        command.setClockwise(true).setMoveDistance(3);

        System.out.println(String.format(commandFormat, command.isClockwise()? "顺时针":"逆时针",command.getStep(), command.getMoveDistance()));
        car.move(command);
        System.out.println(String.format(positionFormat,car.getPositionX(),car.getPositionY(), car.getOrientation().name()));


        command.setMoveDistance(2);
        System.out.println(String.format(commandFormat, command.isClockwise()? "顺时针":"逆时针",command.getStep(), command.getMoveDistance()));
        car.move(command);
        System.out.println(String.format(positionFormat,car.getPositionX(),car.getPositionY(), car.getOrientation().name()));

        command.setStep(2);
        System.out.println(String.format(commandFormat, command.isClockwise()? "顺时针":"逆时针",command.getStep(), command.getMoveDistance()));
        car.move(command);
        System.out.println(String.format(positionFormat,car.getPositionX(),car.getPositionY(), car.getOrientation().name()));
    }
}
