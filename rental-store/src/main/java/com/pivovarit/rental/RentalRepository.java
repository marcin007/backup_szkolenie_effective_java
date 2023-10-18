package com.pivovarit.rental;

import com.pivovarit.rental.Rental;

import java.util.List;

interface RentalRepository {
    void save(Rental rental);

    List<Rental> findAll();

    List<Rental> findAllForAccount(String accountId);
}
