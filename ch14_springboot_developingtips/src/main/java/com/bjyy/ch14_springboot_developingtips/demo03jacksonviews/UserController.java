package com.bjyy.ch14_springboot_developingtips.demo03jacksonviews;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aurora
 * @date 2026年01月28日 12:57
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 1️⃣ 列表接口（基础字段）
     */
    @GetMapping
    @JsonView(Views.Base.class)
    public List<User> list() {
        return userService.list();
    }

    /**
     * 2️⃣ 详情接口
     */
    @GetMapping("/{id}")
    @JsonView(Views.Detail.class)
    public User detail(@PathVariable Long id) {
        return userService.getById(id);
    }

    /**
     * 3️⃣ 管理员接口
     */
    @GetMapping("/admin/{id}")
    @JsonView(Views.Admin.class)
    public User adminDetail(@PathVariable Long id) {
        return userService.getById(id);
    }
}