package com.usa.library.repository.crudrepository;
import com.usa.library.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryModel, Integer> {

}
