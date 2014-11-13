CREATE TABLE IF NOT EXISTS "SSE"."usuarios" (
	"id" integer generated always as identity NOT NULL,
	"email" varchar(50) NOT NULL,
	"password" varchar(100) NOT NULL,
	PRIMARY KEY("id")
);

CREATE TABLE IF NOT EXISTS "SSE"."alumnos" (

	"id" integer generated always as identity NOT NULL,
	"nombres" varchar(50) NOT NULL,
	"apellidos" varchar(50) NOT NULL,
        "fecha_nacimiento" date NOT NULL,
        "dni" varchar(8) NOT NULL,
        "genero" varchar(10) NOT NULL, --tabla externa?
	"estado_civil"
        "nacionalidad" varchar(20) NOT NULL, -- falta en vista
        "direccion" varchar(100) NOT NULL,
        "distrito"
        "telefono_fijo"
        "telefono_movil"
        "universidad"
        "facultad" varchar(50) NOT NULL,
        "especialidad" varchar(50) NOT NULL,
	"anio_egreso" varchar(4) NOT NULL,
        "facebook"
        "linkedin"  
        "twitter"
        
	"cv_url" varchar(50) NOT NULL,
	"foto_url" varchar(50) NOT NULL,

	"id_usuario" integer NOT NULL,
	,PRIMARY KEY(ID)
);

ALTER TABLE "SSE"."alumnos" ADD FOREIGN KEY (id_usuario) REFERENCES "SSE"."usuarios"(id);