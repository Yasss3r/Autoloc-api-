-- ========================================================
-- AutoLoc Database Seed Script
-- ========================================================

SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE paiement;
TRUNCATE TABLE contrat;
TRUNCATE TABLE reservation;
TRUNCATE TABLE vehicule_equipement;
TRUNCATE TABLE maintenance;
TRUNCATE TABLE equipement;
TRUNCATE TABLE employe;
TRUNCATE TABLE vehicule;
TRUNCATE TABLE client;
TRUNCATE TABLE agence;

-- 1. Agences
INSERT INTO agence (id_agence, nom, ville, adresse, telephone) VALUES
(1, 'Agence Tunis Centre', 'Tunis', 'Avenue Habib Bourguiba, 1001 Tunis', '+21671123456'),
(2, 'Agence Sousse Ville', 'Sousse', 'Boulevard 14 Janvier, 4000 Sousse', '+21673654321'),
(3, 'Agence Sfax Port', 'Sfax', 'Route de la Plage, 3000 Sfax', '+21674987654');

-- 2. Employés
INSERT INTO employe (id_employe, nom, prenom, role, id_agence) VALUES
(1, 'Ben Salem', 'Kamel', 'MANAGER', 1),
(2, 'Mejri', 'Sonia', 'AGENT', 1),
(3, 'Gharbi', 'Mohamed', 'MANAGER', 2),
(4, 'Jlassi', 'Fatma', 'AGENT', 2),
(5, 'Chahed', 'Walid', 'AGENT', 3);

-- 3. Équipements
INSERT INTO equipement (id_equipement, libelle) VALUES
(1, 'GPS Navigation'),
(2, 'Siège Bébé'),
(3, 'Barres de toit'),
(4, 'Boîtier Wi-Fi 4G'),
(5, 'Pneus tout-terrain');

-- 4. Véhicules
INSERT INTO vehicule (id_vehicule, immatriculation, marque, modele, categorie, tarif_journalier, statut, id_agence) VALUES
(1, '210-TUN-1234', 'Renault', 'Clio 5', 'CITADINE', 95.50, 'DISPONIBLE', 1),
(2, '215-TUN-5678', 'Peugeot', '3008', 'SUV', 190.00, 'DISPONIBLE', 2),
(3, '220-TUN-9012', 'Volkswagen', 'Passat', 'BERLINE', 230.00, 'MAINTENANCE', 1),
(4, '225-TUN-3456', 'Hyundai', 'Tucson', 'SUV', 210.00, 'LOUE', 2),
(5, '230-TUN-7890', 'Toyota', 'Yaris', 'CITADINE', 100.00, 'DISPONIBLE', 3),
(6, '235-TUN-1122', 'Fiat', 'Ducato', 'UTILITAIRE', 180.00, 'DISPONIBLE', 3);

-- 5. Association Véhicule - Équipement
INSERT INTO vehicule_equipement (id_vehicule, id_equipement) VALUES
(1, 1), (1, 4),
(2, 1), (2, 2), (2, 3),
(3, 1),
(4, 1), (4, 2),
(5, 1),
(6, 3);

-- 6. Clients
INSERT INTO client (id_client, nom, prenom, email, telephone, num_permis, date_inscription) VALUES
(1, 'Ben Ali', 'Youssef', 'youssef.benali@gmail.com', '+21620123456', 'PERM-TN-102938', '2025-01-15'),
(2, 'Trabelsi', 'Amira', 'amira.trabelsi@yahoo.com', '+21625987654', 'PERM-TN-556677', '2025-03-20'),
(3, 'Mansour', 'Hedi', 'hedi.mansour@outlook.com', '+21622334455', 'PERM-TN-998811', '2025-06-10'),
(4, 'Khelifi', 'Sarra', 'sarra.khelifi@gmail.com', '+21629445566', 'PERM-TN-334455', '2026-02-01');

-- 7. Réservations
INSERT INTO reservation (id_reservation, date_debut, date_fin, statut, id_client, id_vehicule) VALUES
(1, '2026-10-15', '2026-10-18', 'TERMINEE', 1, 1),
(2, '2026-10-19', '2026-10-25', 'CONFIRMEE', 2, 4),
(3, '2026-11-01', '2026-11-05', 'EN_ATTENTE', 3, 2),
(4, '2026-10-10', '2026-10-12', 'ANNULEE', 4, 5);

-- 8. Contrats
INSERT INTO contrat (id_contrat, date_signature, montant_total, valide, id_reservation) VALUES
(1, '2026-10-15', 286.50, b'1', 1),
(2, '2026-10-19', 1260.00, b'1', 2);

-- 9. Paiements
INSERT INTO paiement (id_paiement, date_paiement, mode_paiement, montant, id_contrat) VALUES
(1, '2026-10-15', 'CARTE', 286.50, 1),
(2, '2026-10-19', 'VIREMENT', 630.00, 2),
(3, '2026-10-20', 'ESPECES', 630.00, 2);

-- 10. Maintenances
INSERT INTO maintenance (id_maintenance, date_debut, date_fin, description, id_vehicule) VALUES
(1, '2026-10-18', '2026-10-24', 'Vidange complète et révision des freins', 3);

SET FOREIGN_KEY_CHECKS = 1;
