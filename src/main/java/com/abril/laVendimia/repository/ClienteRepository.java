package com.abril.laVendimia.repository;

import com.abril.laVendimia.domain.entities.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestResource(path = "showclientes")
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
