package com.abril.laVendimia.application;

import com.abril.laVendimia.domain.entities.Cliente;
import com.abril.laVendimia.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteApplication {

    @Autowired
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
        Cliente cliente = this.clienteRepository.findOne(id);
        return cliente;
    }

    public List<Cliente> obtenerClientes(){
        List<Cliente> clientesList = (List<Cliente>) this.clienteRepository.findAll();
        return clientesList;
    }

    public void eliminarCliente(Integer id){
        this.clienteRepository.delete(id);
    }


    public void eliminarClientes(){
        this.clienteRepository.deleteAll();
    }

    public void editarCliente(Cliente cliente){
    }

    public void editarDatoCliente(Cliente cliente){
    }

}
