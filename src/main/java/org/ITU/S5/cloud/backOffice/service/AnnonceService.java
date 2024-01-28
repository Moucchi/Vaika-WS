package org.ITU.S5.cloud.backOffice.service;

import org.ITU.S5.cloud.backOffice.repository.annonce.AnnonceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepo annonceRepo;
}
