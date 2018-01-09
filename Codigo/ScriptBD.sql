Create DataBase WarlockSoft;

Use WarlockSoft;

Create Table USUARIO (
	ID_Usuario SmallInt not null Auto_Increment,
	Nombre_Completo VarChar(50) not null,
	Correo VarChar(25) not null,
	Fecha_Nacimineto Date not null,
	Contraseña VarChar(25) not null,
	NickName VarChar(15) not null,
	Primary Key (ID_Usuario)
);
-----------------------------------------------------------------------
Create Table ESTADO (
	ID_Estado SmallInt not null Auto_Increment,
	Texto Text not null,
	ID_Usuario SmallInt not null,
	Primary Key (ID_Estado),
	Foreign Key (ID_Usuario) References USUARIO(ID_Usuario)
);

Create Table COMENTARIO (
	ID_Comentario SmallInt not null Auto_Increment,
	Texto Text not null,
	ID_Estado SmallInt not null,
	ID_Usuario SmallInt not null,
	Primary Key (ID_Comentario),
	Foreign Key (ID_Estado) References ESTADO(ID_Estado),
	Foreign Key (ID_Usuario) References USUARIO(ID_Usuario)
);
-----------------------------------------------------------------------
Create Table CONTACTO (
	ID_Contacto SmallInt not null Auto_Increment,
	NickName_Contacto VarChar(15) not null,
	ID_Usuario SmallInt not null,
	Primary Key (ID_Contacto),
	Foreign Key (ID_Usuario) References USUARIO(ID_Usuario)
);

Create Table MENSAJE (
	ID_Mensaje SmallInt not null Auto_Increment,
	Texto Text not null,
	ID_Contacto SmallInt not null,
	ID_Usuario SmallInt not null,
	Primary Key (ID_Mensaje),
	Foreign Key (ID_Contacto) References CONTACTO(ID_Contacto),
	Foreign Key (ID_Usuario) References USUARIO(ID_Usuario)
);
-----------------------------------------------------------------------
Create Table ASOCIACION (
	ID_Asociacion SmallInt not null Auto_Increment,
	Nombre_Asociacion VarChar(50) not null,
	Objetivo Text not null,
	Logo Blob,
	Primary Key (ID_Asociacion)
);

Create Table ASOCIACION_USUARIO (
	ID_AsociacionUsuario SmallInt not null Auto_Increment,
	Administrador VarChar(15) not null,
	Co_Administrador VarChar(15) null,
	ID_Asociacion SmallInt not null,
	ID_Usuario SmallInt not null,
	Primary Key (ID_AsociacionUsuario),
	Foreign Key (ID_Asociacion) References ASOCIACION (ID_Asociacion),
	Foreign Key (ID_Usuario) References USUARIO(ID_Usuario)
);
-----------------------------------------------------------------------
Create Table HABILIDAD (
	ID_Habilidad SmallInt not null Auto_Increment,
	Nombre_Habilidad VarChar(15) not null,
	Primary Key (Id_Habilidad)
);

Create Table HABILIDAD_USUARIO (
	ID_HabilidadUsuario SmallInt not null Auto_Increment,
	ID_Habilidad SmallInt not null,
	ID_Usuario SmallInt not null,
	Primary Key (ID_HabilidadUsuario),
	Foreign Key (ID_Habilidad) References HABILIDAD(ID_Habilidad),
	Foreign Key (ID_Usuario) References USUARIO(ID_Usuario)
);

Create Table CONOCIMIENTO (
	ID_Conocimiento SmallInt not null Auto_Increment,
	Nombre_Conocimiento VarChar(15) not null,
	ID_Habilidad SmallInt not null,
	Primary Key (ID_Conocimiento),
	Foreign Key (ID_Habilidad) References HABILIDAD(ID_Habilidad)
);

Create Table CONOCIMIENTO_USUARIO (
	ID_ConocimientoUsuario SmallInt not null Auto_Increment,
	Karma Int not null,
	ID_Conocimiento SmallInt not null,
	ID_Usuario SmallInt not null,
	Primary Key (ID_ConocimientoUsuario),
	Foreign Key (ID_Conocimiento) References CONOCIMIENTO(ID_Conocimiento),
	Foreign Key (ID_Usuario) References USUARIO(ID_Usuario)
);
-----------------------------------------------------------------------
Create Table PROYECTO (
	ID_Proyecto SmallInt not null Auto_Increment,
	Nombre_Proyecto VarChar(50) not null,
	Fecha_Inicio Date not null,
	Fecha_Fin Date not null,
	Estado VarChar(15) not null,
	Primary Key (ID_Proyecto)
);

Create Table PROYECTO_USUARIO (
	ID_ProyectoUsuario SmallInt not null Auto_Increment,
	Rol VarChar(15) not null,
	ID_Proyecto SmallInt not null,
	ID_Usuario SmallInt not null,
	Primary Key (ID_ProyectoUsuario),
	Foreign Key (ID_Proyecto) References PROYECTO(ID_Proyecto),
	Foreign Key (ID_Usuario) References USUARIO (ID_Usuario)
);

Create Table TAREA (
	ID_Tarea SmallInt not null Auto_Increment,
	Nombre_Tarea VarChar(15) not null,
	Descripcion Text not null,
	Fecha_Inicio Date not null,
	Estado VarChar(15) not null,
	ID_Proyecto SmallInt not null,
	ID_Conocimiento SmallInt not null,
	Primary Key (ID_Tarea),
	Foreign Key (ID_Proyecto) References PROYECTO(ID_Proyecto),
	Foreign Key (ID_Conocimiento) References CONOCIMIENTO(ID_Conocimiento)
);

Create Table TAREA_USUARIO (
	ID_TareaUsuario SmallInt not null Auto_Increment,
	ID_Usuario SmallInt not null,
	ID_Tarea SmallInt not null,
	Primary Key (ID_TareaUsuario),
	Foreign Key (ID_Usuario) References USUARIO(ID_Usuario),
	Foreign Key (ID_Tarea) References TAREA(ID_Tarea)
);
----------------------------------------------------------------------------
Create Table DENUNCIA (
	ID_Denuncia SmallInt not null Auto_Increment,
	Elemento VarChar(25) not null,
	Nombre_Elemento VarChar(50) not null,
	Motivo VarChar(200) not null,
	Denunciante SmallInt not null,
	Primary Key (ID_Denuncia),
	Foreign Key (Denunciante) References USUARIO(ID_Usuario)
);