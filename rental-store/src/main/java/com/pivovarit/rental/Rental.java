package com.pivovarit.rental;
record Rental(RentalType type, String accountId, String movieTitle) {
    enum RentalType {
        RETURN, RENT
    }
}


