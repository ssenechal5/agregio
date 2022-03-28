package com.agregio.park;

import com.agregio.constant.ParkType;
import com.agregio.entity.Park;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Park tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParkServiceTest {

    @Mock
    ParkRepository parkRepository;

    ParkService parkService;

    @BeforeEach
    void setUp() {
      parkService = new ParkService(parkRepository);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerPark() {
      ParkRegistrationRequest request = new ParkRegistrationRequest("monPark", ParkType.SOLAR);
      Park park = Park.builder()
              .name(request.name())
              .type(request.type())
              .build();
      when(parkRepository.saveAndFlush(ArgumentMatchers.any(Park.class))).thenReturn(park);
      assertTrue(parkService.registerPark(request));
    }

    @Test
    void getPark() {
    }

    @Test
    void getParksByMarket() {
    }

    @Test
    void updatePark() {
    }

    @Test
    void deletePark() {
    }
}