package wuhobin.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import wuhobin.pojo.query.goodsUser;
import wuhobin.pojo.query.goodsUserQuery;

import java.util.List;

@Mapper  // 注解告诉springboot这是一个mybatis的mapper类,
// 在resources的mybatis的xml文件里namespace就可以直接使用这个接口
@Repository   // 将接口goodsUserDao交由spring容器管理，后面在service层调用dao层的时候用这两个注解实现注入
public interface goodsUserDao {   //接口用来实现增删改查这些操作
    // 查询所有商品
    public List<goodsUser> listUser(); //返回商品的集合


    // 根据id查询
    public goodsUser queryUserById(int id);


    // 根据商品名来查询  并分页展示，       分页展示这个代码注释了
    //参数用userQuery传进来，UserQuery类实例化的对象里有name属性
    public List<goodsUser> listUserByName(goodsUserQuery userQuery);

    //根据id删除商品
    public int deleteUserById(int id);

    // 修改商品
    public int updateUser(goodsUser user);

    // 新增商品
    public int addUser(goodsUser user);
}

