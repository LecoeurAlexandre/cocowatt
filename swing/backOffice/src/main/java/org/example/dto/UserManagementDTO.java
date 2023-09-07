package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserManagementDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private boolean isAdmin;
}
