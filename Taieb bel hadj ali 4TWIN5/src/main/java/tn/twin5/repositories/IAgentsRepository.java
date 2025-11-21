package tn.twin5.repositories;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.data.repository.CrudRepository;
import tn.twin5.entities.Agents;
import tn.twin5.entities.enums.Skills;

import java.util.List;

public interface IAgentsRepository extends CrudRepository<Agents, Long> {

    // Tous les agents disponibles (aucun skill spécifié)
    List<Agents> findByAvailableTrue();
    List<Agents> findByAvailableTrueAndSkillsIn(List<Skills> skills);

    List<Agents> findAvailableAgentsWithSingleSkill(Skills skill);

}
