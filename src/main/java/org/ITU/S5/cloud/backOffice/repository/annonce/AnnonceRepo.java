package org.ITU.S5.cloud.backOffice.repository.annonce;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepo extends JpaRepository<Annonce , Integer> {
    //TODO
    List<Annonce> findByVoiture_Serie_Categorie_Id(int idCategorie);
    //TODO
    List<Annonce> findByVoiture_Serie_Model_Marque_Id(int idMarque);
    //TODO
    List<Annonce> findByVoiture_Serie_Model_Id(int idModel);

    List<Annonce> findByEtat_Reference(int idEtat);
    List<Annonce> findByAnnonceur_Id(int idAnnonceur);
    List<Annonce> findByTags_ReferenceIn(List<Integer> idTags);
    List<Annonce> findByDatePublicationAfter(java.sql.Timestamp date);
    List<Annonce> findByDatePublicationBefore(java.sql.Timestamp date);
    List<Annonce> findByDatePublicationBetween(java.sql.Timestamp date1, java.sql.Timestamp date2);
    List<Annonce> findByPrixBefore(double prix);
    List<Annonce> findByPrixAfter(double prix);
    List<Annonce> findByPrixBetween(double prix1, double prix2);
}
