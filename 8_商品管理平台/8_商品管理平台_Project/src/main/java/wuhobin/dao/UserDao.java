package wuhobin.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import wuhobin.pojo.User;
import wuhobin.pojo.query.UserQuery;

import java.util.List;

@Mapper  // 注解告诉springboot这是一个mybatis的mapper类,
         // 在resources的mybatis的xml文件里namespace就可以直接使用这个接口
@Repository   // 将接口userdao交由spring容器管理，后面在service层调用dao层的时候用这两个注解实现注入
public interface UserDao {   //接口用来实现增删改查这些操作
    // 查询所有商品
    public List<User> listUser(); //返回商品的集合


    // 根据id查询,返回值是User
    public User queryUserById(int id);


    // 根据商品名来查询  并分页展示，       分页展示这个代码注释了
    //参数用userQuery传进来，UserQuery类实例化的对象里有name属性
    public List<User> listUserByName(UserQuery userQuery);

    //根据id删除商品
    public int deleteUserById(int id);

    // 修改商品
    public int updateUser(User user);

    // 添加商品
    public int addUser(User user);
}

