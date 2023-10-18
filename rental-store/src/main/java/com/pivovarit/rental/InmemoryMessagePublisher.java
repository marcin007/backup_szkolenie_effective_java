package com.pivovarit.rental;

import com.pivovarit.rental.api.event.RentalEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class InmemoryMessagePublisher implements MessagePublisher {

    private final List<RentalEvent> events = Collections.synchronizedList(new ArrayList<>());



    @Override
    public void publish(RentalEvent event) {
        System.out.println(event);
        events.add(event);
    }
}
