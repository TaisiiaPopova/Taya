package com.example.demo.controller;

import com.example.demo.controller.dto.Post;
import com.example.demo.exception.UnknownUserException;
import com.example.demo.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@Controller
public class PostWebController {
    private final PostService postService;

    public PostWebController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/users/posts/{userId}")
    public String getPosts(Model model, @PathVariable int userId)
    {
        var posts = postService.getPostsByUserId(userId);
        model.addAttribute("posts", posts);
        return "view-posts";
    }

    @PostMapping("/users/posts/{userId}")
    public String createPost(Model model, @PathVariable int userId, @RequestParam Map<String, String> body)
    {
        try {
            if (body.containsKey("title") && body.containsKey("body")) {
                postService.save(new Post(body.get("title"), body.get("body"), userId));
            }
        } catch (UnknownUserException ex)
        {
            model.addAttribute("errorMessage", "User doesn't exist!");
        }
        finally {
            model.addAttribute("posts", postService.getPostsByUserId(userId));
        }
        return "view-posts";
    }
}
