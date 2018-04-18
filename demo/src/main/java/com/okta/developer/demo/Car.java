package com.okta.developer.demo;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Car {
	@Id @GeneratedValue
	private Long id;
	private @NonNull String name;
}
