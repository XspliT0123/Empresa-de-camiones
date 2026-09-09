package com.empresa;

import com.empresa.Model.RolModel;
import com.empresa.Model.UsuarioModel;
import com.empresa.Repositorio.UsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
	}

	@Bean
	CommandLineRunner crearUsuariosIniciales(
			UsuarioRepositorio usuarioRepositorio,
			PasswordEncoder passwordEncoder) {

		return args -> {

			// Usuario administrador
			if (!usuarioRepositorio.existsByUsername("admin")) {

				UsuarioModel admin = new UsuarioModel(
						"admi",
						passwordEncoder.encode("123456"),
						RolModel.ADMINISTRADOR
				);

				usuarioRepositorio.save(admin);
			}

			// Usuario supervisor
			if (!usuarioRepositorio.existsByUsername("supervisor")) {

				UsuarioModel supervisor = new UsuarioModel(
						"supervisor",
						passwordEncoder.encode("123456"),
						RolModel.SUPERVISOR
				);

				usuarioRepositorio.save(supervisor);
			}
		};
	}
}
