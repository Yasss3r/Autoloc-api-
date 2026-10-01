package tn.esprit.autoloc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Initialisation des données de démonstration au démarrage.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final VehiculeRepository vehiculeRepository;

    public DataInitializer(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public void run(String... args) {
        if (vehiculeRepository.count() == 0) {
            log.info("Insertion des véhicules de démonstration...");

            Vehicule v1 = new Vehicule();
            v1.setImmatriculation("210-TUN-1234");
            v1.setMarque("Renault");
            v1.setModele("Clio 5");
            v1.setCategorie(CategorieVehicule.CITADINE);
            v1.setTarifJournalier(new BigDecimal("95.50"));
            v1.setStatut(StatutVehicule.DISPONIBLE);

            Vehicule v2 = new Vehicule();
            v2.setImmatriculation("215-TUN-5678");
            v2.setMarque("Peugeot");
            v2.setModele("3008");
            v2.setCategorie(CategorieVehicule.SUV);
            v2.setTarifJournalier(new BigDecimal("190.00"));
            v2.setStatut(StatutVehicule.DISPONIBLE);

            Vehicule v3 = new Vehicule();
            v3.setImmatriculation("220-TUN-9012");
            v3.setMarque("Volkswagen");
            v3.setModele("Passat");
            v3.setCategorie(CategorieVehicule.BERLINE);
            v3.setTarifJournalier(new BigDecimal("230.00"));
            v3.setStatut(StatutVehicule.MAINTENANCE);

            vehiculeRepository.saveAll(List.of(v1, v2, v3));
            log.info("3 véhicules de démonstration insérés avec succès.");
        }
    }
}
