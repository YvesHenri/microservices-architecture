package com.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Data
public class User {

    @Id
    private UUID id;

    @Email
    @Indexed(unique = true)
    private String username;

    @NotBlank
    @Size(min = 8, max = 44)
    private String fullName;

    @NotBlank
    @Size(max = 16)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @DBRef
    private Set<Role> roles;

    @DBRef
    private Set<Scope> scopes;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean enabled;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean verified;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private boolean locked;

}
