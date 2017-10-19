package com.abril.laVendimia.application;

import com.abril.laVendimia.domain.entities.Cliente;
import com.abril.laVendimia.repository.ClienteRepository;
import com.concredito.services.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteApplication {

    private Asserts asserts;

    @Autowired
    public ClienteApplication(){
        this.asserts = new Asserts();
    }

    @Autowired
    ClienteRepository clienteRepository ;

    public Cliente guardaElCliente(Cliente cliente) throws Exception {
        this.asserts.isNotNull(cliente, "No se proporcionó ningun cliente");
        this.asserts.isNotNullOrEmpty(cliente.getNombre(), "nombre");
        this.asserts.isNotNullOrEmpty(cliente.getApellidoPat(), "apellido paterno");

        Cliente clienteExiste = this.clienteRepository.findFirstOnesByNombreAndApellidoPatAndApellidoMat(cliente.getNombre(),
                cliente.getApellidoPat(),
                cliente.getApellidoMat());

        this.asserts.isNull(clienteExiste, "El cliente ya existe");

        return this.clienteRepository.save(cliente);
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
