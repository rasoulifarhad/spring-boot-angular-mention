package com.farhad.example.springbootangularngzorromention.users;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;

	public List<String> findUsernames(String filter) {
		if(StringUtils.hasText(filter)) {
			return toUsernames( userRepository.findByUsernameStartsWith(filter));
		}
		return toUsernames(userRepository.findAll());
	}

	private List<String> toUsernames(List<UserEntity> userEntities) {
		return userEntities.stream()
					.map(UserEntity::getUsername)
					.collect(toList());
	}

	public List<String> getTopUsernames() {
		return 	toUsernames(userRepository.findAllByTopIsTrue());
					
	}

	@Transactional
	public void saveTopUsers(List<String> topUsernames) {
		userRepository.findAll()
			.forEach(user -> user.setTop(topUsernames.contains(user.getUsername()))	);
	}
}
