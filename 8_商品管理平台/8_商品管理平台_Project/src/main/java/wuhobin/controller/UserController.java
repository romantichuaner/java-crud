package wuhobin.controller;
//import com.github.pagehelper.PageInfo;
//import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wuhobin.pojo.User;
import wuhobin.pojo.query.UserQuery;
import wuhobin.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService; //注入service层

    @GetMapping("/") //路径
    public String index(Model model, UserQuery userQuery){
        model.addAttribute("list",userService.listUserByName(userQuery));
        return "index"; //返回index.html,因为springboot已经自动设置好了视图管理器
    }

    @PostMapping("/")
    public String listUserByName(Model model,UserQuery userQuery){
        model.addAttribute("list",userService.listUserByName(userQuery));
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes attributes){
        boolean b = userService.deleteUserById(id); //删除
        if(b){
            attributes.addFlashAttribute("message","商品出库成功");
            return "redirect:/";
        }else {
            attributes.addFlashAttribute("message","商品出库失败");
            return "redirect:/";
        }
    }


    @GetMapping("/edit/{id}")  //修改
   public String toEdit(@PathVariable int id,Model model){ //把根据id查询到的商品放到Model里
        model.addAttribute("user",userService.queryUserById(id));
        return "editUser"; //返回到前端取值
   }


   @PostMapping("/edit")
   public String edit(User user,RedirectAttributes attributes){
       //UserQuery userQuery = new UserQuery();
       boolean b = userService.updateUser(user);
       //Integer id = user.getId();
       if (b){
           //boolean b1 = userService.addUser(user);
           attributes.addFlashAttribute("message","商品修改成功");
           return "redirect:/";//如果提交成功，就重映像到这个页面，把所有的用户返回过来
       }else {
           //boolean b1 = userService.updateUser(user);
           attributes.addFlashAttribute("message","商品修改失败");
           b = userService.addUser(user);
           if(b)
           {
               attributes.addFlashAttribute("message","商品添加成功");
           }
       }
       return "redirect:/";
       //return "index";
   }



   @GetMapping("/update")  //当点到添加时，会跳转到添加页面
   public String toUpdate(Model model){
       User user = new User();
       model.addAttribute("user",user);
       return "editUser";
   }

}
