package de.tekup.studentsabsence.services;

import de.tekup.studentsabsence.entities.Email;
import de.tekup.studentsabsence.entities.Response;

public interface EmailService {
    Response sendEmail(Email mail);
}
