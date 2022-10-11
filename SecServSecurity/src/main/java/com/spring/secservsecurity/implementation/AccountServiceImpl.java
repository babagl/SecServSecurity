package com.spring.secservsecurity.implementation;

import com.spring.secservsecurity.Entity.AppRole;
import com.spring.secservsecurity.Entity.AppUser;
import com.spring.secservsecurity.repo.AppRoleRepo;
import com.spring.secservsecurity.repo.AppUserRepo;
import com.spring.secservsecurity.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepo appUserRepo;
    private AppRoleRepo appRoleRepo;

    public AccountServiceImpl(AppUserRepo appUserRepo, AppRoleRepo appRoleRepo) {
        this.appUserRepo = appUserRepo;
        this.appRoleRepo = appRoleRepo;
    }


    @Override
    public AppUser addNewUser(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepo.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepo.findByUsername(username);
        AppRole appRole = appRoleRepo.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return appUserRepo.findAll();
    }
}
