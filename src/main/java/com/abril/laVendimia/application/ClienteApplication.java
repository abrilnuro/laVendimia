package com.abril.laVendimia.application;

import com.abril.laVendimia.domain.entities.Cliente;
import com.abril.laVendimia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;



@Component
public class ClienteApplication {

    ClienteRepository clienteRepository ;

    public Cliente guardaElCliente(Cliente cliente) throws Exception {
        if(cliente== null) {
            throw new Exception("CLIENTE NO DEBE SER NULL");
        }

        if(cliente != null){
            throw new Exception("EL CLIENTE NO ES NULO");

        }

        if(cliente.getApellidoMat() == null){
            throw new Exception("Hubo un error");

        }

        return   this.clienteRepository.save(cliente);

    }


    public Cliente obtenerClientePorId(Integer id){
        Cliente cliente = this.clienteRepository.findById(id);
        return cliente;
    }
}
