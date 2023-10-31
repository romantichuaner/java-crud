package wuhobin.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class goodsUser { //商品类
    private int id; //商品编号
    private String name; //商品名称
    //private String sex;
    //private int age;
    private String password;//商品入库时间，比如：2021/6/18
    //private int phone;
}
