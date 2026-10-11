package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;
import java.util.Optional;

public interface IVehiculeService {

    Vehicule addVehicule(Vehicule vehicule);

    Vehicule updateVehicule(Vehicule vehicule);

    void deleteVehicule(Long id);

    List<Vehicule> findAllVehicules();

    Optional<Vehicule> findVehiculeById(Long id);
}
