package com.abril.laVendimia.controller;

import com.abril.laVendimia.application.ClienteApplication;
import com.abril.laVendimia.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/clientela")
public class ClienteController {

    @Autowired
    ClienteApplication clienteApplication;

    @PostMapping("saveCliente")
    private Cliente save (@RequestBody Cliente cliente ) throws Exception {
        return clienteApplication.guardaElCliente(cliente);
    }

    @GetMapping("getCliente/{id}")
    private Cliente getClienteById(@PathVariable Integer id){
        return clienteApplication.obtenerClientePorId(id);
    }

}
