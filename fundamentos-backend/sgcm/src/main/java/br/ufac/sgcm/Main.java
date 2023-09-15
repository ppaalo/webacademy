package br.ufac.sgcm;

import java.sql.Connection;
import java.util.List;

import br.ufac.sgcm.dao.ConexaoDB;
import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;

public class Main {
    
    public static void main(String[] args) {
        
        Unidade unidade = new Unidade();
        unidade.setId(1L);
        unidade.setNome("Unidade A");
        
        Especialidade especialidade = new Especialidade();

        especialidade.setId(1L);
        especialidade.setNome("Cardiologia");

        Profissional profissional = new Profissional();
        profissional.setId(1L);
        profissional.setNome("Daniel");
        profissional.setEspecialidade(especialidade);
        profissional.setUnidade(unidade);

        System.out.println(profissional.getNome() + " " + profissional.getEspecialidade().getNome() + " " + profissional.getUnidade().getNome());
        
        Connection conexao = ConexaoDB.getConexao();
        if (conexao != null) {
            System.out.println("Conexão Realizado com Sucesso");
        } else {
            System.out.println("Não Deu");
        }

        ProfissionalDao dao = new ProfissionalDao();


        List<Profissional> profissionais = dao.get("Cardio");
        for(Profissional item : profissionais) {
            System.out.println("\n");
            System.out.println(item.getNome());
            System.out.println(item.getEspecialidade().getNome());
            System.out.println(item.getUnidade().getNome());
        }

    }

}
