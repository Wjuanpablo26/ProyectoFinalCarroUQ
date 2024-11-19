package co.edu.uniquindio.poo.proyectofinalcarrouq.Utils;

import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.*;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Abstract.Vehiculo;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Combustible.*;
import co.edu.uniquindio.poo.proyectofinalcarrouq.Model.Enum.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Persistencia {

    // Rutas de los archivos
    public static final String rutaClientes = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/clientes.txt";
    public static final String rutaAdmins = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/admins.txt";
    public static final String rutaEmpleados = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/empleado.txt";
    public static final String rutaSedans = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/sedan.txt";
    public static final String rutaMotos = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/motos.txt";
    public static final String rutaDeportivos = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/deportivo.txt";
    public static final String rutaCamionetas = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/camionetas.txt";
    public static final String rutaPickUps = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/pickUps.txt";
    public static final String rutaVans = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/vans.txt";
    public static final String rutaBuses = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/buses.txt";
    public static final String rutaCamiones = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/camiones.txt";
    public static final String rutaVentas = "src/main/resources/co/edu/uniquindio/poo/proyectofinalcarrouq/DataBase/venta.txt";

    // Método para guardar el Empleado
    public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (Empleado empleado : listaEmpleados) {
            contenido.append(empleado.getCedula()).append(" %% ")
                    .append(empleado.getNombre()).append(" %% ")
                    .append(empleado.getCorreo()).append(" %% ")
                    .append(empleado.getGenero().toString()).append(" %% ")// "Genero" es un enum
                    .append(empleado.getEdad()).append(" %% ")
                    .append(empleado.getUserName().getUsername()).append(" %% ")// Se accede al atributo "UserName"
                    .append(empleado.getUserName().getPassword()).append(" %% ")
                    .append(empleado.getFechaContratacion().toString())// Configuramos la fecha como un String
                    .append("\n");
        }

        ArchivoUtils.guardarArchivo(rutaEmpleados, contenido.toString(), false);
    }

    // Método para cargar los empleados
    public static ArrayList<Empleado> cargarEmpleados() throws IOException {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaEmpleados);

        for (String linea : contenido) {
            // Divide las líneas en partes con el " %% " como separador
            String[] partes = linea.split(" %% ");

            if (partes.length < 8) {
                continue;// Si no hay partes suficientes, pasa a la siguiente línea
            }

            // Crear un nuevo empleado y establecer a sus atributos
            Empleado empleado = new Empleado(
                    partes[0], // Cédula
                    partes[1], // Nombre
                    partes[2], // Correo
                    Genero.valueOf(partes[3]), // Género (suponiendo que "Genero" es un enum)
                    Integer.parseInt(partes[4]), // Edad
                    new UserName(partes[5], partes[6]), // UserName (suponiendo que UserName tiene constructor con
                                                        // username y password)
                    LocalDate.parse(partes[7])// FechaContratacion
            );
            // Añadir el empleado a la lista
            listaEmpleados.add(empleado);
        }
        return listaEmpleados;
    }

    // Métodos para guardar los administradores
    public static void guardarAdministradores(ArrayList<Admin> listaAdministradores) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Admin admin : listaAdministradores) {
            contenido.append(admin.getCedula()).append(" %% ")
                    .append(admin.getNombre()).append(" %% ")
                    .append(admin.getCorreo()).append(" %% ")
                    .append(admin.getGenero().toString()).append(" %% ") // Genero es un enum
                    .append(admin.getEdad()).append(" %% ")
                    .append(admin.getUserName().getUsername()).append(" %% ") // Accedemos al atributo de UserName
                    .append(admin.getUserName().getPassword()) // Guardamos el password del UserName
                    .append("\n");
        }

        ArchivoUtils.guardarArchivo(rutaAdmins, contenido.toString(), false);
    }

    // Método para cargar los administradores
    public static ArrayList<Admin> cargarAdministradores() throws IOException {
        ArrayList<Admin> listaAdministradores = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaAdmins);

        for (String linea : contenido) {
            // Divide la línea en partes usando " %% " como separador
            String[] partes = linea.split(" %% ");

            if (partes.length < 7) {
                continue; // Si no hay suficientes partes, pasa a la siguiente línea
            }

            // Crear un nuevo administrador y establecer sus atributos
            Admin admin = new Admin(
                    partes[0], // Cédula
                    partes[1], // Nombre
                    partes[2], // Correo
                    Genero.valueOf(partes[3]), // Genero (suponiendo que Genero es un enum)
                    Integer.parseInt(partes[4]), // Edad
                    new UserName(partes[5], partes[6]) // UserName (suponiendo que UserName tiene constructor con
                                                       // username y password)
            );

            // Añadir el administrador a la lista
            listaAdministradores.add(admin);
        }
        return listaAdministradores;
    }

    // Metodo para guardar el Cliente
    public static void guardarClientes(ArrayList<Cliente> listaClientes) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Cliente cliente : listaClientes) {
            contenido.append(cliente.getCedula()).append(" %% ")
                    .append(cliente.getNombre()).append(" %% ")
                    .append(cliente.getCorreo()).append(" %% ")
                    .append(cliente.getGenero().toString()).append(" %% ") // Genero es un enum
                    .append(cliente.getEdad()).append(" %% ")
                    .append(cliente.getFechaRegistro().toString()) // Convertimos LocalDate a String
                    .append("\n");
        }

        ArchivoUtils.guardarArchivo(rutaClientes, contenido.toString(), false);
    }

    // Método para cargar los clientes
    public static ArrayList<Cliente> cargarClientes() throws IOException {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaClientes); // Cambia `rutaClientesTxt` a la ruta que
                                                                               // se use para cargar clientes

        for (String linea : contenido) {
            // Dividir la línea en partes usando " %% " como separador
            String[] partes = linea.split(" %% ");

            if (partes.length < 6) {
                continue; // Si no hay suficientes partes, pasa a la siguiente línea
            }

            // Crea un nuevo cliente y establece sus atributos
            Cliente cliente = new Cliente(
                    partes[0], // Cédula
                    partes[1], // Nombre
                    partes[2], // Correo
                    Genero.valueOf(partes[3]), // Genero (suponiendo que Genero es un enum)
                    Integer.parseInt(partes[4]), // Edad
                    LocalDate.parse(partes[5]) // Convertimos el String a LocalDate
            );
            // Añadir el cliente a la lista
            listaClientes.add(cliente);
        }
        return listaClientes;
    }

    // Métodos para guardar el Sedan
    public static void guardarSedanes(ArrayList<Sedan> listaSedanes) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Sedan sedan : listaSedanes) {
            contenido.append(sedan.getPlaca()).append(" %% ")
                    .append(sedan.getMarca()).append(" %% ")
                    .append(sedan.isEsNuevo()).append(" %% ")
                    .append(sedan.getModelo()).append(" %% ")
                    .append(sedan.getTiposCambios()).append(" %% ")
                    .append(sedan.getVelocidadMax()).append(" %% ")
                    .append(sedan.getCilindraje()).append(" %% ")
                    .append(sedan.getNumPasajeros()).append(" %% ")
                    .append(sedan.getNumPuertas()).append(" %% ")
                    .append(sedan.getCombustible().getTipoCombustible()).append(" %% ") // Se guarda solo el tipo de
                                                                                        // combustible
                    .append(sedan.getTipoEstado()).append(" %% ") // Se guarda el estado del vehículo
                    .append(sedan.getImagen()).append(" %% ") // Se guarda la imagen
                    .append(sedan.isTieneAcondicionado()).append(" %% ") // Acondicionado
                    .append(sedan.isTieneCamaraReversa()).append(" %% ") // Cámara Reversa
                    .append(sedan.isTieneVelocidadCrucero()).append(" %% ") // Velocidad Crucero
                    .append(sedan.getNumeroBolsaAire()).append(" %% ") // Número de bolsas de aire
                    .append(sedan.isTieneABS()).append(" %% ") // ABS
                    .append(sedan.isEs4x4()).append(" %% ") // Es 4x4
                    .append(sedan.isTieneSensorColision()).append(" %% ") // Sensor de Colisión
                    .append(sedan.isTieneSensorTraficoCruzado()).append(" %% ") // Sensor de Tráfico Cruzado
                    .append(sedan.isTieneAsistentePermanencia()).append(" %% ") // Asistente de Permanencia
                    .append(sedan.getCapacidadMaletero()).append(" %% "); // Capacidad de maletero (se guarda solo el
                                                                          // tipo de combustible)

            // Aquí se guardan los atributos específicos del combustible si es necesario
            if (sedan.getCombustible() instanceof Hibrido) {
                Hibrido hibrido = (Hibrido) sedan.getCombustible();
                contenido.append(hibrido.isEsEnchufable()).append(" %% ");
            } else if (sedan.getCombustible() instanceof Electrico) {
                Electrico electrico = (Electrico) sedan.getCombustible();
                contenido.append(electrico.getAutonomia()).append(" %% ").append(electrico.getTiempoCarga())
                        .append(" %% ");
            }
            contenido.append("\n");
        }
        ArchivoUtils.guardarArchivo(rutaSedans, contenido.toString(), false);
    }

    // Método para cargar los Sedanes
    public static ArrayList<Sedan> cargarSedanes() throws IOException {
        ArrayList<Sedan> listaSedanes = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaSedans);

        for (String liena : contenido) {
            // Divide la línea en partes usando " %% " como separador
            String[] partes = liena.split(" %% ");

            if (partes.length < 21) {
                continue;// Si no hay suficientes partes, pasa a la siguiente línea
            }

            // Se ccrea un nuevo objeto Combustible
            String tipoCombustible = partes[9];
            Combustible combustible = null;

            // Determina el tipo de combustible
            if (tipoCombustible.equals("HÍBRIDO")) {
                boolean esEnchufable = Boolean.parseBoolean(partes[22]);
                boolean esHibridoLigero = Boolean.parseBoolean(partes[23]);
                combustible = new Hibrido(TipoCombustible.valueOf(partes[9]), esEnchufable, esHibridoLigero);
            } else if (tipoCombustible.equals("ELÉCTRICO")) {
                int autonomia = Integer.parseInt(partes[22]);
                int tiempoCarga = Integer.parseInt(partes[23]);
                combustible = new Electrico(TipoCombustible.valueOf(partes[9]), autonomia, tiempoCarga);
            } else if (tipoCombustible.equals("DIESEL")) {
                combustible = new Diesel(TipoCombustible.valueOf(partes[9]));
            } else if (tipoCombustible.equals("GASOLINA")) {
                combustible = new Gasolina(TipoCombustible.valueOf(partes[9]));
            }

            // Crear un nuevo Sedan y establecer sus atributos utilizando los setters
            Sedan sedan = new Sedan();
            sedan.setPlaca(partes[0]); // placa
            sedan.setMarca(partes[1]); // marca
            sedan.setEsNuevo(Boolean.parseBoolean(partes[2])); // esNuevo
            sedan.setModelo(partes[3]); // modelo
            sedan.setTiposCambios(TipoCambios.valueOf(partes[4])); // tiposCambios
            sedan.setVelocidadMax(Float.parseFloat(partes[5])); // velocidadMax
            sedan.setCilindraje(Float.parseFloat(partes[6])); // cilindraje
            sedan.setNumPasajeros(Integer.parseInt(partes[7])); // numPasajeros
            sedan.setNumPuertas(Integer.parseInt(partes[8])); // numPuertas
            sedan.setCombustible(combustible); // combustible
            sedan.setTipoEstado(TipoEstado.valueOf(partes[10])); // tipoEstado
            sedan.setImagen(partes[11]); // imagen
            sedan.setTieneAcondicionado(Boolean.parseBoolean(partes[12])); // tieneAcondicionado
            sedan.setTieneCamaraReversa(Boolean.parseBoolean(partes[13])); // tieneCamaraReversa
            sedan.setTieneVelocidadCrucero(Boolean.parseBoolean(partes[14])); // tieneVelocidadCrucero
            sedan.setNumeroBolsaAire(Integer.parseInt(partes[15])); // numeroBolsaAire
            sedan.setTieneABS(Boolean.parseBoolean(partes[16])); // tieneABS
            sedan.setEs4x4(false); // no es 4x4
            sedan.setTieneSensorColision(Boolean.parseBoolean(partes[18])); // tieneSensorColision
            sedan.setTieneSensorTraficoCruzado(Boolean.parseBoolean(partes[19])); // tieneSensorTraficoCruzado
            sedan.setTieneAsistentePermanencia(Boolean.parseBoolean(partes[20])); // tieneAsistentePermanencia
            sedan.setCapacidadMaletero(Float.parseFloat(partes[21])); // capacidadMaletero

            // Agregar el objeto Sedan a la lista
            listaSedanes.add(sedan);
        }

        return listaSedanes;
    }

    // Métodos para guardar la Moto
    public static void guardarMotos(ArrayList<Moto> listaMotos) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Moto moto : listaMotos) {
            contenido.append(moto.getPlaca()).append(" %% ")
                    .append(moto.getMarca()).append(" %% ")
                    .append(moto.isEsNuevo()).append(" %% ")
                    .append(moto.getModelo()).append(" %% ")
                    .append(moto.getTiposCambios()).append(" %% ")
                    .append(moto.getVelocidadMax()).append(" %% ")
                    .append(moto.getCilindraje()).append(" %% ")
                    .append(moto.getNumPasajeros()).append(" %% ") // Este valor es 2 por defecto para motos
                    .append(moto.getNumPuertas()).append(" %% ") // Este valor es 0 por defecto para motos
                    .append(moto.getCombustible().getTipoCombustible()).append(" %% ") // Tipo de combustible
                    .append(moto.getTipoEstado()).append(" %% ") // Estado del vehículo
                    .append(moto.getImagen()).append(" %% "); // Imagen del vehículo

            // Aquí vamos a guardar los atributos específicos del combustible si es
            // necesario
            if (moto.getCombustible() instanceof Hibrido) {
                Hibrido hibrido = (Hibrido) moto.getCombustible();
                contenido.append(hibrido.isEsEnchufable()).append(" %% ")
                        .append(hibrido.isEsHibridoLigero()).append(" %% ");
            } else if (moto.getCombustible() instanceof Electrico) {
                Electrico electrico = (Electrico) moto.getCombustible();
                contenido.append(electrico.getAutonomia()).append(" %% ")
                        .append(electrico.getTiempoCarga()).append(" %% ");
            }

            contenido.append("\n");
        }

        ArchivoUtils.guardarArchivo(rutaMotos, contenido.toString(), false);
    }

    // Método para cargar las motos
    public static ArrayList<Moto> cargarMotos() throws IOException {
        ArrayList<Moto> listaMotos = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaMotos);

        for (String linea : contenido) {
            // Divide la línea en partes usando " %% " como separador
            String[] partes = linea.split(" %% ");

            if (partes.length < 10) {
                continue;// Si no hay suficientes partes, pasa a la siguiente línea
            }

            // Crear un nuevo objeto Combustible
            String tipoCombustible = partes[9];
            Combustible combustible = null;

            // Determinr el tipo de combustible
            if (tipoCombustible.equals("HÍBRIDO")) {
                boolean esEnchufable = Boolean.parseBoolean(partes[12]);
                boolean esHibridoLigero = Boolean.parseBoolean(partes[13]);
                combustible = new Hibrido(TipoCombustible.valueOf(partes[9]), esEnchufable, esHibridoLigero);
            } else if (tipoCombustible.equals("ELÉCTRICO")) {
                int autonomia = Integer.parseInt(partes[12]);
                int tiempoCarga = Integer.parseInt(partes[13]);
                combustible = new Electrico(TipoCombustible.valueOf(partes[9]), autonomia, tiempoCarga);
            } else if (tipoCombustible.equals("DIESEL")) {
                combustible = new Diesel(TipoCombustible.valueOf(partes[9]));
            } else if (tipoCombustible.equals("GASOLINA")) {
                combustible = new Gasolina(TipoCombustible.valueOf(partes[9]));
            }

            // Crear un nuevo objeto Moto usando el constructor y los datos leídos
            Moto moto = new Moto();
            moto.setPlaca(partes[0]);
            moto.setMarca(partes[1]);
            moto.setEsNuevo(Boolean.parseBoolean(partes[2]));
            moto.setModelo(partes[3]);
            moto.setTiposCambios(TipoCambios.valueOf(partes[4]));
            moto.setVelocidadMax(Float.parseFloat(partes[5]));
            moto.setCilindraje(Float.parseFloat(partes[6]));
            moto.setNumPasajeros(Integer.parseInt(partes[7]));
            moto.setNumPuertas(Integer.parseInt(partes[8]));
            moto.setCombustible(combustible);
            moto.setTipoEstado(TipoEstado.valueOf(partes[10]));
            moto.setImagen(partes[11]);

            // Agregar la moto a la lista
            listaMotos.add(moto);
        }
        return listaMotos;
    }

    // Métodos para guardar los deportivos
    public static void guardarDeportivos(ArrayList<Deportivo> listaDeportivos) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Deportivo deportivo : listaDeportivos) {
            contenido.append(deportivo.getPlaca()).append(" %% ")
                    .append(deportivo.getMarca()).append(" %% ")
                    .append(deportivo.isEsNuevo()).append(" %% ")
                    .append(deportivo.getModelo()).append(" %% ")
                    .append(deportivo.getTiposCambios()).append(" %% ")
                    .append(deportivo.getVelocidadMax()).append(" %% ")
                    .append(deportivo.getCilindraje()).append(" %% ")
                    .append(deportivo.getNumPasajeros()).append(" %% ")
                    .append(deportivo.getNumPuertas()).append(" %% ")
                    .append(deportivo.getCombustible().getTipoCombustible()).append(" %% ")
                    .append(deportivo.getImagen()).append(" %% ")
                    .append(deportivo.getTipoEstado()).append(" %% ")
                    .append(deportivo.getNumBolsasAire()).append(" %% ")
                    .append(deportivo.getNumCaballosFuerza()).append(" %% ")
                    .append(deportivo.getTiempoAceleracion()).append(" %% ")
                    .append(deportivo.isTieneAerodinamicaMejorada()).append(" %% ");

            // Aquí vamos se guardan los atributos específicos del combustible si es necesario
            if (deportivo.getCombustible() instanceof Hibrido) {
                Hibrido hibrido = (Hibrido) deportivo.getCombustible();
                contenido.append(hibrido.isEsEnchufable()).append(" %% ")
                        .append(hibrido.isEsHibridoLigero()).append(" %% ");
            } else if (deportivo.getCombustible() instanceof Electrico) {
                Electrico electrico = (Electrico) deportivo.getCombustible();
                contenido.append(electrico.getAutonomia()).append(" %% ")
                        .append(electrico.getTiempoCarga()).append(" %% ");
            }
            contenido.append("\n");
        }

        ArchivoUtils.guardarArchivo(rutaDeportivos, contenido.toString(), false);
    }

    // Método para cargar los deportivos
    public static ArrayList<Deportivo> cargarDeportivos() throws IOException {
        ArrayList<Deportivo> listaDeportivos = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaDeportivos);

        for (String linea : contenido) {
            String[] partes = linea.split(" %% ");

            if (partes.length < 16) {
                continue; // Si no hay suficientes partes, pasa a la siguiente línea
            }

            // Crear una instancia vacía de Deportivo
            Deportivo deportivo = new Deportivo();

            // Usar los métodos set para asignar los valores
            deportivo.setPlaca(partes[0]);
            deportivo.setMarca(partes[1]);
            deportivo.setEsNuevo(Boolean.parseBoolean(partes[2]));
            deportivo.setModelo(partes[3]);
            deportivo.setTiposCambios(TipoCambios.valueOf(partes[4]));
            deportivo.setVelocidadMax(Float.parseFloat(partes[5]));
            deportivo.setCilindraje(Float.parseFloat(partes[6]));
            deportivo.setNumPasajeros(Integer.parseInt(partes[7]));
            deportivo.setNumPuertas(Integer.parseInt(partes[8]));

            // Crear un nuevo objeto Combustible
            String tipoCombustible = partes[9];
            Combustible combustible = null;

            // Determinar el tipo de combustible
            if (tipoCombustible.equals("HÍBRIDO")) {
                boolean esEnchufable = Boolean.parseBoolean(partes[16]);
                boolean esHibridoLigero = Boolean.parseBoolean(partes[17]);
                combustible = new Hibrido(TipoCombustible.valueOf(partes[9]), esEnchufable, esHibridoLigero);
            } else if (tipoCombustible.equals("ELÉCTRICO")) {
                int autonomia = Integer.parseInt(partes[16]);
                int tiempoCarga = Integer.parseInt(partes[17]);
                combustible = new Electrico(TipoCombustible.valueOf(partes[9]), autonomia, tiempoCarga);
            } else if (tipoCombustible.equals("DIESEL")) {
                combustible = new Diesel(TipoCombustible.valueOf(partes[9]));
            } else if (tipoCombustible.equals("GASOLINA")) {
                combustible = new Gasolina(TipoCombustible.valueOf(partes[9]));
            }
            deportivo.setCombustible(combustible);

            deportivo.setImagen(partes[10]);
            deportivo.setTipoEstado(TipoEstado.valueOf(partes[11]));
            deportivo.setNumBolsasAire(Integer.parseInt(partes[12]));
            deportivo.setNumCaballosFuerza(Integer.parseInt(partes[13]));
            deportivo.setTiempoAceleracion(Double.parseDouble(partes[14]));
            deportivo.setTieneAerodinamicaMejorada(Boolean.parseBoolean(partes[15]));

            // Agregar el deportivo a la lista
            listaDeportivos.add(deportivo);
        }

        return listaDeportivos;
    }

    //Métodos para guardar las Camionetas
    public static void guardarCamionetas(ArrayList<Camioneta> listaCamionetas) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Camioneta camioneta : listaCamionetas) {
            contenido.append(camioneta.getPlaca()).append(" %% ")
                    .append(camioneta.getMarca()).append(" %% ")
                    .append(camioneta.isEsNuevo()).append(" %% ")
                    .append(camioneta.getModelo()).append(" %% ")
                    .append(camioneta.getTiposCambios()).append(" %% ")
                    .append(camioneta.getVelocidadMax()).append(" %% ")
                    .append(camioneta.getCilindraje()).append(" %% ")
                    .append(camioneta.getNumPasajeros()).append(" %% ")
                    .append(camioneta.getNumPuertas()).append(" %% ")
                    .append(camioneta.getCombustible().getTipoCombustible()).append(" %% ")
                    .append(camioneta.getImagen()).append(" %% ")
                    .append(camioneta.getTipoEstado()).append(" %% ")
                    .append(camioneta.isTieneAcondicionado()).append(" %% ")
                    .append(camioneta.isTieneCamaraReversa()).append(" %% ")
                    .append(camioneta.isTieneVelocidadCrucero()).append(" %% ")
                    .append(camioneta.getNumeroBolsaAire()).append(" %% ")
                    .append(camioneta.isTieneABS()).append(" %% ")
                    .append(camioneta.isEs4x4()).append(" %% ")
                    .append(camioneta.isTieneSensorColision()).append(" %% ")
                    .append(camioneta.isTieneSensorTraficoCruzado()).append(" %% ")
                    .append(camioneta.isTieneAsistentePermanencia()).append(" %% ")
                    .append(camioneta.getCapacidadMaletero()).append(" %% ");

            // Guarda atributos específicos del tipo de combustible si es necesario
            if (camioneta.getCombustible() instanceof Hibrido) {
                Hibrido hibrido = (Hibrido) camioneta.getCombustible();
                contenido.append(hibrido.isEsEnchufable()).append(" %% ")
                        .append(hibrido.isEsHibridoLigero()).append(" %% ");
            } else if (camioneta.getCombustible() instanceof Electrico) {
                Electrico electrico = (Electrico) camioneta.getCombustible();
                contenido.append(electrico.getAutonomia()).append(" %% ")
                        .append(electrico.getTiempoCarga()).append(" %% ");
            }

            contenido.append("\n");
        }
        
        // Guarda el contenido en el archivo especificado
        ArchivoUtils.guardarArchivo(rutaCamionetas, contenido.toString(), false);
    }

    // Método para cargar las camionetas
    public static ArrayList<Camioneta> cargarCamionetas() throws IOException{
        ArrayList<Camioneta> listaCamionetas = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaCamionetas);

        for (String linea : contenido){
            String[] partes = linea.split("%%");

            if(partes.length < 22){
                continue; //si no hay suficientes partes, pasar a la siguiente linea
            }

            // crear una instancia vacia de camionetas
            Camioneta camioneta = new Camioneta();
            
            //usar los metodos set para asignar los valores
            camioneta.setPlaca(partes[0]);
            camioneta.setMarca(partes[1]);
            camioneta.setEsNuevo(Boolean.parseBoolean(partes[2]));
            camioneta.setModelo(partes[3]);
            camioneta.setTiposCambios(TipoCambios.valueOf(partes[4]));
            camioneta.setVelocidadMax(Float.parseFloat(partes[5]));
            camioneta.setCilindraje(Float.parseFloat(partes[6]));
            camioneta.setNumPasajeros(Integer.parseInt(partes[7]));
            camioneta.setNumPuertas(Integer.parseInt(partes[8]));

            // crear un nuevo objeto combustible
            String tipoCombustible = partes [9];
            Combustible combustible = null;

            //determinar el tipo de combustible
            if (tipoCombustible.equals("HÍBRIDO")){
                boolean esEnchufable = Boolean.parseBoolean(partes[22]);
                boolean esHibridoLigero = Boolean.parseBoolean(partes[23]);
                combustible = new Hibrido(TipoCombustible.valueOf(partes[9]), esEnchufable, esHibridoLigero);
            } else if(tipoCombustible.equals("ELÉCTRICO")) {
                int autonomia = Integer.parseInt(partes[22]);
                int tiempoCarga = Integer.parseInt(partes[23]);
                combustible = new Electrico(TipoCombustible.valueOf(partes[9]), autonomia, tiempoCarga);
            }else if (tipoCombustible.equals("DIESEL")){
                combustible = new Diesel(TipoCombustible.valueOf(partes[9]));
            }else if (tipoCombustible.equals("GASOLINA")){
                combustible = new Gasolina(TipoCombustible.valueOf(partes[9]));
            }
            camioneta.setCombustible(combustible);
            camioneta.setTipoEstado(TipoEstado.valueOf(partes[11]));
            camioneta.setTieneAcondicionado(Boolean.parseBoolean(partes[12]));
            camioneta.setTieneCamaraReversa(Boolean.parseBoolean(partes[13]));
            camioneta.setTieneVelocidadCrucero(Boolean.parseBoolean(partes[14]));
            camioneta.setNumeroBolsaAire(Integer.parseInt(partes[15]));
            camioneta.setTieneABS(Boolean.parseBoolean(partes[16]));
            camioneta.setEs4x4(Boolean.parseBoolean(partes[17]));
            camioneta.setTieneSensorColision(Boolean.parseBoolean(partes[18]));
            camioneta.setTieneSensorTraficoCruzado(Boolean.parseBoolean(partes[19]));
            camioneta.setTieneAsistentePermanencia(Boolean.parseBoolean(partes[20]));
            camioneta.setCapacidadMaletero(Float.parseFloat(partes[21]));

            //Agregar camioneta a la lista
            listaCamionetas.add(camioneta);
        }

        return listaCamionetas;
    }

    // Métodos para guardar las PickUps
    public static void guardarPickUps(ArrayList<PickUps> listaPickUps) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for(PickUps pickUp : listaPickUps){
            contenido.append(pickUp.getPlaca()).append(" %%")
                    .append(pickUp.getMarca()).append(" %% ")
                    .append(pickUp.isEsNuevo()).append(" %% ")
                    .append(pickUp.getModelo()).append(" %% ")
                    .append(pickUp.getTiposCambios()).append(" %% ")
                    .append(pickUp.getVelocidadMax()).append(" %% ")
                    .append(pickUp.getCilindraje()).append(" %% ")
                    .append(pickUp.getNumPasajeros()).append(" %% ")
                    .append(pickUp.getNumPuertas()).append(" %% ")
                    .append(pickUp.getCombustible().getTipoCombustible()).append(" %% ")
                    .append(pickUp.getImagen()).append(" %% ")
                    .append(pickUp.getTipoEstado()).append(" %% ")
                    .append(pickUp.isTieneAcondicionado()).append(" %% ")
                    .append(pickUp.isTieneCamaraReversa()).append(" %% ")
                    .append(pickUp.isTieneVelocidadCrucero()).append(" %% ")
                    .append(pickUp.getNumeroBolsaAire()).append(" %% ")
                    .append(pickUp.isTieneABS()).append(" %% ")
                    .append(pickUp.isEs4x4()).append(" %% ")
                    .append(pickUp.getCapacidadCajaCarga()).append(" %% ");

            // Guardar los atributos especificos del combustible
            if (pickUp.getCombustible() instanceof Hibrido){
                Hibrido hibrido = (Hibrido) pickUp.getCombustible();
                contenido.append(hibrido.isEsEnchufable()).append(" %% ")
                        .append(hibrido.isEsHibridoLigero()).append(" %% ");
            } else if (pickUp.getCombustible() instanceof Electrico){
                Electrico electrico = (Electrico) pickUp.getCombustible();
                contenido.append(electrico.getAutonomia()).append(" %% ")
                        .append(electrico.getTiempoCarga()).append(" %% ");
            }

            contenido.append("\n"); // Nueva linea para cada PickUp
        }

        ArchivoUtils.guardarArchivo(rutaPickUps, contenido.toString(), false);
    }

    //metodo para cargar las PickUps
    public static ArrayList<PickUps> cargarPickUps() throws IOException {
        ArrayList<PickUps> listaPickUps = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaPickUps);

        for(String linea : contenido){
            String[] partes = linea.split(" %% ");

            if(partes.length < 19){
                continue; // si no hay suficientes partes, pasar a la siguiente linea
            }

            //crear una instancia vacia de PickUps
            PickUps pickUp = new PickUps();

            //usar los metodos set para asignar valores 
            pickUp.setPlaca(partes[0]);
            pickUp.setMarca(partes[1]);
            pickUp.setEsNuevo(Boolean.parseBoolean(partes[2]));
            pickUp.setModelo(partes[3]);
            pickUp.setTiposCambios(TipoCambios.valueOf(partes[4]));
            pickUp.setVelocidadMax(Float.parseFloat(partes[5]));
            pickUp.setCilindraje(Float.parseFloat(partes[6]));
            pickUp.setNumPasajeros(Integer.parseInt(partes[7]));
            pickUp.setNumPuertas(Integer.parseInt(partes[8]));

            //crear un nuevo objeto combustible
            String tipoCombustible = partes[9];
            Combustible combustible = null;

            //determinar el tipo de combustible
            if(tipoCombustible.equals("HÍBRIDO")){
                boolean esEnchufable = Boolean.parseBoolean(partes[19]);
                boolean esHibridoLigero = Boolean.parseBoolean(partes[20]);
                combustible = new Hibrido(TipoCombustible.valueOf(partes[9]), esEnchufable, esHibridoLigero);
            } else if (tipoCombustible.equals("ELÉCTRICO")) {
                int autonomia = Integer.parseInt(partes[19]);
                int tiempoCarga = Integer.parseInt(partes[20]);
                combustible = new Electrico(TipoCombustible.valueOf(partes[9]), autonomia, tiempoCarga);
            } else if (tipoCombustible.equals("DIESEL")){
                combustible = new Diesel(TipoCombustible.valueOf(partes[9]));
            } else if (tipoCombustible.equals("GASOLINA")) {
                combustible = new Gasolina(TipoCombustible.valueOf(partes[9]));
            }
            pickUp.setCombustible(combustible);

            pickUp.setImagen(partes[10]);
            pickUp.setTipoEstado(TipoEstado.valueOf(partes[11]));
            pickUp.setTieneAcondicionado(Boolean.parseBoolean(partes[12]));
            pickUp.setTieneCamaraReversa(Boolean.parseBoolean(partes[13]));
            pickUp.setTieneVelocidadCrucero(Boolean.parseBoolean(partes[14]));
            pickUp.setNumeroBolsaAire(Integer.parseInt(partes[15]));
            pickUp.setTieneABS(Boolean.parseBoolean(partes[16]));
            pickUp.setEs4x4(Boolean.parseBoolean(partes[17]));
            pickUp.setCapacidadCajaCarga(Float.parseFloat(partes[18]));

            // Agregar el objeto PickUps a ls lista
            listaPickUps.add(pickUp);
        }

        return listaPickUps;
    }

    //metodo para guardar las vans
    public static void guardarVans(ArrayList<Vans> listaVans) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for(Vans van : listaVans){
            contenido.append(van.getPlaca()).append(" %% ")
                    .append(van.getMarca()).append(" %% ")
                    .append(van.isEsNuevo()).append(" %% ")
                    .append(van.getModelo()).append(" %% ")
                    .append(van.getTiposCambios()).append(" %% ")
                    .append(van.getVelocidadMax()).append(" %% ")
                    .append(van.getCilindraje()).append(" %% ")
                    .append(van.getNumPasajeros()).append(" %% ")
                    .append(van.getNumPuertas()).append(" %% ")
                    .append(van.getCombustible().getTipoCombustible()).append(" %% ")
                    .append(van.getImagen()).append(" %% ")
                    .append(van.getTipoEstado()).append(" %% ")
                    .append(van.isTieneAcondicionado()).append(" %% ")
                    .append(van.isTieneCamaraReversa()).append(" %% ")
                    .append(van.isTieneVelocidadCrucero()).append(" %% ")
                    .append(van.getNumeroBolsaAire()).append(" %% ")
                    .append(van.isTieneABS()).append(" %% ")
                    .append(van.isEs4x4()).append(" %% ")
                    .append(van.getCapacidadMaletero()).append(" %% ");

            // guardar los atributos especificos del combustible
            if (van.getCombustible() instanceof Hibrido){
                Hibrido hibrido = (Hibrido) van.getCombustible();
                contenido.append(hibrido.isEsEnchufable()).append(" %% ")
                    .append(hibrido.isEsHibridoLigero()).append(" %% ");
            } else if (van.getCombustible() instanceof Electrico){
                Electrico electrico = (Electrico) van.getCombustible();
                contenido.append(electrico.getAutonomia()).append(" %% ")
                    .append(electrico.getTiempoCarga()).append(" %% ");
            }

            contenido.append("\n"); // nueva linea para cada van
        }

        ArchivoUtils.guardarArchivo(rutaVans, contenido.toString(), false);
    }

    //metodo para cargar las vans
    public static ArrayList<Vans> cargarVans() throws IOException{
        ArrayList<Vans> listaVans = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaVans);

        for(String linea : contenido){
            String[] partes = linea.split(" %% ");

            if(partes.length < 19){
                continue; // verifica que haya suficientes partes
            }

            // crear una instancia vacia de vans
            Vans van = new Vans();

            //usar metodos set para asignar los valores
            van.setPlaca(partes[0]);
            van.setMarca(partes[1]);
            van.setEsNuevo(Boolean.parseBoolean(partes[2]));
            van.setModelo(partes[3]);
            van.setTiposCambios(TipoCambios.valueOf(partes[4]));
            van.setVelocidadMax(Float.parseFloat(partes[5]));
            van.setCilindraje(Float.parseFloat(partes[6]));
            van.setNumPasajeros(Integer.parseInt(partes[7]));
            van.setNumPuertas(Integer.parseInt(partes[8]));

            //crear un nuevo objeto combustible
            String tipoCombustible = partes [9];
            Combustible combustible = null;

            // determinar el tipo de combustible
            if(tipoCombustible.equals("HÍBRIDO")){
                boolean esEnchufable = Boolean.parseBoolean(partes[19]);
                boolean esHibridoLigero = Boolean.parseBoolean(partes[20]);
                combustible = new Hibrido(TipoCombustible.valueOf(partes[9]), esEnchufable, esHibridoLigero);
            } else if (tipoCombustible.equals("ELÉCTRICO")) {
                int autonomia = Integer.parseInt(partes[19]);
                int tiempoCarga = Integer.parseInt(partes[20]);
                combustible = new Electrico(TipoCombustible.valueOf(partes[9]), autonomia, tiempoCarga);
            } else if (tipoCombustible.equals("DIESEL")){
                combustible = new Diesel(TipoCombustible.valueOf(partes[9]));
            } else if (tipoCombustible.equals("GASOLINA")) {
                combustible = new Gasolina(TipoCombustible.valueOf(partes[9]));
            }
            van.setCombustible(combustible);

            van.setImagen(partes[10]);
            van.setTipoEstado(TipoEstado.valueOf(partes[11]));
            van.setTieneAcondicionado(Boolean.parseBoolean(partes[12]));
            van.setTieneCamaraReversa(Boolean.parseBoolean(partes[13]));
            van.setTieneVelocidadCrucero(Boolean.parseBoolean(partes[14]));
            van.setNumeroBolsaAire(Integer.parseInt(partes[15]));
            van.setTieneABS(Boolean.parseBoolean(partes[16]));
            van.setEs4x4(Boolean.parseBoolean(partes[17]));
            van.setCapacidadMaletero(Float.parseFloat(partes[18]));

            // Agregar el objeto PickUps a ls lista
            listaVans.add(van);
        }

        return listaVans;
        
    }

    // Métodos para guardar los Buses
    public static void guardarBuses(ArrayList<Bus> listaBuses) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Bus bus : listaBuses) {
            contenido.append(bus.getPlaca()).append(" %% ")
                    .append(bus.getMarca()).append(" %% ")
                    .append(bus.isEsNuevo()).append(" %% ")
                    .append(bus.getModelo()).append(" %% ")
                    .append(bus.getTiposCambios()).append(" %% ")
                    .append(bus.getVelocidadMax()).append(" %% ")
                    .append(bus.getCilindraje()).append(" %% ")
                    .append(bus.getNumPasajeros()).append(" %% ")
                    .append(bus.getNumPuertas()).append(" %% ")
                    .append(bus.getCombustible().getTipoCombustible()).append(" %% ")
                    .append(bus.getImagen()).append(" %% ")
                    .append(bus.getTipoEstado()).append(" %% ")
                    .append(bus.isTieneAcondicionado()).append(" %% ")
                    .append(bus.isTieneCamaraReversa()).append(" %% ")
                    .append(bus.isTieneVelocidadCrucero()).append(" %% ")
                    .append(bus.getNumeroBolsaAire()).append(" %% ")
                    .append(bus.isTieneABS()).append(" %% ")
                    .append(bus.getCapacidadMaletero()).append(" %% ")
                    .append(bus.getNumEjes()).append(" %% ");

            // Guardar los atributos específicos del combustible
            if (bus.getCombustible() instanceof Hibrido) {
                Hibrido hibrido = (Hibrido) bus.getCombustible();
                contenido.append(hibrido.isEsEnchufable()).append(" %% ")
                        .append(hibrido.isEsHibridoLigero()).append(" %% ");
            } else if (bus.getCombustible() instanceof Electrico) {
                Electrico electrico = (Electrico) bus.getCombustible();
                contenido.append(electrico.getAutonomia()).append(" %% ")
                        .append(electrico.getTiempoCarga()).append(" %% ");
            }

            contenido.append("\n"); // Nueva línea para cada bus
        }

        ArchivoUtils.guardarArchivo(rutaBuses, contenido.toString(), false);
    }

    // Método para cargar los Buses
    public static ArrayList<Bus> cargarBuses() throws IOException {
        ArrayList<Bus> listaBuses = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaBuses);

        for (String linea : contenido) {
            String[] partes = linea.split(" %% ");

            if (partes.length < 20) {
                continue; // Verifica que haya suficientes partes
            }

            // Crear una instancia vacía de Buses
            Bus bus = new Bus();

            // Usar métodos set para asignar los valores
            bus.setPlaca(partes[0]);
            bus.setMarca(partes[1]);
            bus.setEsNuevo(Boolean.parseBoolean(partes[2]));
            bus.setModelo(partes[3]);
            bus.setTiposCambios(TipoCambios.valueOf(partes[4]));
            bus.setVelocidadMax(Float.parseFloat(partes[5]));
            bus.setCilindraje(Float.parseFloat(partes[6]));
            bus.setNumPasajeros(Integer.parseInt(partes[7]));
            bus.setNumPuertas(Integer.parseInt(partes[8]));

            // Crear un nuevo objeto Combustible
            String tipoCombustible = partes[9];
            Combustible combustible = null;

            // Determinar el tipo de combustible
            if (tipoCombustible.equals("HIBRIDO")) {
                boolean esEnchufable = Boolean.parseBoolean(partes[19]);
                boolean esHibridoLigero = Boolean.parseBoolean(partes[20]);
                combustible = new Hibrido(TipoCombustible.valueOf(partes[9]), esEnchufable, esHibridoLigero);
            } else if (tipoCombustible.equals("ELECTRICO")) {
                int autonomia = Integer.parseInt(partes[19]);
                int tiempoCarga = Integer.parseInt(partes[20]);
                combustible = new Electrico(TipoCombustible.valueOf(partes[9]), autonomia, tiempoCarga);
            } else if (tipoCombustible.equals("DIESEL")) {
                combustible = new Diesel(TipoCombustible.valueOf(partes[9]));
            } else if (tipoCombustible.equals("GASOLINA")) {
                combustible = new Gasolina(TipoCombustible.valueOf(partes[9]));
            }
            bus.setCombustible(combustible);

            bus.setImagen(partes[10]);
            bus.setTipoEstado(TipoEstado.valueOf(partes[11]));
            bus.setTieneAcondicionado(Boolean.parseBoolean(partes[12]));
            bus.setTieneCamaraReversa(Boolean.parseBoolean(partes[13]));
            bus.setTieneVelocidadCrucero(Boolean.parseBoolean(partes[14]));
            bus.setNumeroBolsaAire(Integer.parseInt(partes[15]));
            bus.setTieneABS(Boolean.parseBoolean(partes[16]));
            bus.setCapacidadMaletero(Float.parseFloat(partes[17]));
            bus.setNumEjes(Integer.parseInt(partes[18]));

            // Agregar el bus a la lista
            listaBuses.add(bus);
        }
        return listaBuses;
    }

    //Metodo para guardar los Camiones
    public static void guardarCamiones(ArrayList<Camion> listaCamiones) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Camion camion : listaCamiones) {
            contenido.append(camion.getPlaca()).append(" %% ")
                    .append(camion.getMarca()).append(" %% ")
                    .append(camion.isEsNuevo()).append(" %% ")
                    .append(camion.getModelo()).append(" %% ")
                    .append(camion.getTiposCambios()).append(" %% ")
                    .append(camion.getVelocidadMax()).append(" %% ")
                    .append(camion.getCilindraje()).append(" %% ")
                    .append(camion.getCombustible().getTipoCombustible()).append(" %% ")
                    .append(camion.getImagen()).append(" %% ")
                    .append(camion.getTipoEstado()).append(" %% ")
                    .append(camion.isTieneAireAcondicionado()).append(" %% ")
                    .append(camion.isTieneFrenosAire()).append(" %% ")
                    .append(camion.isTieneABS()).append(" %% ")
                    .append(camion.getNumeroEjes()).append(" %% ")
                    .append(camion.getTipoCamion()).append(" %% ")
                    .append(camion.getCapCarga()).append(" %% ");

            // Guardar los atributos específicos del combustible
            if (camion.getCombustible() instanceof Hibrido) {
                Hibrido hibrido = (Hibrido) camion.getCombustible();
                contenido.append(hibrido.isEsEnchufable()).append(" %% ")
                        .append(hibrido.isEsHibridoLigero()).append(" %% ");
            } else if (camion.getCombustible() instanceof Electrico) {
                Electrico electrico = (Electrico) camion.getCombustible();
                contenido.append(electrico.getAutonomia()).append(" %% ")
                        .append(electrico.getTiempoCarga()).append(" %% ");
            }

            contenido.append("\n"); // Nueva línea para cada camión
        }

        ArchivoUtils.guardarArchivo(rutaCamiones, contenido.toString(), false);
    }

    // Método para cargar los Camiones
    public static ArrayList<Camion> cargarCamiones() throws IOException {
        ArrayList<Camion> listaCamiones = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaCamiones);

        for (String linea : contenido) {
            String[] partes = linea.split(" %% ");

            if (partes.length < 16) {
                continue; // Verifica que haya suficientes partes
            }

            // Crear una instancia vacía de Camiones
            Camion camion = new Camion();

            // Usar métodos set para asignar los valores
            camion.setPlaca(partes[0]);
            camion.setMarca(partes[1]);
            camion.setEsNuevo(Boolean.parseBoolean(partes[2]));
            camion.setModelo(partes[3]);
            camion.setTiposCambios(TipoCambios.valueOf(partes[4]));
            camion.setVelocidadMax(Float.parseFloat(partes[5]));
            camion.setCilindraje(Float.parseFloat(partes[6]));

            // Crear un nuevo objeto Combustible
            String tipoCombustible = partes[7];
            Combustible combustible = null;

            // Determinar el tipo de combustible
            if (tipoCombustible.equals("HIBRIDO")) {
                boolean esEnchufable = Boolean.parseBoolean(partes[16]);
                boolean esHibridoLigero = Boolean.parseBoolean(partes[17]);
                combustible = new Hibrido(TipoCombustible.valueOf(partes[7]), esEnchufable, esHibridoLigero);
            } else if (tipoCombustible.equals("ELECTRICO")) {
                int autonomia = Integer.parseInt(partes[16]);
                int tiempoCarga = Integer.parseInt(partes[17]);
                combustible = new Electrico(TipoCombustible.valueOf(partes[7]), autonomia, tiempoCarga);
            } else if (tipoCombustible.equals("DIESEL")) {
                combustible = new Diesel(TipoCombustible.valueOf(partes[7]));
            } else if (tipoCombustible.equals("GASOLINA")) {
                combustible = new Gasolina(TipoCombustible.valueOf(partes[7]));
            }
            camion.setCombustible(combustible);

            camion.setImagen(partes[8]);
            camion.setTipoEstado(TipoEstado.valueOf(partes[9]));
            camion.setTieneAireAcondicionado(Boolean.parseBoolean(partes[10]));
            camion.setTieneFrenosAire(Boolean.parseBoolean(partes[11]));
            camion.setTieneABS(Boolean.parseBoolean(partes[12]));
            camion.setNumeroEjes(Integer.parseInt(partes[13]));
            camion.setTipoCamion(TipoCamiones.valueOf(partes[14]));
            camion.setCapCarga(Float.parseFloat(partes[15]));

            // Agregar el camión a la lista
            listaCamiones.add(camion);
        }

        return listaCamiones;
    }

    //Metodo para guardar las ventas
    public static void guardarVentas(ArrayList<Venta> listaVentas) throws IOException {
        StringBuilder contenido = new StringBuilder();

        for (Venta venta : listaVentas) {
            contenido.append(venta.getCodigo()).append(" %% ")
                    .append(venta.getCliente().getCedula()).append(" %% ") // Cedula del cliente
                    .append(venta.getVehiculo().getPlaca()).append(" %% ") // Placa del vehiculo
                    .append(venta.getEmpleado().getCedula()).append(" %% ") // Cedula del empleado
                    .append(venta.getTipoTransaccion().toString()).append(" %% ") // Tipo de transaccion como enum
                    .append(venta.getDescripcion()).append(" %% ")
                    .append(venta.getFechaVenta().toString()) // Fecha de venta en formato de texto
                    .append("\n");
        }

        ArchivoUtils.guardarArchivo(rutaVentas, contenido.toString(), false);
    }

    // Método para cargar las ventas
    public static ArrayList<Venta> cargarVentas(ArrayList<Cliente> clientes, ArrayList<Vehiculo> vehiculos, ArrayList<Empleado> empleados) throws IOException {
        ArrayList<Venta> listaVentas = new ArrayList<>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivos(rutaVentas);

        for (String linea : contenido) {
            String[] partes = linea.split(" %% ");

            if (partes.length < 7) {
                continue; // Si no hay suficientes partes, pasa a la siguiente línea
            }

            // Buscamos al cliente, vehiculo y empleado en las listas dadas
            Cliente cliente = clientes.stream()
                    .filter(c -> c.getCedula().equals(partes[1]))
                    .findFirst()
                    .orElse(null);
            Vehiculo vehiculo = vehiculos.stream()
                    .filter(v -> v.getPlaca().equals(partes[2]))
                    .findFirst()
                    .orElse(null);
            Empleado empleado = empleados.stream()
                    .filter(e -> e.getCedula().equals(partes[3]))
                    .findFirst()
                    .orElse(null);

            // Validamos que cliente, vehiculo y empleado existan antes de crear la Venta
            if (cliente != null && vehiculo != null && empleado != null) {
                Venta venta = new Venta();
                venta.setCodigo(partes[0]); // Código de la venta
                venta.setCliente(cliente); // Cliente de la venta
                venta.setVehiculo(vehiculo); // Vehículo vendido
                venta.setEmpleado(empleado); // Empleado que realizó la venta
                venta.setTipoTransaccion(TipoTransaccion.valueOf(partes[4])); // Tipo de transacción (enum)
                venta.setDescripcion(partes[5]); // Descripción de la venta
                venta.setFechaVenta(LocalDate.parse(partes[6])); // Fecha de la venta

                listaVentas.add(venta);
            }
        }

        return listaVentas;
    }

}
