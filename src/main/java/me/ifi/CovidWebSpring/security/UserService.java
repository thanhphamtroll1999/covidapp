//package me.ifi.CovidWebSpring.security;
//
//import me.ifi.CovidWebSpring.model.User;
//import me.ifi.CovidWebSpring.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException(username);
//        }
//        return new UserDetailsImpl(user);
//    }
//}
