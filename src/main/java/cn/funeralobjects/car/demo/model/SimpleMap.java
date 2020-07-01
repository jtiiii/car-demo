package cn.funeralobjects.car.demo.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author FuneralObjects
 * Create date: 2020/6/29 10:48 PM
 */
@Data
@Accessors(chain = true)
public class SimpleMap {
    private Integer x;
    private Integer y;
}
