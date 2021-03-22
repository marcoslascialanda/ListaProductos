package parcer;

import java.util.Collection;


import domain.Producto;

public interface FileConverter<T> {

	T convert(Collection<Producto> producto);
}
