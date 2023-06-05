//package com.illuminati.ebs.controller;
//
//import com.auth0.json.mgmt.userblocks.UserBlocks;
//import com.illuminati.ebs.dto.RolDto;
//import com.illuminati.ebs.dto.UserAuthDto;
//import com.illuminati.ebs.service.UserService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/public/user/auth")
//public class UserAuthController {
//
//    private final UserService userService;
//
//    public UserAuthController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public ResponseEntity<UserAuthDto> createUser(@RequestBody UserAuthDto user) {
//        UserAuthDto createdUser = userService.createUser(user);
//        return ResponseEntity.ok(createdUser);
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<UserAuthDto> getUser(@PathVariable String userId) {
//        UserAuthDto user = userService.getUser(userId);
//        return ResponseEntity.ok(user);
//    }
//
//    @GetMapping("/{userId}/roles")
//    public ResponseEntity<List<RolDto>> getRoles(@PathVariable String userId) {
//        List<RolDto> roles = userService.getRoles(userId);
//        return ResponseEntity.ok(roles);
//    }
//
//    @PostMapping("/{userId}/roles")
//    public ResponseEntity<UserAuthDto> addRole(@PathVariable String userId, @RequestBody RolDto role) {
//        UserAuthDto addedRole = userService.addRole(userId, role);
//        return ResponseEntity.ok(addedRole);
//    }
//
//    @GetMapping("/{userId}/blocks")
//    public ResponseEntity<UserBlocks> getBlocks(@PathVariable String userId) {
//        UserBlocks blocks = userService.getBlocks(userId);
//        return ResponseEntity.ok(blocks);
//    }
//
//    @DeleteMapping("/{userId}/blocks")
//    public ResponseEntity<Void> unblockUser(@PathVariable String userId) {
//        userService.unblockUser(userId);
//        return ResponseEntity.ok().build();
//    }
//}
