package com.mukho.ranksystem.Controller;

import com.mukho.ranksystem.Dto.UserInfoDto;
import com.mukho.ranksystem.Dto.Projection.UserInfoProjection;
import com.mukho.ranksystem.Service.UserService;
import com.mukho.ranksystem.Utils.LogUtil;
import com.mukho.ranksystem.Utils.TimeUtil;
import org.slf4j.Logger;
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

            permission = switch (permission) {
                case "" -> "일반 사용자";
                case "special" -> "관리자";
                case "master" -> "운영자";
                default -> info.getPermission();
            };

            TimeUtil logTime = TimeUtil.getInstance();
            Logger logger = LogUtil.getInstance();

            logger.info(logTime.getLogTime() + id + "(" + name + ")의 권한 변경(" + permission + ")");
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
