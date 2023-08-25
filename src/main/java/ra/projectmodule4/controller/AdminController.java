package ra.projectmodule4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.projectmodule4.model.User;
import ra.projectmodule4.service.impl.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String admin(HttpSession session, Model model) {
        List<User> userList = userService.findAll();
        System.out.println(userList);// Lấy danh sách người dùng từ service
        model.addAttribute("userList", userList);
        return "admin/user";
    }

    @GetMapping("/category")
    public String category() {
        return "admin/category";
    }

    @GetMapping("/product")
    public String product() {
        return "admin/product";
    }

    @GetMapping("/admin")
    public String user() {
        return "admin/index";
    }

}
