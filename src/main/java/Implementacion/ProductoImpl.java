package Implementacion;

import Repositorio.IProducto;
import Entidad.Producto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoImpl implements IProducto {

    private List<Producto> productos = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public Producto guardar(Producto producto) {
        if (producto.getId() == null) {
            producto.setId(String.valueOf(idCounter++));
            productos.add(producto);
        } else {
            productos.replaceAll(p -> p.getId().equals(producto.getId()) ? producto : p);
        }
        return producto;
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productos;
    }

    @Override
    public Optional<Producto> obtenerPorId(String id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public void eliminar(String id) {
        productos.removeIf(p -> p.getId().equals(id));
    }
}
