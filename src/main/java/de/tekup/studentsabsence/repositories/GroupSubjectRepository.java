package de.tekup.studentsabsence.repositories;

import de.tekup.studentsabsence.entities.Group;
import de.tekup.studentsabsence.entities.GroupSubject;
import de.tekup.studentsabsence.entities.GroupSubjectKey;
import de.tekup.studentsabsence.entities.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GroupSubjectRepository extends CrudRepository<GroupSubject, GroupSubjectKey> {
    List<GroupSubject> findAllByGroup(Group id);
    ///TODO create a methode to find a groupSubject by Group Id and Subject Id

    GroupSubject findGroupSubjectByGroup_IdAndSubject_Id(Long id, Long sid);

    List<GroupSubject> findGroupSubjectBySubject_Id(Long id);
    GroupSubject findGroupSubjectBySubject_IdAndGroup_Id(Long sid,Long gid);

}
