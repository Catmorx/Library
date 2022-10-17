package com.usa.library.service;

import com.usa.library.model.LibraryModel;
import com.usa.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired //inyeccion de dependecias este se encarga de inicializar el Crud
    private LibraryRepository libraryRepository;

    public List<LibraryModel> getAllLib() {
        return  libraryRepository.getAllLib();// nos devuelve toda la lista del crud almacenado en getAll para llamar

    }

    public Optional<LibraryModel> getLib(Integer id) {
        return libraryRepository.getLib(id);
    }

    public LibraryModel saveLib(LibraryModel libraryModel) {
        return libraryRepository.saveLib(libraryModel);
    }

    public boolean deleteLib(Integer id) {
        try {
            libraryRepository.deleteLib(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public LibraryModel updateLib(LibraryModel libraryModel) {
        if (libraryModel.getId() != null) {
            Optional<LibraryModel> lib = libraryRepository.getLib(libraryModel.getId());
            if (!lib.isEmpty()) {
                if (libraryModel.getName() != null) {
                    lib.get().setName(libraryModel.getName());
                }
                if (libraryModel.getTarget() != null) {
                    lib.get().setTarget(libraryModel.getTarget());
                }
                if (libraryModel.getCapacity() != null) {
                    lib.get().setCapacity(libraryModel.getCapacity());
                }
                if (libraryModel.getDescription() != null) {
                    lib.get().setDescription(libraryModel.getDescription());
                }
                if (libraryModel.getMessages() != null) {
                    lib.get().setMessages(libraryModel.getMessages());
                }
                if (libraryModel.getReservations() != null) {
                    lib.get().setReservations(libraryModel.getReservations());
                }
                libraryRepository.updateLib(lib.get());
                return lib.get();
            } else {
                return libraryModel;
            }
        } else {
            return libraryModel;
        }
    }
}
