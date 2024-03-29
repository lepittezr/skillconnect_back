-- Criação Database
CREATE DATABASE skillconnect

-- Tabela de Usuários
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role SMALLINT NOT NULL
);

-- Tabela de Skills
CREATE TABLE skills (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT
);

-- Definição do tipo ENUM para o nível das habilidades do usuário
CREATE TYPE skill_level_enum AS ENUM ('BASIC', 'INTERMEDIATE', 'ADVANCED');

-- Tabela associativa entre usuários e habilidades (com os relacionamentos)
CREATE TABLE user_skills (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    skill_id INTEGER NOT NULL,
    level skill_level_enum NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (skill_id) REFERENCES skills (id) ON DELETE CASCADE
);

-- Criação da sequence para a tabela users
CREATE SEQUENCE users_id_seq START 1;

-- Criação da sequence para a tabela skills
CREATE SEQUENCE skills_id_seq START 1;

-- Criação da sequence para a tabela user_skill
CREATE SEQUENCE user_skills_id_seq START 1;
