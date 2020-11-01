package com.springframework.services;

import com.springframework.commands.UnitOfMeasureCommand;
import com.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.springframework.domain.UnitOfMeasure;
import com.springframework.repositories.UnitOfMeasureRepository;
import com.springframework.repositories.reactive.UnitOfMeasureReactiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureReactiveRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUoms() throws Exception {
        //given
       // Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId("1");
        //unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId("2");
        //unitOfMeasures.add(uom2);

        Flux<UnitOfMeasure> unitOfMeasures = Flux.just(uom1,uom2);
                when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        //when
        Flux<UnitOfMeasureCommand> commands = service.listAllUoms();
        List<UnitOfMeasureCommand> com = commands.collectList().block();

        //then
        assertEquals(2, com.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }

}