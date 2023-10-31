package wuhobin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wuhobin.dao.UserDao;
import wuhobin.pojo.User;
import wuhobin.pojo.query.UserQuery;

import java.util.List;

@Service   //注解  交由springboot容器管理
public class UserServiceImpl implements UserService{  //实现类，实现dao层的方法
    @Autowired
    private UserDao userDao; //把UserDao层注入
    // 查询所有商品
    @Override
    public List<User> listUser() {  //重写dao层的方法，查询所有用户
        return userDao.listUser(); //返回值是集合，所以用dao层下UserDao类对象的方法
    }

    @Override
    public List<User> listUserByName(UserQuery userQuery) { //通过商品名来查询
       // PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        return userDao.listUserByName(userQuery);
    }
   //根据id删除商品
    @Override
    public boolean deleteUserById(int id) {
        int i = userDao.deleteUserById(id);
        if(i > 0){   //表内数据不能为空
            return true;
        }else {
            return false;
        }
    }
   //根据id查询商品
    @Override
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

   //修改用户
    @Override
    public boolean updateUser(User user) {
        int i = userDao.updateUser(user);
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }
    //添加商品
    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user) > 0 ? true : false ;
    }
}
