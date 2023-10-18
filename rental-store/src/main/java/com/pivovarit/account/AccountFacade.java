package com.pivovarit.account;

import com.pivovarit.rental.MovieRentalFacade;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class AccountFacade {
    private final MovieRentalFacade movieRentalFacade;
}
