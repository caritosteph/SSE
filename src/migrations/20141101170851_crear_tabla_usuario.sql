CREATE TABLE IF NOT EXISTS "SSE"."usuarios" (
	"id" integer generated always as identity NOT NULL,
	"email" varchar(50) NOT NULL,
	"password" varchar(100) NOT NULL,
        "nombres" varchar(50) NOT NULL,
	"apellidos" varchar(50) NOT NULL,
	PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "SSE"."alumnos" (

	"id" integer generated always as identity NOT NULL,
	"nombres" varchar(50),
	"apellidos" varchar(50),
        "fecha_nacimiento" date,
        "dni" varchar(8),
        "nacionalidad" varchar(20), 
        "direccion" varchar(100),
        "distrito" varchar(50),
        "telefono_fijo" varchar(10),
        "telefono_movil" varchar(10),
        "universidad" varchar(50),
        "facultad" varchar(50),
        "especialidad" varchar(50),
	"anio_egreso" varchar(4),
        "facebook" varchar(20),
        "linkedin" varchar(20),
        "twitter" varchar(20),
	"cv_url" varchar(50),
	"foto_url" varchar(50),
	"usuario_id" integer,
        "trabajo_id" integer,
        "estado_civil" varchar(50),
        "genero" varchar(50), 
	PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS "SSE"."trabajos" (
	"id" integer generated always as identity NOT NULL,
	"nombre_empresa" varchar(50),
        "fecha_inicio" date,
        "fecha_fin" date,
        "actual" boolean,
        "direccion_empresa" varchar(8),
        "titulo_puesto" varchar(20), 
        "descripcion_puesto" varchar(100),
	PRIMARY KEY(ID)
);

