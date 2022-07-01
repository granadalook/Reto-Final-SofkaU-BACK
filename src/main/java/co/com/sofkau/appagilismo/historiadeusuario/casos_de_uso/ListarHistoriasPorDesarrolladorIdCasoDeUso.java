package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * Clase que representa el caso de uso de traer una lista de las historias de usuario vinculadas aun desarrollador especifico.
 */
@Service
@Validated
public class ListarHistoriasPorDesarrolladorIdCasoDeUso implements Function<String, Flux<HistoriaDeUsuarioDTO>> {

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    public ListarHistoriasPorDesarrolladorIdCasoDeUso(HistoriaDeUsuarioRepositorio repositorio, MapperHistoriaDeUsuario mapperHistoriaDeUsuario){
        this.repositorio=repositorio;
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
    }

    /**
     * Metodo que permite traer una lista de las hisotrias de usuario vinculadas a un desarrollador especifico.
     * @param desarrolladorId the function argument
     * @return Lista de Historias de usuarios.
     */
    @Override
    public Flux<HistoriaDeUsuarioDTO> apply(String desarrolladorId) {
        return repositorio.findAllByDesarrolladorId(desarrolladorId)
                .map(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO());
    }
}
