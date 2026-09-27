Project Structure:

The project follows the required directory structure:

tn.esprit.autoloc.domain: The 9 JPA entities without associations (Vehicule, Agence, Client, Employe, Equipement, Reservation, Contrat, Paiement, Maintenance) and the 5 enumerations (StatutVehicule, CategorieVehicule, RoleEmploye, StatutReservation, ModePaiement).

tn.esprit.autoloc.repository: Spring Data JPA interfaces (VehiculeRepository).

tn.esprit.autoloc.service: Business logic layer (planned for Workshop 4).

tn.esprit.autoloc.web.controller: REST controllers (planned for Workshop 5).

tn.esprit.autoloc.web.dto: Data Transfer Objects / DTOs (planned for Workshop 6).


Extension Features:

CommandLineRunner: DataInitializer automatically inserts 3 demo vehicles at startup if the table is empty.

dev Profile: The application-dev.properties file is enabled by default in application.properties.
