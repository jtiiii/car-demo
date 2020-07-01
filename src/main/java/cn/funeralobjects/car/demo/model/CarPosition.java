package cn.funeralobjects.car.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author FuneralObjects
 * Create date: 2020/6/29 9:43 PM
 */
@Data
@Accessors(chain = true)
public class CarPosition<T extends Orientation> {
    private double x;
    private double y;
    private T orientation;
}
