package br.ufac.sgcm;

import br.ufac.sgcm.dao.ConexaoDB;
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
        
        ConexaoDB conexao = new ConexaoDB();
        if (conexao.getConexao() != null) {
            System.out.println("Conexão Realizado com Sucesso");
        } else {
            System.out.println("Não Deu");
        }

    }

}
