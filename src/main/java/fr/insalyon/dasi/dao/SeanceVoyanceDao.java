package fr.insalyon.dasi.dao;

import fr.insalyon.dasi.metier.modele.SeanceVoyance;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author DASI Team
 */
public class SeanceVoyanceDao {
    
    public void creer(SeanceVoyance seance) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        em.persist(seance);
    }
    
    public SeanceVoyance chercherParId(Long seanceVoyanceId) {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        return em.find(SeanceVoyance.class, seanceVoyanceId); // renvoie null si l'identifiant n'existe pas
    }
    
    public List<SeanceVoyance> listerSeanceVoyance() {
        EntityManager em = JpaUtil.obtenirContextePersistance();
        TypedQuery<SeanceVoyance> query = em.createQuery("SELECT c FROM SeanceVoyance c ORDER BY c.nom ASC, c.prenom ASC", SeanceVoyance.class);
        return query.getResultList();
    }
    
    // modifier / supprimer  ... 
}
