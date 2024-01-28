package org.ITU.S5.cloud.backOffice.service;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.HistoriqueVoiture;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Marque;
import org.ITU.S5.cloud.backOffice.repository.voiture.HistoriqueVoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VoitureService {

    @Autowired
    HistoriqueVoitureRepo historiqueVoitureRepo;

    public Map<Marque, Serie> getVoituresLesPlusVendues() {
        List<HistoriqueVoiture> historiques = historiqueVoitureRepo.findAll();

        Map<Marque, HashMap<Serie, Integer>> compteurVentes = new HashMap<>();
        for (HistoriqueVoiture historique : historiques) {
            Marque marque = historique.getVoiture().getSerie().getModel().getMarque();
            Serie serie = historique.getVoiture().getSerie();

            compteurVentes.putIfAbsent(marque, new HashMap<>());
            compteurVentes.get(marque).put(serie, compteurVentes.get(marque).getOrDefault(serie, 0) + 1);
        }

        Map<Marque, Serie> voituresLesPlusVendues = new HashMap<>();
        for (Map.Entry<Marque, HashMap<Serie, Integer>> entry : compteurVentes.entrySet()) {
            Marque marque = entry.getKey();
            Serie serieLaPlusVendue = Collections.max(entry.getValue().entrySet(), Map.Entry.comparingByValue()).getKey();

            voituresLesPlusVendues.put(marque, serieLaPlusVendue);
        }

        return voituresLesPlusVendues;
    }
}
