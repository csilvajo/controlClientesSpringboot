package cl.multiverso.spring.web;

import cl.multiverso.spring.domain.Persona;
import cl.multiverso.spring.servicio.IPersonaService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller//anotacion que permite a Spring reconocer nuestra clase como un controlador mvc
@Slf4j//anotacion que permite enviar informacion al log
public class ControladorInicio {

    @Autowired//anotacion que inyecta la capa de servicio
    private IPersonaService objPersonaService;

    /**
     * Metodo que carga la vista de inicio
     *
     * @param model
     * @param user
     * @return
     */
    @GetMapping("/")//anotacion que mapea la ruta de inicio, donde se listan los registros de personas
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        //recuperamos los objetos de tipo persona en una lista
        var listaPersonas = objPersonaService.listarPersonas();
        //se calcula el saldo total
        var saldoTotal = 0;
        for (var p : listaPersonas) {
            saldoTotal += p.getSaldo();
        }

        //informacion de log
        log.info("Ejecutando el controlador Spting MVC - muestra el listado de personas - ");
        log.info("Usuario logeado: " + user);

        //se comparten variables
        model.addAttribute("listaPersonas", listaPersonas);//se comparte la lista de personas
        model.addAttribute("saldoTotal", saldoTotal);//se comparte el saldo total        
        model.addAttribute("totalClientes", listaPersonas.size());//se comparte la cantidad total de clientes

        //se retorna la informacion al index
        return "index";
    }

    /**
     * Metodo que permite agregar y modificar un registro
     *
     * @param objPersona
     * @return
     */
    @GetMapping("/agregar")//anotacion que mapea la ruta que utilizara para agregar y modificar
    public String agregarPersona(Persona objPersona) {
        return "modificar";
    }

    /**
     * Metodo que recupera el objeto enviado por el formulario, usando el metodo
     * post. Antes de guardar, sera validado
     *
     * @param persona
     * @param errores
     * @return
     */
    @PostMapping("/guardar")//anotacion que mapea lo que envia el formulario por metodo Post
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            log.info("--------- Error al guardar ---------");
            return "modificar";
        }
        log.info("---- Paso por guardar sin errores ---------");
        objPersonaService.guardarPersona(persona);
        return "redirect:/";
    }

    /**
     * Metodo que recupera un registro de una persona para ser modificado
     *
     * @param objPersona
     * @param model
     * @return
     */
    @GetMapping("/editar/{idPersona}")//anotacion que mapea el registro a editar 
    public String editar(Persona objPersona, Model model) {
        objPersona = objPersonaService.encontrarPersona(objPersona);
        model.addAttribute("persona", objPersona);
        return "modificar";
    }

    /**
     * Metodo que elimina el registro de una persona
     *
     * @param objPersona
     * @return
     */
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona objPersona) {
        objPersonaService.eliminarPersona(objPersona);
        return "redirect:/";
    }

}//fin clase
