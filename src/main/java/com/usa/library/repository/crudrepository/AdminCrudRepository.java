package com.usa.library.repository.crudrepository;


import com.usa.library.model.AdminModel;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<AdminModel, Integer> {
}
