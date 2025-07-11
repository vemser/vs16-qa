package com.vemser.rest.data.factory;

import com.vemser.rest.model.Usuarios;
import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class UsuariosDataFactory {

    private static Faker faker = new Faker(new Locale("PT-BR"));
    private static Random geradorBoolean = new Random();

    private UsuariosDataFactory() {}

    public static Usuarios usuarioValido() {
        return novoUsuario();
    }

    public static Usuarios usuarioAdmin() {
        Usuarios usuarioAdmin = novoUsuario();
        usuarioAdmin.setAdministrador("true");

        return usuarioAdmin;
    }

    public static Usuarios usuarioComNomeEmBranco() {
        Usuarios usuario = novoUsuario();
        usuario.setNome("");

        return usuario;
    }

    private static Usuarios novoUsuario() {
        Usuarios usuario = new Usuarios();
        usuario.setNome(faker.name().firstName() + " " + faker.name().lastName());
        usuario.setEmail(faker.internet().emailAddress());
        usuario.setPassword(faker.internet().password());
        usuario.setAdministrador(String.valueOf(geradorBoolean.nextBoolean()));

        return usuario;
    }


}
