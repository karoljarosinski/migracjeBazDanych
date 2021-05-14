package pl.kj.migracjebazdanych.testdata;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kj.migracjebazdanych.user.User;
import pl.kj.migracjebazdanych.user.UserRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Component
public class TestDataProvider {
    private UserRepository userRepository;

    public TestDataProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void insertTestData() {
        List<User> users = Arrays.asList(
                new User("Jan", "Kowalski", LocalDate.of(1990, LocalDate.now().getMonth(), 15)),
                new User("Marian", "Zieba", LocalDate.of(1980, 07, 10)),
                new User("Krystyna", "Sawicka", LocalDate.of(1970, 01, 21))
                );
        userRepository.saveAll(users);
    }
}
