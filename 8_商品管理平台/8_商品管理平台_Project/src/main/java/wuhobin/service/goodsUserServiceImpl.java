package wuhobin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wuhobin.dao.UserDao;
import wuhobin.dao.goodsUserDao;
import wuhobin.pojo.User;
import wuhobin.pojo.query.UserQuery;
import wuhobin.pojo.query.goodsUser;
import wuhobin.pojo.query.goodsUserQuery;

import java.util.List;

@Service   //注解  交由springboot容器管理
public class goodsUserServiceImpl implements goodsUserService{
    @Autowired
    private goodsUserDao goodsUserDao; //把UserDao层注入

    @Override
    public List<goodsUser> listUser() {  //重写dao层的方法，查询所有用户
        return goodsUserDao.listUser(); //返回值是集合，所以用dao层下UserDao类对象的方法
    }

    @Override
    public List<goodsUser> listUserByName(goodsUserQuery userQuery) { //通过商品名来查询
        // PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        return goodsUserDao.listUserByName(userQuery);
    }

    @Override
    public boolean deleteUserById(int id) {
        int i = goodsUserDao.deleteUserById(id);
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public goodsUser queryUserById(int id) {
        return goodsUserDao.queryUserById(id);
    }


    @Override
    public boolean updateUser(goodsUser user) {
        int i = goodsUserDao.updateUser(user);
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addUser(goodsUser user) {
        return goodsUserDao.addUser(user) > 0 ? true : false ;
    }





}
