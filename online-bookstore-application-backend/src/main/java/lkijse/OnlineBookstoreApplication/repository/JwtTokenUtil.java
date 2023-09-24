package lkijse.OnlineBookstoreApplication.repository;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenUtil {

    String generateToken(UserDetails userDetails);

}
