package com.porfolio.mgb.Security.Repository;


import com.porfolio.mgb.Security.Entity.Rol;
import com.porfolio.mgb.Security.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);

}
