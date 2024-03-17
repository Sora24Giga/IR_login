package recipe.backend.config;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import recipe.backend.security.user.Role;
import recipe.backend.security.user.User;
import recipe.backend.security.user.UserRepository;
import java.util.Date;


@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final UserRepository userRepository;
    
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("Init started.");
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        User admin = userRepository.save(User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .lastPasswordResetDate(
                        Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build());
        admin.getRoles().add(Role.ROLE_ADMIN);

        System.out.println("Init Finished.");
    }

}
