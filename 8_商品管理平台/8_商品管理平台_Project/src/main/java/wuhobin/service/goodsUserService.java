package wuhobin.service;

//import com.github.pagehelper.PageInfo;
import wuhobin.pojo.User;
import wuhobin.pojo.query.UserQuery;
import wuhobin.pojo.query.goodsUser;
import wuhobin.pojo.query.goodsUserQuery;

import java.util.List;

public interface goodsUserService {  //和dao层的方法一样的
    // 查询所有用户
    public List<goodsUser> listUser();


    // 根据用户名来查询用户  并分页展示
    public List<goodsUser> listUserByName(goodsUserQuery userQuery);

    //根据id删除用户
    public boolean deleteUserById(int id);

    // 根据id查询用户
    public goodsUser queryUserById(int id);

    // 修改用户
    public boolean updateUser(goodsUser user);

    // 新增用户
    public boolean addUser(goodsUser user);

}
