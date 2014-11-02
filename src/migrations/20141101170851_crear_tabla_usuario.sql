CREATE TABLE IF NOT EXISTS "SSE"."usuarios" (
	"id" integer generated always as identity NOT NULL,
	"email" varchar(50) NOT NULL,
	"PASSWORD" varchar(100) NOT NULL,
	"USERNAME" varchar(50) NOT NULL
	,PRIMARY KEY("id")
);