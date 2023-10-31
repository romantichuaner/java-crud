package wuhobin.controller;
//import com.github.pagehelper.PageInfo;
//import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wuhobin.pojo.User;
import wuhobin.pojo.query.UserQuery;
import wuhobin.pojo.query.goodsUser;
import wuhobin.pojo.query.goodsUserQuery;
import wuhobin.service.UserService;
import wuhobin.service.goodsUserService;

@Controller
@RequestMapping("/goods")
public class goodsUserController {
    @Autowired
    private goodsUserService goodsUserService; //注入service层

    @GetMapping("/") //路径
    public String index(Model model, goodsUserQuery userQuery){
        model.addAttribute("list",goodsUserService.listUserByName(userQuery));
        return "goodsindex"; //返回index.html,因为springboot已经自动设置好了视图管理器
    }


    @PostMapping("/")
    public String listUserByName(Model model,goodsUserQuery userQuery){
        model.addAttribute("list",goodsUserService.listUserByName(userQuery));
        return "goodsindex";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes attributes){
        boolean b = goodsUserService.deleteUserById(id); //删除
        if(b){
            attributes.addFlashAttribute("message","商品出库成功");
            return "redirect:/";
        }else {
            attributes.addFlashAttribute("message","商品出库失败");
            return "redirect:/";
        }
    }


    @GetMapping("/edit/{id}")
    public String toEdit(@PathVariable int id,Model model){
        goodsUser goodsUser = goodsUserService.queryUserById(id);
        System.out.println(goodsUser);
        model.addAttribute("goodsuser",goodsUser);
        return "goodseditUser";
    }


    @PostMapping("/edit")//修改和添加
    public String edit(goodsUser user,RedirectAttributes attributes){
        //UserQuery userQuery = new UserQuery();
        boolean b1 = goodsUserService.updateUser(user);
        //Integer id = user.getId();
        if (b1){
            //boolean b1 = userService.addUser(user);
            attributes.addFlashAttribute("message","商品修改成功");
            return "redirect:/";//如果提交成功，就重映像到这个页面，把所有的用户返回过来
        }else {
            //boolean b1 = userService.updateUser(user);
            attributes.addFlashAttribute("message","商品修改失败");
            b1 = goodsUserService.addUser(user);
            if(b1)
            {
                attributes.addFlashAttribute("message","商品添加成功");
            }
        }
        return "redirect:/";
        //return "index";
    }

    @GetMapping("/update")  //修改
    public String toUpdate(Model model){
        goodsUser user = new goodsUser();
        model.addAttribute("goodsuser",user);
        return "goodseditUser";
    }


}
