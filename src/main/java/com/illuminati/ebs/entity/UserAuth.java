package com.illuminati.ebs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "UserAuth")
@AttributeOverride(name = "id", column = @Column(name = "id_user_auth"))
@Data
public class UserAuth extends Base{
    @Column(name = "auth0_id")
    private String user_id;
    @Column(name = "email")
    private String email;
    @Column(name = "blocked")
    private boolean blocked;
    @OneToOne(mappedBy = "userAuth")
    private Usuario usuario;

}
