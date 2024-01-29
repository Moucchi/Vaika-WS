package org.ITU.S5.cloud.backOffice.repository.annonce;

import org.ITU.S5.cloud.backOffice.businessObject.annonce.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepo extends JpaRepository<Annonce , Integer> {
    List<Annonce> findByCategorie(int idCategorie);
    List<Annonce> findByEtat(int idEtat);
    List<Annonce> findByAnnonceur(int idAnnonceur);
    List<Annonce> findByTag(int idTag);
    List<Annonce> findByTag(int[] idTags);
    List<Annonce> findByTag(List<Integer> idTags);
    List<Annonce> findByDatePublicationAfter(java.sql.Timestamp date);
    List<Annonce> findByDatePublicationBefore(java.sql.Timestamp date);
    List<Annonce> findByDatePublicationBetween(java.sql.Timestamp date1, java.sql.Timestamp date2);
    List<Annonce> findByPrixBefore(double prix);
    List<Annonce> findByPrixAfter(double prix);
    List<Annonce> findByPrixBetween(double prix1, double prix2);
    List<Annonce> findByMarque(int idMarque);
}
