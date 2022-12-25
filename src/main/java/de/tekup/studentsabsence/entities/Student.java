package de.tekup.studentsabsence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"image","group","absences"})
public class Student implements Serializable {
    //TODO Complete Validations of fields


    @Id
    private Long sid;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "phone is required")
    private String phone;

    @NotNull(message = "Date is required")
    @Past(message = "Should be a date in the past")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;

    //TODO Complete Relations with other entities

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "students")
    public Group group;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    public List<Absence> absencesStudent = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    //@Column(columnDefinition = "VARCHAR(255)")
    private Image image;



}
