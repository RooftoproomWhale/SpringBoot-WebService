package com.geonung.spring.boot.web;

import com.geonung.spring.boot.config.auth.LoginUser;
import com.geonung.spring.boot.config.auth.dto.SessionUser;
import com.geonung.spring.boot.service.posts.PostsService;
import com.geonung.spring.boot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user)
    {
        model.addAttribute("posts",postsService.findAllDesc());

        if(user != null)
        {
            model.addAttribute("loginUserName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave()
    {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String index(@PathVariable Long id, Model model)
    {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
