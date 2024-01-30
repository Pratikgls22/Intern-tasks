package org.example.unittest_springboot.requestDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class CloudVendorRequestDTO {

    @NotEmpty(message = "Yor name filed is empty, fill it")
    private String name;
    @NotEmpty(message = "your address is empty, fill properly")
    private String address;
    @NotEmpty(message = "phone is null,fill it")
    @Size(min = 10,max = 10, message = "write a phone in proper format, size is 10")
    private String phone;
}
