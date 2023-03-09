package DAO;

import DTO.AgendaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AgendaDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<AgendaDTO> lista = new ArrayList<>();

    public void cadastrarAgenda(AgendaDTO objagendadto) {
        String sql = "insert into contatos (nome, sobrenome) values (?, ?)";

        conn = new ConexaoDAO().conectaBD();

        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objagendadto.getNome());
            pstm.setString(2, objagendadto.getSobrenome());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "AgendaDAO Cadastrar" + erro);
        }

    }

    public ArrayList<AgendaDTO> PesquisarAgenda() {
        String sql = "select * from contatos";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                AgendaDTO objagendaDTO = new AgendaDTO();
                objagendaDTO.setId_agenda(rs.getInt("id"));
                objagendaDTO.setNome(rs.getString("nome"));
                objagendaDTO.setSobrenome(rs.getString("sobrenome"));

                lista.add(objagendaDTO);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "AgendaDAO Pesquisar" + erro);
        }
        return lista;
    }
    
    public void alterarAgenda(AgendaDTO objagenda){
        String sql = "update contatos set nome = ?, sobrenome = ? where id = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objagenda.getNome());
            pstm.setString(2,objagenda.getSobrenome());
            pstm.setInt(3,objagenda.getId_agenda());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Agenda Alterar" + erro);
        }
    }
    
    public void excluirFuncionario(AgendaDTO objagenda) {
        String sql = "delete from contatos where id = ?";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1,objagenda.getId_agenda());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Agenda Excluir" + erro);
        }
    }
    
}
