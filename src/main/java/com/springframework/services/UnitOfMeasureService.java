package com.springframework.services;

import com.springframework.commands.UnitOfMeasureCommand;
import reactor.core.publisher.Flux;

import java.util.Set;

public interface UnitOfMeasureService {

//    Set<UnitOfMeasureCommand> listAllUoms();
    Flux<UnitOfMeasureCommand> listAllUoms();
}
