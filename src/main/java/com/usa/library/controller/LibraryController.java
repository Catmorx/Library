package com.usa.library.controller;

import com.usa.library.model.LibraryModel;
import com.usa.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Lib")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class LibraryController {
    @Autowired
    private LibraryService doctorService;

    @GetMapping("/all")
    public List<LibraryModel> getAllLibs() {
        return doctorService.getAllLib();
    }

    @GetMapping("/{id}")
    public Optional<LibraryModel> getLib(@PathVariable Integer id) { //
        return doctorService.getLib(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public LibraryModel saveLib(@RequestBody LibraryModel libraryModel) {
        return doctorService.saveLib(libraryModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteLib(@PathVariable Integer id) {
        doctorService.deleteLib(id);
        return true;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public LibraryModel updateLib(@RequestBody LibraryModel libraryModel) {
        return doctorService.updateLib(libraryModel);
    }
}
