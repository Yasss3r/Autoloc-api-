# AutoLoc API

Projet Spring Boot + Maven + Spring Data JPA + MySQL pour l'**Atelier 1 (Séance 2)** et la préparation de l'**Atelier 2 (Séance 3)**.

## Structure du projet

Le projet respecte l'arborescence demandée :
- `tn.esprit.autoloc.domain` : Les 9 entités JPA sans associations (`Vehicule`, `Agence`, `Client`, `Employe`, `Equipement`, `Reservation`, `Contrat`, `Paiement`, `Maintenance`) et les 5 énumérations (`StatutVehicule`, `CategorieVehicule`, `RoleEmploye`, `StatutReservation`, `ModePaiement`).
- `tn.esprit.autoloc.repository` : Interfaces Spring Data JPA (`VehiculeRepository`).
- `tn.esprit.autoloc.service` : Couche métier (prévue pour l'Atelier 4).
- `tn.esprit.autoloc.web.controller` : Contrôleurs REST (prévus pour l'Atelier 5).
- `tn.esprit.autoloc.web.dto` : Objets de transfert de données / DTO (prévus pour l'Atelier 6).

## Fonctionnalités d'extension (Section 6 - Pour aller plus loin)
- **CommandLineRunner** : `DataInitializer` insère automatiquement 3 véhicules de démonstration au démarrage si la table est vide.
- **Profil `dev`** : Fichier `application-dev.properties` activé par défaut dans `application.properties`.

## Exécution

1. Vérifier que MySQL est démarré sur `localhost:3306`.
2. Si votre mot de passe MySQL est différent de la valeur par défaut (`yasser123`), vous pouvez :
   - Définir la variable d'environnement `DB_PASSWORD`.
   - Ou modifier directement `spring.datasource.password` dans `src/main/resources/application.properties`.
3. Lancer l'application via IntelliJ IDEA (`AutolocApiApplication`).
4. La base `autoloc_db` et l'ensemble des 9 tables sont générées automatiquement grâce à `ddl-auto=update` et `createDatabaseIfNotExist=true`.
