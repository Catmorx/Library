package com.usa.library.repository.crudrepository;

import com.usa.library.model.LibraryModel;
import org.springframework.data.repository.CrudRepository;

public interface LibraryCrudRepository extends CrudRepository<LibraryModel, Integer> {
}
