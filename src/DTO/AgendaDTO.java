
package DTO;


public class AgendaDTO {
    private String nome, sobrenome;
    private int id_agenda;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the id_agenda
     */
    public int getId_agenda() {
        return id_agenda;
    }

    /**
     * @param id_agenda the id_agenda to set
     */
    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }
    
}
