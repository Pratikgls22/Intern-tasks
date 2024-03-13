package org.example.openapifeignclient.service;


import org.example.openapifeignclient.exception.CustomException;
import lombok.RequiredArgsConstructor;

import org.example.openapifeignclient.feign.BackedService;
import org.example.openapifeignclient.model.ModelApiResponse;
import org.example.openapifeignclient.model.RegisterRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final BackedService backedService;

    @Override
    public ResponseEntity<ModelApiResponse> getAllPatients() {
        try {
            ResponseEntity<ModelApiResponse> allPatients = this.backedService.getAllPatients();
            System.out.println("allPatients.getBody().getData() = " + allPatients.getBody().getData());
            return allPatients;
        }catch (CustomException e){
            throw new CustomException(e.getMessage(),e.getHttpStatus());
        }
    }

    @Override
    public ResponseEntity<ModelApiResponse> getPatientById(Long id) {
        ResponseEntity<ModelApiResponse> patientById = this.backedService.getPatientById(id);
        System.out.println("patientById = " + patientById);
        return patientById;
    }

    @Override
    public ResponseEntity<ModelApiResponse> updatePatient(Long id, RegisterRequestDTO registerRequestDTO) {
        ResponseEntity<ModelApiResponse> updatePatient = this.backedService.updatePatient(id, registerRequestDTO);
        System.out.println("updatePatient = " + updatePatient);
        return updatePatient;
    }

    @Override
    public ResponseEntity<ModelApiResponse> registerPatients(RegisterRequestDTO registerRequestDTO) {
        ResponseEntity<ModelApiResponse> registerPatient = this.backedService.registerPatient(registerRequestDTO);
        System.out.println("registerPatient = " + registerPatient);
        return registerPatient;
    }

    @Override
    public ResponseEntity<ModelApiResponse> deletePatient(Long id) {
        ResponseEntity<ModelApiResponse> deletePatient = this.backedService.deletePatient(id);
        System.out.println("deletePatient = " + deletePatient);
        return deletePatient;
    }

}

