package com.selva.securityjwt.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.selva.securityjwt.model.Client}
 */
public class ClientDTO implements Serializable {
    private final Integer id;
    @NotNull
    @Size(max = 100)
    private final String clientName;
    @NotNull
    @Size(max = 100)
    @Email
    private final String contactEmail;

    public ClientDTO(Integer id, String clientName, String contactEmail) {
        this.id = id;
        this.clientName = clientName;
        this.contactEmail = contactEmail;
    }

    public Integer getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO entity = (ClientDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.clientName, entity.clientName) &&
                Objects.equals(this.contactEmail, entity.contactEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientName, contactEmail);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "clientName = " + clientName + ", " +
                "contactEmail = " + contactEmail + ")";
    }
}