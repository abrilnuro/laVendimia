package com.abril.laVendimia.repository;

import com.abril.laVendimia.domain.entities.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RepositoryRestResource(path = "clientes")
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

   Cliente findById(@Param("id")Integer id);
}
