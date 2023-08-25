package ra.projectmodule4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.projectmodule4.dto.request.FormLoginDTO;
import ra.projectmodule4.dto.request.FormRegisterDTO;
import ra.projectmodule4.dto.request.VideoDTO;
import ra.projectmodule4.model.User;
import ra.projectmodule4.model.Video;
import ra.projectmodule4.service.impl.UserService;
import ra.projectmodule4.service.impl.VideoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login", "login_form", new FormLoginDTO());
    }


    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register", "register_form", new FormRegisterDTO());
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/")
    public String handleLogin(HttpSession session, @ModelAttribute("login_form") FormLoginDTO formLoginDTO, Model model) {

        User user = userService.login(formLoginDTO);
        if (user == null) {
            return "redirect:/login";
        }
        session.setAttribute("userlogin", user);

        return "redirect:/";
    }
    @GetMapping("/")
    public String handleLoginTest( @ModelAttribute("login_form") FormLoginDTO formLoginDTO, Model model) {

//        model.addAttribute("userList", userService.findAll());

        List<VideoDTO> allVideos = new ArrayList<>();
        for (User user1 : userService.findAll()) {
            List<VideoDTO> userVideos = videoService.findAllVideoDTOByUserId(user1.getId());
            allVideos.addAll(userVideos);
        }

        model.addAttribute("allVideo", allVideos);
        return "index";
    }

    @PostMapping("/handle-register")
    public String handleRegister(HttpSession session, @ModelAttribute("register_form") FormRegisterDTO formRegisterDTO) {
        if (userService.register(formRegisterDTO)) {
            userService.saveRegister(formRegisterDTO);
            return "redirect:/login";
        }
        return "redirect:/register";

    }
//
//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }

    @GetMapping("/home")
    public String home() {
        return "redirect:/";
    }

    @GetMapping("/explorer")
    public String explorer() {
        return "explorer";
    }

    @GetMapping("/followers")
    public String followers() {
        return "followers";
    }

    @GetMapping("/following")
    public String following() {
        return "following";
    }

    @GetMapping("/friends")
    public String friends() {
        return "friends";
    }

    @GetMapping("/favorite")
    public String favorite() {
        return "favorite";
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    @GetMapping("/chat_")
    public String chat_() {
        return "chat_";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }

    @GetMapping("/getcoin")
    public String getcoin() {
        return "getcoin";
    }

//    @GetMapping("/myprofile")
//    public String myprofile() {
//        return "myprofile";
//    }

    @GetMapping("/notification")
    public String notification() {
        return "notification";
    }

    @GetMapping("/payment")
    public String payment() {
        return "payment";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/setting")
    public String setting() {
        return "setting";
    }

    @GetMapping("/transaction")
    public String transaction() {
        return "transaction";
    }


}
