//package com.tmsoft.fleetapp.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.tmsoft.fleetapp.models.User;
//import com.tmsoft.fleetapp.models.UserPrincipal;
//import com.tmsoft.fleetapp.repositories.UserRepository;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//	
//	@Autowired UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	 User user = userRepository.findByUsername(username);
//	 
//	 if (user == null) {
//		 throw new UsernameNotFoundException("User not found");
//	 } else {
//		 System.out.println("User Found");
//	 }
//	 
//	 return new UserPrincipal(user);
//	}
//
//}
