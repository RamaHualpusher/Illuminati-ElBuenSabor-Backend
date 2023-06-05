//package com.illuminati.ebs.service;
//
//import com.auth0.client.HttpOptions;
//import com.auth0.client.mgmt.ManagementAPI;
//import com.auth0.json.mgmt.Role;
//import com.auth0.json.mgmt.RolesPage;
//import com.auth0.json.mgmt.userblocks.UserBlocks;
//import com.auth0.json.mgmt.users.User;
//import com.auth0.net.Request;
//import com.illuminati.ebs.dto.RolDto;
//import com.illuminati.ebs.dto.UserAuthDto;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService {
//
//    @Value("${auth0.domain}")
//    private String domain;
//    @Value("${auth0.clientId}")
//    private String clientId;
//    @Value("${auth0.clientSecret}")
//    private String clientSecret;
//
//    private ManagementAPI managementAPI;
//    @PostConstruct
//    public void init() {
//        this.managementAPI = new ManagementAPI(domain, clientSecret);
//
//    }
//
//
//    public UserAuthDto createUser(UserAuthDto user) {
//        try {
//            User auth0User = new User();
//            auth0User.setEmail(user.getEmail());
//            auth0User.setPassword(user.getPassword());
//            auth0User.setConnection(user.getConnection());
//            Request<User> request = managementAPI.users().create(auth0User);
//            User createdUser = request.execute();
//            user.setAuth0UserId(createdUser.getId());
//            user.setAuth0Email(createdUser.getEmail());
//            user.setEmailVerified(createdUser.isEmailVerified());
//            return user;
//        } catch (Exception e) {
//            // Handle exception
//        }
//        return null;
//    }
//
//    public UserAuthDto getUser(String userId) {
//        try {
//            Request<User> request = managementAPI.users().get(userId, null);
//            User user = request.execute();
//            UserAuthDto userAuthDto = new UserAuthDto();
//            userAuthDto.setAuth0UserId(user.getId());
//            userAuthDto.setAuth0Email(user.getEmail());
//            return userAuthDto;
//        } catch (Exception e) {
//            // Handle exception
//        }
//        return null;
//    }
//
//    public List<RolDto> getRoles(String userId) {
//        try {
//            Request<RolesPage> request = managementAPI.users().listRoles(userId, null);
//            RolesPage rolesPage = request.execute();
//            List<Role> roles = rolesPage.getItems();
//            return roles.stream().map(role -> {
//                RolDto rolDto = new RolDto();
//                rolDto.setAuth0RoleId(role.getId());
//                rolDto.setNombreRol(role.getName());
//                rolDto.setDescription(role.getDescription());
//                return rolDto;
//            }).collect(Collectors.toList());
//        } catch (Exception e) {
//            // Handle exception
//        }
//        return null;
//    }
//
//    public RolDto createRole(RolDto role) {
//        try {
//            Role auth0Role = new Role();
//            auth0Role.setName(role.getNombreRol());
//            auth0Role.setDescription(role.getDescription());
//            Request<Role> request = managementAPI.roles().create(auth0Role);
//            Role createdRole = request.execute();
//            role.setAuth0RoleId(createdRole.getId());
//            return role;
//        } catch (Exception e) {
//            // Handle exception
//        }
//        return null;
//    }
//
//    public RolDto getRole(String roleId) {
//        try {
//            Request<Role> request = managementAPI.roles().get(roleId);
//            Role role = request.execute();
//            RolDto rolDto = new RolDto();
//            rolDto.setAuth0RoleId(role.getId());
//            rolDto.setNombreRol(role.getName());
//            rolDto.setDescription(role.getDescription());
//            return rolDto;
//        } catch (Exception e) {
//            // Handle exception
//        }
//        return null;
//    }
//
//    public UserAuthDto addRole(String userId, RolDto role) {
//        try {
//            Request request = managementAPI.users().addRoles(userId, Collections.singletonList(role.getAuth0RoleId()));
//            request.execute();
//            return getUser(userId);
//        } catch (Exception e) {
//            // Handle exception
//        }
//        return null;
//    }
//
//    public UserBlocks getBlocks(String userId) {
//        try {
//            Request<UserBlocks> request = managementAPI.userBlocks().get(userId);
//            return request.execute();
//        } catch (Exception e) {
//            // Handle exception
//        }
//        return null;
//    }
//
//    public void unblockUser(String userId) {
//        try {
//            Request request = managementAPI.userBlocks().delete(userId);
//            request.execute();
//        } catch (Exception e) {
//            // Handle exception
//        }
//    }
//}
//
