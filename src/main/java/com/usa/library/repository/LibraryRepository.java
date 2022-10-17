package com.usa.library.repository;

import com.usa.library.model.LibraryModel;
import com.usa.library.repository.crudrepository.LibraryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LibraryRepository {

    @Autowired //inyeccion de dependecias este se encarga de inicializar el Crud
    private LibraryCrudRepository libraryCrudRepository;

    public List<LibraryModel> getAllLib() {
        return (List<LibraryModel>) libraryCrudRepository.findAll();// nos devuelve toda la lista del crud almacenado en getAll para llamar

    }

    public Optional<LibraryModel> getLib(Integer id) {
        return libraryCrudRepository.findById(id);
    }

    public LibraryModel saveLib(LibraryModel doctorModel) {
        return libraryCrudRepository.save(doctorModel);
    }

    public void updateLib(LibraryModel libraryModel){
        libraryCrudRepository.save(libraryModel);
    }
    public void deleteLib(Integer id){
        libraryCrudRepository.deleteById(id);
    }

}

