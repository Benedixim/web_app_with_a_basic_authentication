package lesson.demo.services;

import lesson.demo.models.Person;
import lesson.demo.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public PersonDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Person person = userRepository.findByUsername(email);
       // List<String> roles = Arrays.asList(person.getRole());
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(person.getUsername())
                        .password(person.getPassword())
                        .roles("USER")
                        .build();

        return userDetails;
    }
}
