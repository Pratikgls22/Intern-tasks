package org.example.openapifeignclient.controller;

import lombok.RequiredArgsConstructor;

import org.example.openapifeignclient.model.ModelApiResponse;
import org.example.openapifeignclient.model.RegisterRequestDTO;
import org.example.openapifeignclient.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/feign")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<ModelApiResponse> register(@RequestBody RegisterRequestDTO registerRequestDTO){
        return this.userService.registerPatients(registerRequestDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<ModelApiResponse> getAll(){
       return this.userService.getAllPatients();
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<ModelApiResponse> getById(@PathVariable("id") Long id){
        return this.userService.getPatientById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ModelApiResponse> update(@PathVariable("id") Long id,@RequestBody RegisterRequestDTO registerRequestDTO){
        return this.userService.updatePatient(id,registerRequestDTO);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ModelApiResponse> delete(@PathVariable("id") Long id){
        return this.userService.deletePatient(id);
    }

}
