package org.example.openapifeignclient.service;


import org.example.openapifeignclient.dto.UserResponseDTO;
import org.example.openapifeignclient.model.ModelApiResponse;
import org.example.openapifeignclient.model.RegisterRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserService {
    ResponseEntity<ModelApiResponse> getAllPatients();

    ResponseEntity<ModelApiResponse> getPatientById(Long id);

    ResponseEntity<ModelApiResponse> updatePatient(Long id, RegisterRequestDTO registerRequestDTO);

    ResponseEntity<ModelApiResponse> registerPatients(RegisterRequestDTO registerRequestDTO);

    ResponseEntity<ModelApiResponse> deletePatient(Long id);
}
