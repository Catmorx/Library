package com.usa.library.controller;

import com.usa.library.model.AdminModel;
import com.usa.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<AdminModel> getAllUserAdministrators() {
        return adminService.getAllAdmins();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<AdminModel> getAllUserAdministrators2() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Optional<AdminModel> getUserAdministrator(@PathVariable Integer id) {
        return adminService.getAdmin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel saveUserAdministrator(@RequestBody AdminModel adminModel) {
        return adminService.saveAdmin(adminModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUserAdministratorModel(@PathVariable Integer id) {
        adminService.deleteAdmin(id);
        return true;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel updateUserAdministrator(@RequestBody AdminModel adminModel) {
        return adminService.updateAdmin(adminModel);
    }
}
