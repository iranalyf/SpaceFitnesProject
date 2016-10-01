package br.com.informaticaf1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.informaticaf1.models.Usuario;

@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface UsuarioRepository extends JpaRepository<Usuario, Short> {


}
