package wuhobin.pojo.query; //pojo是实体类

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//交由lombok管理
@Data
@AllArgsConstructor
@NoArgsConstructor
public class goodsUserQuery {  //把要查询的东西都封装到实体类UserQuery里
    //private Integer pageNum = 1;   // 当前的页码
    //private Integer pageSize  = 2;   //每一页所显示的数量
    //private String name;  // 根据商品名查询
    private String goodsName; //根据商品品牌名查询


}
