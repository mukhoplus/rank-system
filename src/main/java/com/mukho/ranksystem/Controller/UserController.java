package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Dto.UserInfoDto;
import com.mukho.ranksystem.Projection.UserInfoProjection;
import com.mukho.ranksystem.Service.UserService;
import com.mukho.ranksystem.Utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserInfoProjection>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserInfoDto info) {
        if (userService.updateUser(info) == 1) {
            String id = info.getId();
            String name = info.getName();
            String permission = info.getPermission();

            if (permission.equals("")) permission = "일반 사용자";
            else if(permission.equals("special")) permission = "관리자";
            else if(permission.equals("master")) permission = "운영자";

            TimeUtil logTime = TimeUtil.getInstance();
            System.out.println(logTime.getLogTime() + id + "(" + name + ")의 권한 변경(" + permission + ")");
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
