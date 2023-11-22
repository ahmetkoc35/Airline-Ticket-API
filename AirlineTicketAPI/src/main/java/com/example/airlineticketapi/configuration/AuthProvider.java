package com.example.airlineticketapi.configuration;

import com.example.airlineticketapi.model.Customer;
import com.example.airlineticketapi.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthProvider implements AuthenticationProvider
{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        Optional<Customer> user = customerRepository.findCustomerByUsername(username);

        if (user.isPresent())
        {
            if (passwordEncoder.matches(password, user.get().password))
                return new UsernamePasswordAuthenticationToken(username, password, null);

            else throw new BadCredentialsException("Please control the your password");
        }
        else throw new BadCredentialsException("Plase control the informations!");
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
