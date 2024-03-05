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
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "proyectos")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    private String nombre;

    @DateTimeFormat
    @NotNull
    private LocalDate fechaCreacion;

    /*lo añado*/
    @JsonIgnore
    @OneToMany(mappedBy = "proyecto", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Tarea> listaTareas = new ArrayList<>();

}
