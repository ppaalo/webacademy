package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;

public class ProfissionalDao implements Idao<Profissional> {

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    private EspecialidadeDao daoEspecialidade;
    private UnidadeDao daoUnidade;

    public ProfissionalDao() {
        conexao = ConexaoDB.getConexao();
        daoEspecialidade = new EspecialidadeDao();
        daoUnidade = new UnidadeDao();
    }

    @Override
    public List<Profissional> get() {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional;";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setRegistroConselho(rs.getString("registro_conselho"));
                Especialidade e = daoEspecialidade.get(rs.getLong("especialidade_id"));
                registro.setEspecialidade(e);
                Unidade u = daoUnidade.get(rs.getLong("unidade_id"));
                registro.setUnidade(u);
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Profissional get(Long id) {
        Profissional registro = new Profissional();
        String sql = "SELECT * FROM profissional WHERE id=?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                registro.setRegistroConselho(rs.getString("registro_conselho"));
                Especialidade e = daoEspecialidade.get(rs.getLong("especialidade_id"));
                registro.setEspecialidade(e);
                Unidade u = daoUnidade.get(rs.getLong("unidade_id"));
                registro.setUnidade(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Profissional> get(String termoBusca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int insert(Profissional objeto) {
        int registroAfetados = 0;
        String sql = "INSERT INTO profissional (nome, registro_conselho, telefone, email, especialidade_id, unidade_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getRegistroConselho());
            ps.setString(3, objeto.getTelefone());
            ps.setString(4, objeto.getEmail());
            ps.setLong(5, objeto.getEspecialidade().getId());
            ps.setLong(6, objeto.getUnidade().getId());
            registroAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registroAfetados;
    }

    @Override
    public int update(Profissional objeto) {
        int registroAfetados = 0;
        String sql = "UPDATE profissional SET nome=?, registro_conselho=?, telefone=?, email=?, especialidade_id=?, unidade_id=? WHERE id=?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getRegistroConselho());
            ps.setString(3, objeto.getTelefone());
            ps.setString(4, objeto.getEmail());
            ps.setLong(5, objeto.getEspecialidade().getId());
            ps.setLong(6, objeto.getUnidade().getId());
            ps.setLong(7, objeto.getId());
            registroAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registroAfetados;
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}