package org.ITU.S5.cloud.backOffice.service;

import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.detail.Serie;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.HistoriqueVoiture;
import org.ITU.S5.cloud.backOffice.businessObject.voiture.information.general.Marque;
import org.ITU.S5.cloud.backOffice.repository.DAO;
import org.ITU.S5.cloud.backOffice.repository.voiture.HistoriqueVoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class VoitureService {

    @Autowired
    DAO dao;

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

    public Map<LocalDateTime, Double> getEvolutionPrix(int idVoiture) {
        Map<LocalDateTime, Double> result = null;
        Map<LocalDateTime, Double> finalResult = null;

        String sql = "SELECT * FROM historique_voiture WHERE id_voiture = ? ORDER BY date_achat ASC";
        List<LocalDateTime> dates = new ArrayList<>();

        try (Connection connection = dao.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idVoiture);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                if (result == null) {
                    result = new LinkedHashMap<>();
                }

                LocalDateTime dateAchat = resultSet.getTimestamp("date_achat").toLocalDateTime();
                dates.add(dateAchat);
                double prix = resultSet.getDouble("prix_achat");

                result.put(dateAchat, prix);
            }

            if (result != null) {
                int i = 0;

                finalResult = new LinkedHashMap<>();

                for (Map.Entry<LocalDateTime, Double> entry : result.entrySet()) {
                    LocalDateTime date = entry.getKey();
                    double prix = entry.getValue();

                    if (i == 0) {
                        finalResult.put(date, prix);
                        i++;
                        continue;
                    }

                    LocalDateTime datePrecedente = dates.get(i - 1);

                    double prixPrecedent = result.get(datePrecedente);

                    LocalDateTime dateCourante = datePrecedente.plusHours(5);

                    while (dateCourante.isBefore(date)) {
                        finalResult.put(dateCourante, prixPrecedent);
                        dateCourante = dateCourante.plusHours(5);
                    }

                    finalResult.put(date, prix);

                    i++;
                }
            }

            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return finalResult;
    }
}
