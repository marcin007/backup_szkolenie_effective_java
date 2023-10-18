package com.pivovarit.rental;

import com.pivovarit.rental.api.event.RentalEvent;

interface MessagePublisher {
    void publish(RentalEvent event);
}
