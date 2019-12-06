/**
 * Ciclo de vida de un servlet.
 * 1) Se realiza peticion al servidor web para que se ejecute el servlet.
 * 2) El servidor web crea una instancia del servlet.
 * 3) Si es que se definio un metodo init() se manda a llamar.
 * 4) Se manda a llamar al metodo service para ejecutar el servlet.
 * 5) El servlet envia una respuesta al cliente.
 */
package sga.web;

import sga.eis.dto.Persona;
import sga.eis.dto.Usuario;
import sga.services.PersonaService;
import sga.services.UsuarioService;
import sga.services.impl.PersonaServiceImpl;
import sga.services.impl.UsuarioServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Configuracion del servlet.
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
/**Se hace un extends de HttpServlet para que el servidor de aplicaciones
   reconosca esta clase como una clase valida de tipo servlet. */
public class ServletControlador extends HttpServlet {
  /*Cuando el usuario coloca la url en el navegador se genera automaticamente una peticion get.
   *Para procesar esta peticion se sobreescribe el metodo doGet.
   *HttpServletRequest y HttpServletResponse los proporciona el ciclo de vida del servlet, el metodo service es 
    el responsable de ejecutar el servlet y cuando detecta que se ejecuto un metodo de tipo get, manda a llamar al
    metodo doGet y le proporciona los parametros request(solicitud) y response(respuesta).
   *Una vez ejecutado el metodo doGet, el metodo service se encarga de enviar la respuesta hacia el cliente que
    hizo la llamada. */
    
  /**El metodo processRequest() se ejecuta si la peticion se realiza a travez de GET o POST.
    *HttpServletRequest request tiene informacion enviada en la peticion.
    *HttpServletResponse response se permite enviar una respuesta al cliente. */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Revisamos los casos de uso del sistema SGA
    String accion = request.getParameter("accion");

    if ("listarPersonas".equals(accion)) {
        //Enviamos los atributos request y response al metodo confirmarUsuarioEnSession().
        this.confirmarUsuarioEnSession(request, response);
    } else if ("validarUsuario".equals(accion)) {
        //Enviamos los atributos request y response al metodo validarUsuario().
        this.validarUsuario(request, response);
    } else if ("agregarPersona".equals(accion)) {
        //Enviamos los atributos request y response al metodo agregarPersona().
        this.agregarPersona(request, response);
    } else if ("editarPersona".equals(accion)) {
        //Enviamos los atributos request y response al metodo editarPersona().
        this.editarPersona(request, response);
    } else if ("eliminarPersona".equals(accion)) {
        //Enviamos los atributos request y response al metodo eliminarPersona().
        this.eliminarPersona(request, response);
    } else if ("guardarPersona".equals(accion)) {
        //Enviamos los atributos request y response al metodo guardarPersona().
        this.guardarPersona(request, response);
    } else if ("salir".equals(accion)) {
        //Enviamos los atributos request y response al metodo salir().
        this.salir(request, response);
    } else {
        //Enviamos los atributos request y response al metodo accionPorDefault().
        this.accionPorDefault(request, response);
    }

  }

  //Metodo para procesar validar si el usuario ya inicio sesion
  private void confirmarUsuarioEnSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Revisamos si ya está el usuario en la sesion
    HttpSession session = request.getSession();

    String usuario = (String) session.getAttribute("usuario");
    if (usuario != null) {
      //Si ya existe un usuario en session, lo redireccionamos a la lista de personas
      this.listarPersonas(request, response);
    } else {
      request.getRequestDispatcher("/WEB-INF/pages/sga/login.jsp").forward(request, response);
    }
  }

  //Metodo para procesar el caso de uso de listarPersonas
  private void listarPersonas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Revisamos si ya está el usuario en la sesion
    HttpSession session = request.getSession();

    String usuario = (String) session.getAttribute("usuario");

    //Si el usuario ya esta en session, lo redireccionamos al listado de personas
    if (usuario != null) {
      //Recuperamos el listado de personas, utilizamos el servicio de Personas
      PersonaService personaService = PersonaServiceImpl.getInstance();
      List<Persona> personas = personaService.getAllPersonas();

      //Si se encontraron personas, las compartimos en la pagina Web
      if (personas != null && personas.size() > 0) {
        request.setAttribute("listaPersonas", personas);
      }

      request.getRequestDispatcher("/WEB-INF/pages/sga/listadoPersonas.jsp").forward(request, response);
    }
  }

  //Metodo para validar si el usuario y password proporcinados son correctos
  private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Recuperamos los parametros del formulario
    String usuarioParam = request.getParameter("username");
    String passwordParam = request.getParameter("password");

    //Creamos el objeto DTO a enviar a la capa de servicio
    Usuario usuarioDto = new Usuario();
    usuarioDto.setUsername(usuarioParam);
    usuarioDto.setPassword(passwordParam);

    //Revisamos si existen el usuario y el password en la BD
    //Utilizamos el servicio de Usuarios
    UsuarioService usuarioService = UsuarioServiceImpl.getInstance();
    boolean usuarioValido = usuarioService.usuarioExistente(usuarioDto);

    //Si el usuario es válido, lo redireccionamos al caso de listarPersonas
    if (usuarioValido) {
      //Agregamos el usuario a la session
      HttpSession session = request.getSession();
      session.setAttribute("usuario", usuarioDto.getUsername());

      this.listarPersonas(request, response);
    } else {
      //si el usuario no es valido, lo mandamos a la pagina de login nuevamente
      request.setAttribute("mensaje", "El usuario o password son incorrectos");
      request.getRequestDispatcher("/WEB-INF/pages/sga/login.jsp").forward(request, response);
    }

  }

  private void salir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Eliminamos la session del servidor y redireccionamos a la pagina de inicio
    request.getSession().invalidate();
    request.getRequestDispatcher("index.jsp").forward(request, response);
  }

  private void accionPorDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Redireccionamos a la pagina de inicio
    String mensaje = "Acci&oacute;n no proporcionada o desconocida";
    request.setAttribute("mensaje", mensaje);
    request.getRequestDispatcher("index.jsp").forward(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private void agregarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //No procesamos ningun parametro, sino que solo redireccionamos a la vista
    //para agregar una nueva persona
    request.getRequestDispatcher("/WEB-INF/pages/sga/detallePersona.jsp").forward(request, response);
  }

  private void editarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String mensaje = null;

    //Recuperamos el identificador a procesar y reenviamos a la pagina de detalle
    String idPersonaParam = request.getParameter("personas");
    Integer idPersona = null;

    if (idPersonaParam != null && !idPersonaParam.trim().equals("")) {
      idPersona = new Integer(idPersonaParam);

      //Utilizamos el servicio de persona para recuperar el objeto de la BD
      PersonaService personaService = PersonaServiceImpl.getInstance();
      Persona persona = personaService.getPersonaById(idPersona);

      //compartimos el objeto persona obtenido, para poderlo modificar
      request.setAttribute("persona", persona);
      request.getRequestDispatcher("/WEB-INF/pages/sga/detallePersona.jsp").forward(request, response);

    } else {
      mensaje = "Debe seleccionar un elemento a Editar";
      request.setAttribute("mensaje", mensaje);
      //Reutilizamos el caso de listarPersonas
      this.listarPersonas(request, response);
    }

  }

  private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String mensaje = null;

    //1. Procesamos los parametros
    //Recuperamos TODOS los objetos seleccionados
    String[] idPersonaParams = request.getParameterValues("personas");
    List<Integer> idPersonas = new ArrayList<Integer>();

    //2. Utilizamos los objetos de Modelo (Persona)
    //Validamos los parametros a eliminar
    if (idPersonaParams != null && idPersonaParams.length > 0) {
      for (String persona : idPersonaParams) {
        idPersonas.add(new Integer(persona));
      }

      //3.Utilizamos la capa de servicio para eliminar los objetos
      PersonaService personaService = PersonaServiceImpl.getInstance();
      boolean registrosEliminados = personaService.eliminarPersonas(idPersonas);

      if (registrosEliminados) {
        mensaje = "Se eliminaron correctamente los registros";
      }
    } else {
      mensaje = "Debe seleccionar uno o varios elementos a Eliminar";
    }

    //4. Redireccionamos al listado de personas (ya no debe de mostrar los registros eliminados)
    request.setAttribute("mensaje", mensaje);
    this.listarPersonas(request, response);
  }

  //Este metodo nos permite insertar o modificar una persona
  //La diferencia va a estar si recibimos o no una llave primaria por parte del formulario
  private void guardarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String mensaje = null;

    //1. Procesamos los parametros
    String idPersonaParam = request.getParameter("idPersona");
    String nombreParam = request.getParameter("nombre");
    String apellidoParam = request.getParameter("apellido");

    //Validamos la PK
    Integer idPersona = null;
    if (idPersonaParam != null && !idPersonaParam.trim().equals("")) {
      idPersona = new Integer(idPersonaParam);
    }

    //2. Utilizamos el objeto Modelo
    Persona persona = new Persona();
    persona.setIdPersona(idPersona); //si no venia en los parametros, se coloca null
    persona.setNombre(nombreParam);
    persona.setApellido(apellidoParam);

    //3. Utilizamos la capa de servicio
    PersonaService personaService = PersonaServiceImpl.getInstance();
    boolean elementoGuardado = personaService.guardarPersona(persona);

    //4. Redireccionamos dependiendo del resultado
    if (elementoGuardado) {
      mensaje = "Se guard&oacute; el elemento correctamente";
      request.setAttribute("mensaje", mensaje);

    } else {
      mensaje = "No se guardo correctamente el elemento";
      request.setAttribute("mensaje", mensaje);
    }

    //Reutilizamos el caso de listarPersonas
     request.setAttribute("mensaje", mensaje);
    this.listarPersonas(request, response);

  }
}
