package com.pivovarit.rental;

import com.pivovarit.rental.Movie;

interface MoviePriceCalculator {
    long getPriceFor(Movie movie);
}
