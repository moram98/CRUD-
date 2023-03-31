package interfaces;

import interfaces.modelo.Cliente;
import interfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        CrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("jano", "perez"));
        repo.crear(new Cliente("Maicol", "Mora"));
        repo.crear(new Cliente("Liliana", "Hernandez"));
        repo.crear(new Cliente("Carlos", "Mora"));

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("==== paginable ====");

        List<Cliente> paginable =  ((PaginableRepositorio)repo).listar(1,4);
        paginable.forEach(System.out::println);

        System.out.println("==== Ordenar ====");
        List<Cliente> clienteOrdenAsc = ((OrdenableRepositorio)repo).listar("apellido", Direccion.ASC);
        for (Cliente c: clienteOrdenAsc){
            System.out.println(c);
        }
        System.out.println("==== Editar ====");


        Cliente beaActualizar = new Cliente ("Maicol", "murillo");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente maicol = repo.porId(2);
        System.out.println(maicol);
        ((OrdenableRepositorio)repo)
                .listar("apellido", Direccion.ASC).forEach( System.out::println);

        System.out.println("==== Eliminar ====");

        //repo.eliminar(2);
        repo.listar().forEach(System.out::println);
    }
}
