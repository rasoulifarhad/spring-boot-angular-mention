package com.farhad.example.springbootangularngzorromention.users;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SaveTopUserRequest {

	private List<String> usernames = new ArrayList<>();

}
