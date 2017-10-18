package com.abril.laVendimia.controller;

import com.abril.laVendimia.application.ClienteApplication;
import com.abril.laVendimia.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PreDestroy;
import java.util.List;

@RestController
@RequestMapping(value = "api/clientes")
public class ClienteController {

    @Autowired
    ClienteApplication clienteApplication;

    @PostMapping()
    private Cliente save (@RequestBody Cliente cliente ) throws Exception {
        return clienteApplication.guardaElCliente(cliente);
    }

    @GetMapping("{id}")
    private Cliente getClienteById(@PathVariable Integer id){
        return clienteApplication.obtenerClientePorId(id);
    }

    @GetMapping()
    private List<Cliente> getClientes()
    {
        return clienteApplication.obtenerClientes();
    }

   @DeleteMapping("{id}")
   private String deleteCliente(@PathVariable Integer id){
        try {
            clienteApplication.eliminarCliente(id);
        }catch (Exception e){
            return "Hubo un error al eliminar";
        }
        return "Se eliminó cliente con id "+id;
   }

   @DeleteMapping()
    private String deleteAllClientes(){
       try {
           clienteApplication.eliminarClientes();
       }catch (Exception e){
           return "Hubo un error al eliminar todos los clientes";
       }
       return "Se eliminaron todos los clientes";
   }

   @PutMapping()
   private String putCliente(@RequestBody Cliente cliente){
        try {
            clienteApplication.editarCliente(cliente);
        }catch (Exception e){
            return "Hubo un error al editar el cliente";
        }
        return "Se editó el cliente";
   }

   @PatchMapping()
   private String patchCliente(@RequestBody Cliente cliente){
       clienteApplication.editarDatoCliente(cliente);
       return "Se edito el cliente";
   }
}
