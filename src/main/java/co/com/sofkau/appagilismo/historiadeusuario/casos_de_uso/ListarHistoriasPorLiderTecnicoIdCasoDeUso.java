package co.com.sofkau.appagilismo.historiadeusuario.casos_de_uso;

import co.com.sofkau.appagilismo.historiadeusuario.dto.HistoriaDeUsuarioDTO;
import co.com.sofkau.appagilismo.historiadeusuario.mapper.MapperHistoriaDeUsuario;
import co.com.sofkau.appagilismo.historiadeusuario.repositorio.HistoriaDeUsuarioRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * Clase que representa el caso de uso de traer una lista de las historias de usuario vinculadas aun lider tecnico especifico.
 */
@Service
@Validated
public class ListarHistoriasPorLiderTecnicoIdCasoDeUso implements Function<String, Flux<HistoriaDeUsuarioDTO>>{

    private final HistoriaDeUsuarioRepositorio repositorio;

    private final MapperHistoriaDeUsuario mapperHistoriaDeUsuario;

    public ListarHistoriasPorLiderTecnicoIdCasoDeUso(HistoriaDeUsuarioRepositorio repositorio, MapperHistoriaDeUsuario mapperHistoriaDeUsuario){
        this.repositorio=repositorio;
        this.mapperHistoriaDeUsuario=mapperHistoriaDeUsuario;
    }

    /**
     * Metodo que permite traer una lista de las hisotrias de usuario vinculadas a un lider tecnico especifico.
     * @param liderTecnicoId the function argument
     * @return
     */
    @Override
    public Flux<HistoriaDeUsuarioDTO> apply(String liderTecnicoId) {
        return repositorio.findAllByLiderTecnicoId(liderTecnicoId)
                .map(mapperHistoriaDeUsuario.mapperAHistoriaDeUsuarioDTO());
    }
}
