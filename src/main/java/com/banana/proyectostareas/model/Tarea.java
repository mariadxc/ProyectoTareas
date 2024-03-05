package com.banana.proyectostareas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Column(name="id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String descripcion;

    @DateTimeFormat
    @NotNull
    private LocalDate fechaLimite;

    @Min(1)
    private Integer orden;

    private boolean completada;

    /*lo añado*/
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;
}
