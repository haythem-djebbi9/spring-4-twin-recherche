package tn.twin5.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.twin5.entities.AISystems;
import tn.twin5.repositories.IASystemsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service

@Slf4j

@RequiredArgsConstructor
public class AIServiceImpl implements AISystemsServices {

    private IASystemsRepository iaSystemsRepository;

    @Autowired
    public AIServiceImpl(IASystemsRepository iaSystemsRepository) {
        this.iaSystemsRepository = iaSystemsRepository;
    }
    @Override
    public AISystems addAISystems(AISystems aiSystems) {
        return iaSystemsRepository.save(aiSystems);
    }

    @Override
    public AISystems updateAISystems(AISystems aiSystems) {
        return iaSystemsRepository .save(aiSystems);
    }

    @Override
    public void deleteAISystems(AISystems aiSystems) {
        iaSystemsRepository.delete(aiSystems);
    }

    @Override
    public AISystems findById(Long id) {
        return iaSystemsRepository.findById(id).orElse(null);
    }

    @Override
    public List<AISystems> findAll() {
        return (List<AISystems>)iaSystemsRepository.findAll();
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void cleanOldAISystems() {

        log.info(" Cron 9a3da te5dem kol 10 secondes");

        log.debug(" DEBUG : Bch njib liste mel base...");

        List<AISystems> all = (List<AISystems>) iaSystemsRepository.findAll();

        if (all.isEmpty()) {
            log.warn(" WARN : Liste vide ! Mafij chay fil base.");
        }

        log.info(" INFO : 9adech 3andi min system : {}", all.size());

        try {
            int x = 10 / 0;
        } catch (Exception e) {
            log.error("ERROR : Sar error fel cron ! Cause : {}", e.getMessage());
        }

        log.info(" INFO : Wfat fel : {}", LocalDateTime.now());
    }


}


