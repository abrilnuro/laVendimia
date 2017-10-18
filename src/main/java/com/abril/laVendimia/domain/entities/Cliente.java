package com.abril.laVendimia.domain.entities;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@Table(name = "clientes")
@DynamicInsert
@DynamicUpdate
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String nombre;
    String apellidoPat;
    String apellidoMat;
}
