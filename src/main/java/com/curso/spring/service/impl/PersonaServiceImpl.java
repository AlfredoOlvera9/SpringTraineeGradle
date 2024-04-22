package com.curso.spring.service.impl;

import com.curso.spring.dto.DireccionDTO;
import com.curso.spring.dto.EmpleoDTO;
import com.curso.spring.dto.PersonaCreacionDTO;
import com.curso.spring.dto.PersonaDto;
import com.curso.spring.dto.mapper.MapperPersonaDto;
import com.curso.spring.dto.request.CrearPersonaRequest;
import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.dto.response.DatosPersonaResponse;
import com.curso.spring.model.Direcciones;
import com.curso.spring.model.Empleos;
import com.curso.spring.model.Persona;
import com.curso.spring.repository.IDireccionRepository;
import com.curso.spring.repository.IEmpleoRepository;
import com.curso.spring.repository.IPersonasRepository;
import com.curso.spring.service.IDireccionService;
import com.curso.spring.service.IEmpleoService;
import com.curso.spring.service.IPersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonasRepository personRepository;
    @Autowired
    private IEmpleoRepository empleoRepository;
    @Autowired
    private IDireccionRepository direccionRepository;


    @Override
    public List<PersonaDto> findAll() {

        List <Persona> personas = (List<Persona>) personRepository.findAll();
        // convertimos cada objeto persona a persona dto, usamos:
        //api stream, con un mapa "u", convertimos usuarios a objeto dto y lo devolvemos auna tipo de lista collectors
        return personas
                .stream()
                .map( u -> MapperPersonaDto.builder().setPersona(u).build())
                .collect(Collectors.toList());
    }

    @Override
    public Persona save(Persona persona) {

        return personRepository.save(persona);
    }

    @Override
    public PersonaRequest save2(PersonaRequest persona) {
        return null;
    }


    @Override
    public PersonaDto saveDto(Persona persona) {

        return MapperPersonaDto.builder().setPersona(personRepository.save(persona)).build();
    }

    @Override
    public Persona buscarPersonaId(Long id) {
        Optional<Persona> datosPersona = personRepository.findById(id);
        return datosPersona.get();
    }

    @Override
    public ResponseEntity<Persona> updatePersona(PersonaDto personaDto) {
        Optional<Persona> existePersona = personRepository.findById(personaDto.getPersonaId());
        ResponseEntity<Persona> response = null;

        if(existePersona.isPresent()){

            Persona persona = new Persona();
            persona.setPersonaId(personaDto.getPersonaId());
            persona.setNombre(personaDto.getNombre());
            persona.setDireccionId(personaDto.getDireccionId());
            persona.setEmpleoId(personaDto.getEmpleoId());
            response = ResponseEntity.ok(personRepository.save(persona));

        } else {
            response = ResponseEntity.noContent().build();
        }
        return  response;

    }

    @Override
    public void eliminarPersona(Long id) {

        personRepository.deleteById(id);

    }

    @Override
    public List<String> getNombrePersonaByGenero(String genero) {

        return personRepository.personasByGenero(genero );
    }

    @Override

    public ResponseEntity<Object> getInfoPersona( Integer id){

        ResponseEntity<Object> response = null;

       try {

           Optional<DatosPersonaResponse> info = Optional.ofNullable(personRepository.getInfoPersona(id));

           if(info.isPresent()){

               response = ResponseEntity.ok(info.get());

           }else {
               response = ResponseEntity.status(HttpStatus.NOT_FOUND)
                       .body("No se econtraron datos de la persona con el ID: " + id);
           }


       }catch (Exception e){
           log.error("error en metodo getInfoPersona" + e.getMessage());
       }
       return response;
    }

    @Transactional
    @Override
    public ResponseEntity<?> savePersonaNative(PersonaRequest request) {
        ResponseEntity<?> response = null;
        try {
            Integer result = personRepository.saveNativePerson(request);

            if (result > 0) {
                response = ResponseEntity.ok().body("Guardado exitosamente");
            } else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(" error al intentar insertar el dato");
            }

        } catch (Exception e) {
            log.error("Error en  savePersonaNative: " + e.getMessage());
        }

        return response;
    }


    @Transactional
    @Override
    public ResponseEntity<?> updatePersonaNative(PersonaRequest request) throws Exception {

        ResponseEntity<?> response = null;

        try {
            Integer result = personRepository.updateNativePerson(request);

            if (result > 0) {
                response = ResponseEntity.ok().body("Guardado exitosamente");
            } else {
                response = ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(" error al intentar insertar el dato");
            }

        } catch (Exception e) {
            log.error("Error en  savePersonaNative: " + e.getMessage());
        }

        return response;
    }


    @Transactional
    @Override
    public boolean deletePersonNative(Long id) throws Exception {

        boolean responde = false;

        try{
            personRepository.deleteByIdNative(id);
            responde = true;

        }catch (Exception e){

            throw new Exception("Error al eliminar: " + e.getMessage());

        }
        return responde;
    }

    @Override
    @Transactional
    public ResponseEntity<?> crearPersonasConEmpleoYDireccion(PersonaCreacionDTO personaDTO) {
      /*  try {
            // Crear Empleo
            EmpleoDTO empleoDTO = personaDTO.getEmpleoDTO();
            ResponseEntity<?> empleoResponse = empleoService.crearEmpleo(empleoDTO);
            if (empleoResponse.getStatusCode() != HttpStatus.CREATED) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear empleo.");
            }
            EmpleoDTO empleoCreado = (EmpleoDTO) empleoResponse.getBody();

            // Crear Dirección
            DireccionDTO direccionDTO = personaDTO.getDireccionDTO();
            ResponseEntity<?> direccionResponse = direccionService.crearDireccion(direccionDTO);
            if (direccionResponse.getStatusCode() != HttpStatus.CREATED) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear dirección.");
            }
            DireccionDTO direccionCreada = (DireccionDTO) direccionResponse.getBody();

            // Crear Persona
            Persona persona = new Persona();
            persona.setNombre(personaDTO.getNombre());
            persona.setEdad(Integer.valueOf(personaDTO.getEdad()));
            persona.setGenero(personaDTO.getGenero());
            persona.setEmpleoId(new Empleos(empleoCreado.getEmpleoId()));
            persona.setDireccionId(new Direcciones(direccionCreada.getDireccionId()));

            Persona personaGuardada = personRepository.save(persona);

            PersonaDto personaGuardadaDTO = new PersonaDto();
            personaGuardadaDTO.setPersonaId(personaGuardada.getPersonaId());
            personaGuardadaDTO.setNombre(personaGuardada.getNombre());
            personaGuardadaDTO.setEdad(personaGuardada.getEdad());
            personaGuardadaDTO.setGenero(personaGuardada.getGenero());
            personaGuardadaDTO.setEmpleoId(personaGuardada.getEmpleoId().getEmpleoId());
            personaGuardadaDTO.setDireccionId(personaGuardada.getDireccionId().getDireccionId());


            return ResponseEntity.status(HttpStatus.CREATED).body(personaGuardadaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la persona con empleo y dirección.");
        }
    */ return null;
    }
    @Transactional
    @Override
    public PersonaCreacionDTO crearPersonaConEmpleoYDireccion(CrearPersonaRequest request) {
        try {
            // Crear dirección
            Direcciones nuevaDireccion = new Direcciones();
            nuevaDireccion.setCalle(request.getCalleDireccion());
            nuevaDireccion.setCiudad(request.getCiudadDireccion());
            nuevaDireccion.setEstado(request.getEstadoDireccion());
            nuevaDireccion.setCodigoPostal(request.getCodigoPostalDireccion());
            Direcciones direccionGuardada = direccionRepository.save(nuevaDireccion);

            // Crear empleo
            Empleos nuevoEmpleo = new Empleos();
            nuevoEmpleo.setTitulo(request.getTituloEmpleo());
            nuevoEmpleo.setEmpresa(request.getEmpresaEmpleo());
            nuevoEmpleo.setSalario(request.getSalarioEmpleo());
            Empleos empleoGuardado = empleoRepository.save(nuevoEmpleo);

            // Crear persona
            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre(request.getNombrePersona());
            nuevaPersona.setEdad(request.getEdadPersona());
            nuevaPersona.setGenero(request.getGeneroPersona());
            nuevaPersona.setDireccionId(direccionGuardada);
            nuevaPersona.setEmpleoId(empleoGuardado);
            Persona personaGuardada = personRepository.save(nuevaPersona);

            // Crear DTO
            PersonaCreacionDTO personaDTO = new PersonaCreacionDTO();
            personaDTO.setId(personaGuardada.getPersonaId());
            personaDTO.setNombre(personaGuardada.getNombre());
            personaDTO.setEdad(personaGuardada.getEdad());
            personaDTO.setGenero(personaGuardada.getGenero());
            // Mapear dirección
            DireccionDTO direccionDTO = new DireccionDTO();
            direccionDTO.setDireccionId(direccionGuardada.getDireccionId());
            direccionDTO.setCalle(direccionGuardada.getCalle());
            direccionDTO.setCiudad(direccionGuardada.getCiudad());
            direccionDTO.setEstado(direccionGuardada.getEstado());
            direccionDTO.setCodigoPostal(direccionGuardada.getCodigoPostal());
            personaDTO.setDireccion(direccionDTO);
            // Mapear empleo
            EmpleoDTO empleoDTO = new EmpleoDTO();
            empleoDTO.setEmpleoId(empleoGuardado.getEmpleoId());
            empleoDTO.setTitulo(empleoGuardado.getTitulo());
            empleoDTO.setEmpresa(empleoGuardado.getEmpresa());
            empleoDTO.setSalario(empleoGuardado.getSalario());
            personaDTO.setEmpleo(empleoDTO);

            return personaDTO;
        } catch (Exception e) {

            throw new RuntimeException("Error al crear la persona: " + e.getMessage());
        }
    }

}
