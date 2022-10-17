package com.usa.library.service;

import com.usa.library.model.AdminModel;
import com.usa.library.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminModel> getAllAdmins() {
        return adminRepository.getAllAdmins();
    }

    public Optional<AdminModel> getAdmin(Integer id) {
        return adminRepository.getAdmin(id);
    }

    public AdminModel saveAdmin(AdminModel adminModel) {
        return adminRepository.saveAdmin(adminModel);
    }

    public boolean deleteAdmin(Integer id) {
        try {
            adminRepository.deleteAdmin(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public AdminModel updateAdmin(AdminModel adminModel) {
        if (adminModel.getId() != null) {
            Optional<AdminModel> admin = adminRepository.getAdmin(adminModel.getId());
            if (!admin.isEmpty()) {
                if (adminModel.getName() != null) {
                    admin.get().setName(adminModel.getName());
                }
                if (adminModel.getEmail() != null) {
                    admin.get().setEmail(adminModel.getEmail());
                }
                if (adminModel.getPassword() != null) {
                    admin.get().setPassword(adminModel.getPassword());
                }
                adminRepository.updateAdmin(admin.get());
                return admin.get();
            } else {
                return adminModel;
            }
        } else {
            return adminModel;
        }
    }
}
