package com.proyectoJava.sistemagestion.models;

import com.sun.tools.attach.AgentInitializationException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="id")
    @Id
    private Long id;

    @Column (name ="nombre")
    private String nombre;

    @Column (name ="apellido")
    private String apellido;

    @Column (name ="email")
    private String email;

    @Column (name ="telefono")
    private String telefono;

    @Column (name ="password")
    private String password;





}
