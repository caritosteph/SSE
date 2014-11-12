CREATE TABLE IF NOT EXISTS "SSE"."usuarios" (
	"id" integer generated always as identity NOT NULL,
	"email" varchar(50) NOT NULL,
	"password" varchar(100) NOT NULL,
	"nombres" varchar(50) NOT NULL,
        "apellidos" varchar(50) NOT NULL,
	PRIMARY KEY("id")
);