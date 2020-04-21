package edu.fje.daw2.m07uf2;

import edu.fje.daw2.m07uf2.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Interficie de persistència amb Spring Data i MongoDB.
 * @author sergi.grau@fje.edu
 * @version 1.0 02.4.20
 */

public interface ClientRepositori2 extends MongoRepository<Client, String> {

    Client findByNom(String nom);
    List<Client> findByCognom(String cognom);
    List<Client> findByVolumCompres(int volumCompres);

}