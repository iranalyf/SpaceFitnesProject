package br.com.informaticaf1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

import br.com.informaticaf1.models.Usuario;

@Repository
public class LoginUsuarioRepository implements UserDetailsService {

	@PersistenceContext
	private EntityManager em;

	public UserDetails loadUserByUsername(String email) {

		List<Usuario> usuarios = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email).getResultList();

		if (usuarios.isEmpty()) {

			throw new RuntimeException("Usuario " + email + "Não foi encontrado!! ");
		}

		return (UserDetails) usuarios.get(0);

	}


}
