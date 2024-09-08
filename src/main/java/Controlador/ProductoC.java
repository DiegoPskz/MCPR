	package Controlador;
	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
	
import Entidad.Producto;
import Implementacion.ProductoImpl;
	
		@RestController
	@RequestMapping("/productos")
	public class ProductoC {
		
		 @Autowired
		    private ProductoImpl productoRepository;

		    @PostMapping
		    public Producto crearProducto(@RequestBody Producto producto) {
		        return productoRepository.guardar(producto);
		    }

		    @GetMapping
		    public List<Producto> listarProductos() {
		        return productoRepository.obtenerTodos();
		    }

		    @GetMapping("/{id}")
		    public Producto obtenerProductoPorId(@PathVariable String id) {
		        return productoRepository.obtenerPorId(id).orElse(null);
		    }

		    @PutMapping("/{id}")
		    public Producto actualizarProducto(@PathVariable String id, @RequestBody Producto productoActualizado) {
		        return productoRepository.obtenerPorId(id)
		                .map(productoExistente -> {
		                    productoExistente.setNombre(productoActualizado.getNombre());
		                    productoExistente.setPrecio(productoActualizado.getPrecio());
		                    productoExistente.setStock(productoActualizado.getStock());
		                    return productoRepository.guardar(productoExistente);
		                }).orElse(null);
		    }

		    @DeleteMapping("/{id}")
		    public void eliminarProducto(@PathVariable String id) {
		        productoRepository.eliminar(id);
		    }
	}

