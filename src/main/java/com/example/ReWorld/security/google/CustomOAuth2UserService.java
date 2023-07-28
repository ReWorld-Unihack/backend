package com.example.ReWorld.security.google;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.ReWorld.constants.AuthenticationProvider;
import com.example.ReWorld.entities.User;
import com.example.ReWorld.security.repositories.IRoleRepository;
import com.example.ReWorld.security.repositories.IUserRepository;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleRepository roleRepository;


	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		User user = processOAuthPostLogin(oAuth2User);
		return new CustomOAuth2User(user,oAuth2User);
	}

	public User processOAuthPostLogin(OAuth2User oAuth2User) {
		String email = oAuth2User.getAttribute("email");
		Optional<User> existUser = userRepository.findByUsername(email);

		if (!existUser.isPresent()) {
			User newUser = new User();
			newUser.setUsername(email);
			newUser.setName(oAuth2User.getAttribute("name"));
			newUser.setEnabled(true);
			
			String avatar = oAuth2User.getAttribute("picture");
			newUser.setAvatar(avatar);
			newUser.setRoles(Set.of(roleRepository.findByName("ROLE_CUSTOMER")));
			newUser.setAuthProvider(AuthenticationProvider.GOOGLE);
			
			return userRepository.save(newUser);
		}
		
		return existUser.orElse(null);

	}
}
