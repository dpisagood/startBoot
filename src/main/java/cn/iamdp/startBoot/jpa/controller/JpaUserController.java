package cn.iamdp.startBoot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.iamdp.startBoot.jpa.entity.User;
import cn.iamdp.startBoot.jpa.server.JpaUserServerInter;

@Controller
public class JpaUserController {

	@Autowired
	private JpaUserServerInter userServer;
	
	

    @RequestMapping("/jpa/list")
    public String list(Model model) {
        List<User> users=userServer.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userServer.save(user);
        return "redirect:/jpa/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,String id) {
        User user=userServer.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userServer.edit(user);
        return "redirect:/jpa/list";
    }


    @RequestMapping("/delete")
    public String delete(String id) {
        userServer.delete(id);
        return "redirect:/jpa/list";
    }
}
