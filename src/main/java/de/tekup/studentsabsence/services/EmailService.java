package de.tekup.studentsabsence.services;

import de.tekup.studentsabsence.entities.Student;
import de.tekup.studentsabsence.entities.Subject;

public interface EmailService {
    void sendEEmail(Student student, Subject subject);
}

