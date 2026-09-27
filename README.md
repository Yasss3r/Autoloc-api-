Structure du projet:

Le projet respecte l'arborescence demandée :
- `tn.esprit.autoloc.domain` : Les 9 entités JPA sans associations (`Vehicule`, `Agence`, `Client`, `Employe`, `Equipement`, `Reservation`, `Contrat`, `Paiement`, `Maintenance`) et les 5 énumérations (`StatutVehicule`, `CategorieVehicule`, `RoleEmploye`, `StatutReservation`, `ModePaiement`).
- `tn.esprit.autoloc.repository` : Interfaces Spring Data JPA (`VehiculeRepository`).
- `tn.esprit.autoloc.service` : Couche métier (prévue pour l'Atelier 4).
- `tn.esprit.autoloc.web.controller` : Contrôleurs REST (prévus pour l'Atelier 5).
- `tn.esprit.autoloc.web.dto` : Objets de transfert de données / DTO (prévus pour l'Atelier 6).

Fonctionnalités d'extension:

- **CommandLineRunner** : `DataInitializer` insère automatiquement 3 véhicules de démonstration au démarrage si la table est vide.
- **Profil `dev`** : Fichier `application-dev.properties` activé par défaut dans `application.properties`.

