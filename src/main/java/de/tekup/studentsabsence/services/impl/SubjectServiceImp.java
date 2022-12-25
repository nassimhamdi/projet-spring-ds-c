package de.tekup.studentsabsence.services.impl;

import de.tekup.studentsabsence.entities.Subject;
import de.tekup.studentsabsence.repositories.SubjectRepository;
import de.tekup.studentsabsence.services.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SubjectServiceImp implements SubjectService {
    private final SubjectRepository subjectRepository;

    //TODO Complete this method
    @Override
    public List<Subject> getAllSubjects() {
        Iterable<Subject> sub = subjectRepository.findAll();
        List<Subject> result = new ArrayList<Subject>();
        for (Subject str : sub) {
            result.add(str);
        }
        return result;
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("No Subject with ID: " + id));

    }

    @Override
    public Subject addSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(Subject subject) {
        if (!subjectRepository.existsById(subject.getId())) {
            throw new NoSuchElementException("No Subject with ID : " + subject.getId());
        }
        return subjectRepository.save(subject);
    }

    @Override
    public Subject deleteSubject(Long id) {
        Subject subject = getSubjectById(id);
        subjectRepository.delete(subject);
        return subject;
    }


}

