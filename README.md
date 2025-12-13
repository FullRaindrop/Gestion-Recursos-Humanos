Sistema de Gestión de Recursos Humanos (RRHH)

Visión General del Proyecto

Este proyecto es una implementación de software para la gestión integral de los procesos clave de Recursos Humanos de una organización. El sistema está diseñado para manejar la información de usuarios, empleados, contratos, nóminas y control de tiempo (vacaciones y ausencias), asegurando la eficiencia y la centralización de los datos.

    Funcionalidades Principales

El sistema aborda los siguientes procesos, definidos a través de nuestras clases de dominio:

Gestión de Usuarios y Accesos (UsuarioSistema, Administrador, Rol):

Maneja la autenticación segura de los usuarios.

Permite a los administradores crear y gestionar cuentas de otros empleados y administradores.

Define roles y permisos para controlar el acceso a las distintas funcionalidades del sistema.

Control de Contratos y Puestos (Empleado, Contrato, Puesto):

Registra información detallada de cada empleado, incluyendo su asignación a un Departamento y a un Puesto específico.

Formaliza la relación laboral a través de un Contrato que define el tipo de relación (Temporal, Indefinido, etc.) y el Salario Base.

Procesamiento de Nómina (Nomina, Deduccion):

Calcula el salario neto mensual de los empleados.

Aplica las Deducciones legales y corporativas (como ISR, Seguridad Social, etc.) sobre el salario bruto.

Control de Tiempo y Asistencia (SolicitudVacacion, Ausencia):

Gestiona el saldo de días de vacaciones de cada empleado (BalanceVacaciones).

Permite a los empleados solicitar vacaciones y a los superiores o RRHH aprobarlas/rechazarlas.

Registra cualquier otra Ausencia (por enfermedad, permiso personal) con la posibilidad de justificación.

Evaluación de Desempeño (Evaluacion):

Permite registrar periódicamente la calificación y comentarios sobre el desempeño de un empleado.

Reportes y Análisis (Reporte):

Genera informes consolidados a partir de los datos del sistema (ej. reportes de nómina, balances de vacaciones pendientes).

    Estructura del Código

El código está organizado en paquetes siguiendo una arquitectura modular y limpia, diseñada para la escalabilidad.

utp.Ac.Pa.sistema: Contenedor principal de la aplicación.

App.java: Contiene el método main y sirve como el punto de entrada y demostración de la lógica del sistema.

utils: Clases de utilidades (ej. manejo de I/O, formato de datos).

domain: El núcleo del negocio. Aquí residen todas las clases de entidad (Empleado, Nomina, Contrato, etc.) y las enumeraciones (Rol, TipoContrato).

    Tecnologías

Lenguaje: Java

Gestión de Dependencias: Estructura de paquetes estándar de Java.

Fecha/Hora: Uso de la API java.time para manejo de fechas.