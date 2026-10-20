package tn.esprit.autoloc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.*;
import tn.esprit.autoloc.repository.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Initialisation complète des données de démonstration au démarrage.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    private final AgenceRepository agenceRepository;
    private final EmployeRepository employeRepository;
    private final EquipementRepository equipementRepository;
    private final VehiculeRepository vehiculeRepository;
    private final ClientRepository clientRepository;
    private final ReservationRepository reservationRepository;
    private final ContratRepository contratRepository;
    private final PaiementRepository paiementRepository;
    private final MaintenanceRepository maintenanceRepository;

    public DataInitializer(
            AgenceRepository agenceRepository,
            EmployeRepository employeRepository,
            EquipementRepository equipementRepository,
            VehiculeRepository vehiculeRepository,
            ClientRepository clientRepository,
            ReservationRepository reservationRepository,
            ContratRepository contratRepository,
            PaiementRepository paiementRepository,
            MaintenanceRepository maintenanceRepository) {
        this.agenceRepository = agenceRepository;
        this.employeRepository = employeRepository;
        this.equipementRepository = equipementRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.clientRepository = clientRepository;
        this.reservationRepository = reservationRepository;
        this.contratRepository = contratRepository;
        this.paiementRepository = paiementRepository;
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (agenceRepository.count() == 0 && vehiculeRepository.count() == 0 && clientRepository.count() == 0) {
            log.info("==> Démarrage du seed complet de la base de données AutoLoc...");

            // 1. Agences
            Agence agenceTunis = new Agence(null, "Agence Tunis Centre", "Tunis", "Avenue Habib Bourguiba, 1001 Tunis", "+21671123456", null, null);
            Agence agenceSousse = new Agence(null, "Agence Sousse Ville", "Sousse", "Boulevard 14 Janvier, 4000 Sousse", "+21673654321", null, null);
            Agence agenceSfax = new Agence(null, "Agence Sfax Port", "Sfax", "Route de la Plage, 3000 Sfax", "+21674987654", null, null);
            List<Agence> agences = agenceRepository.saveAll(List.of(agenceTunis, agenceSousse, agenceSfax));

            // 2. Employes
            Employe emp1 = new Employe(null, "Ben Salem", "Kamel", RoleEmploye.MANAGER, agences.get(0));
            Employe emp2 = new Employe(null, "Mejri", "Sonia", RoleEmploye.AGENT, agences.get(0));
            Employe emp3 = new Employe(null, "Gharbi", "Mohamed", RoleEmploye.MANAGER, agences.get(1));
            Employe emp4 = new Employe(null, "Jlassi", "Fatma", RoleEmploye.AGENT, agences.get(1));
            Employe emp5 = new Employe(null, "Chahed", "Walid", RoleEmploye.AGENT, agences.get(2));
            employeRepository.saveAll(List.of(emp1, emp2, emp3, emp4, emp5));

            // 3. Equipements
            Equipement eqGps = new Equipement(null, "GPS Navigation", null);
            Equipement eqBabySeat = new Equipement(null, "Siège Bébé", null);
            Equipement eqRoofBars = new Equipement(null, "Barres de toit", null);
            Equipement eqWifi = new Equipement(null, "Boîtier Wi-Fi 4G", null);
            Equipement eqTires = new Equipement(null, "Pneus tout-terrain", null);
            List<Equipement> equipements = equipementRepository.saveAll(List.of(eqGps, eqBabySeat, eqRoofBars, eqWifi, eqTires));

            // 4. Véhicules
            Vehicule v1 = new Vehicule(null, "210-TUN-1234", "Renault", "Clio 5", CategorieVehicule.CITADINE, new BigDecimal("95.50"), StatutVehicule.DISPONIBLE, agences.get(0), null, List.of(equipements.get(0), equipements.get(3)), null);
            Vehicule v2 = new Vehicule(null, "215-TUN-5678", "Peugeot", "3008", CategorieVehicule.SUV, new BigDecimal("190.00"), StatutVehicule.DISPONIBLE, agences.get(1), null, List.of(equipements.get(0), equipements.get(1), equipements.get(2)), null);
            Vehicule v3 = new Vehicule(null, "220-TUN-9012", "Volkswagen", "Passat", CategorieVehicule.BERLINE, new BigDecimal("230.00"), StatutVehicule.MAINTENANCE, agences.get(0), null, List.of(equipements.get(0)), null);
            Vehicule v4 = new Vehicule(null, "225-TUN-3456", "Hyundai", "Tucson", CategorieVehicule.SUV, new BigDecimal("210.00"), StatutVehicule.LOUE, agences.get(1), null, List.of(equipements.get(0), equipements.get(1)), null);
            Vehicule v5 = new Vehicule(null, "230-TUN-7890", "Toyota", "Yaris", CategorieVehicule.CITADINE, new BigDecimal("100.00"), StatutVehicule.DISPONIBLE, agences.get(2), null, List.of(equipements.get(0)), null);
            Vehicule v6 = new Vehicule(null, "235-TUN-1122", "Fiat", "Ducato", CategorieVehicule.UTILITAIRE, new BigDecimal("180.00"), StatutVehicule.DISPONIBLE, agences.get(2), null, List.of(equipements.get(2)), null);
            List<Vehicule> vehicules = vehiculeRepository.saveAll(List.of(v1, v2, v3, v4, v5, v6));

            // 5. Clients
            Client c1 = new Client(null, "Ben Ali", "Youssef", "youssef.benali@gmail.com", "+21620123456", "PERM-TN-102938", LocalDate.of(2025, 1, 15), null);
            Client c2 = new Client(null, "Trabelsi", "Amira", "amira.trabelsi@yahoo.com", "+21625987654", "PERM-TN-556677", LocalDate.of(2025, 3, 20), null);
            Client c3 = new Client(null, "Mansour", "Hedi", "hedi.mansour@outlook.com", "+21622334455", "PERM-TN-998811", LocalDate.of(2025, 6, 10), null);
            Client c4 = new Client(null, "Khelifi", "Sarra", "sarra.khelifi@gmail.com", "+21629445566", "PERM-TN-334455", LocalDate.of(2026, 2, 1), null);
            List<Client> clients = clientRepository.saveAll(List.of(c1, c2, c3, c4));

            // 6. Réservations
            Reservation r1 = new Reservation(null, LocalDate.of(2026, 10, 15), LocalDate.of(2026, 10, 18), StatutReservation.TERMINEE, vehicules.get(0), clients.get(0), null);
            Reservation r2 = new Reservation(null, LocalDate.of(2026, 10, 19), LocalDate.of(2026, 10, 25), StatutReservation.CONFIRMEE, vehicules.get(3), clients.get(1), null);
            Reservation r3 = new Reservation(null, LocalDate.of(2026, 11, 1), LocalDate.of(2026, 11, 5), StatutReservation.EN_ATTENTE, vehicules.get(1), clients.get(2), null);
            Reservation r4 = new Reservation(null, LocalDate.of(2026, 10, 10), LocalDate.of(2026, 10, 12), StatutReservation.ANNULEE, vehicules.get(4), clients.get(3), null);
            List<Reservation> reservations = reservationRepository.saveAll(List.of(r1, r2, r3, r4));

            // 7. Contrats
            Contrat ctr1 = new Contrat(null, LocalDate.of(2026, 10, 15), new BigDecimal("286.50"), true, reservations.get(0), null);
            Contrat ctr2 = new Contrat(null, LocalDate.of(2026, 10, 19), new BigDecimal("1260.00"), true, reservations.get(1), null);
            List<Contrat> contrats = contratRepository.saveAll(List.of(ctr1, ctr2));

            // 8. Paiements
            Paiement p1 = new Paiement(null, new BigDecimal("286.50"), LocalDate.of(2026, 10, 15), ModePaiement.CARTE, contrats.get(0));
            Paiement p2 = new Paiement(null, new BigDecimal("630.00"), LocalDate.of(2026, 10, 19), ModePaiement.VIREMENT, contrats.get(1));
            Paiement p3 = new Paiement(null, new BigDecimal("630.00"), LocalDate.of(2026, 10, 20), ModePaiement.ESPECES, contrats.get(1));
            paiementRepository.saveAll(List.of(p1, p2, p3));

            // 9. Maintenances
            Maintenance m1 = new Maintenance(null, LocalDate.of(2026, 10, 18), LocalDate.of(2026, 10, 24), "Vidange complète et révision des freins", vehicules.get(2));
            maintenanceRepository.save(m1);

            log.info("==> Base de données AutoLoc seedée avec succès avec toutes les entités !");
        }
    }
}
