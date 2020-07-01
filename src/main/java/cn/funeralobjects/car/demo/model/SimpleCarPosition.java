package cn.funeralobjects.car.demo.model;

import cn.funeralobjects.car.demo.enums.FixedSimpleOrientation;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author FuneralObjects
 * Create date: 2020/6/29 10:20 PM
 */
@Data
@Accessors(chain = true)
public class SimpleCarPosition {
    private FixedSimpleOrientation orientation;
    private int x;
    private int y;


    public CarPosition<FixedSimpleOrientation> getCarPosition(){
        return new CarPosition<FixedSimpleOrientation>().setX(x).setY(y).setOrientation(orientation);
    }
}
