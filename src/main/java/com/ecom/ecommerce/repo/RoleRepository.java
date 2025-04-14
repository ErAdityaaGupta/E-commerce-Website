package com.ecom.ecommerce.repo;

import com.ecom.ecommerce.model.AppRole;
import com.ecom.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
