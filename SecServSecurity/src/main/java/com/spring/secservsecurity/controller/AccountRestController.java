package com.spring.secservsecurity.controller;

import com.spring.secservsecurity.Entity.AppRole;
import com.spring.secservsecurity.Entity.AppUser;
import com.spring.secservsecurity.Entity.RoleUserForm;
import com.spring.secservsecurity.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AccountRestController {

    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/users")
    public List<AppUser> getAll(){
        return accountService.listUsers();
    }

    @PostMapping("/users")
    public AppUser createUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    @PostMapping("/roles")
    public AppRole appRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }

    @PostMapping("/addRoleToUsers")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());

    }

    @GetMapping("/roles")
    public List<AppRole> listRoles() {
        return accountService.listRoles();
    }




}
