package cn.funeralobjects.car.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author FuneralObjects
 * Create date: 2020/6/29 8:02 PM
 */

public interface Orientation {
    /**
     * 度数
     */
    double getDegree();
}
