package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {

    @Mock
    PetRepository repository;

    @InjectMocks
    ClinicServiceImpl service;

    @Test
    void findPetTypes() {
        // given
        List<PetType> petTypeList = new ArrayList<>();
        PetType petType1 = new PetType();
        PetType petType2 = new PetType();
        petTypeList.add(petType1);
        petTypeList.add(petType2);
        given(repository.findPetTypes()).willReturn(petTypeList);

        // when
        Collection<PetType> results = service.findPetTypes();

        // then
        assertThat(results.size()).isEqualTo(2);
        then(repository).should().findPetTypes();
    }
}