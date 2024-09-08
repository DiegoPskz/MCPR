package Repositorio;

import java.util.List;
import java.util.Optional;

import Entidad.Producto;

public interface IProducto {
	    Producto guardar(Producto producto);
	    List<Producto> obtenerTodos();
	    Optional<Producto> obtenerPorId(String id);
	    void eliminar(String id);
}
