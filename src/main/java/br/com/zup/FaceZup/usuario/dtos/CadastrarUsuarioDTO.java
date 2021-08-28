package br.com.zup.FaceZup.usuario.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastrarUsuarioDTO {

    @Size(min = 2, max = 20, message = "{validation.usuario.nome}")
    private String nome;
    @Size(min = 5, max = 20, message = "{validation.usuario.sobrenome}")
    private String sobrenome;
    @Email(message = "{validation.usuario.email}")
    private String email;
    @NotBlank(message = "{validation.usuario.cargo}")
    private String cargo;

    public CadastrarUsuarioDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
