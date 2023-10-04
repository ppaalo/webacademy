package br.ufac.sgcm.controller;

import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfissionalController implements IController<Profissional> {

    private ProfissionalDao dao;

    public ProfissionalController() {
        dao = new ProfissionalDao();
    }

    @Override
    public List<Profissional> get() {
        return dao.get();
    }

    @Override
    public Profissional get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int save(Profissional objeto) {
        int registrosAfetados = 0;
        if (objeto.getId() != null) {
            registrosAfetados = dao.update(objeto);
        } else {
            registrosAfetados = dao.insert(objeto);
        }
        return registrosAfetados;
    }

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

    @Override
    public List<Profissional> processListRequest(HttpServletRequest request) {

        String paramExcluir = request.getParameter("excluir");
        if (paramExcluir != null && !paramExcluir.isEmpty()) {
            Long id = Long.parseLong(paramExcluir);
            this.delete(id);
        }

        List<Profissional> registros = new ArrayList<>();
        registros = this.get();
        return registros;

    }

    @Override
    public Profissional processFormRequest(HttpServletRequest request, HttpServletResponse response) {
        
        String submit = request.getParameter("submit");
        if (submit != null) {
            Profissional item = new Profissional();
            item.setNome(request.getParameter("nome"));
            item.setRegistroConselho(request.getParameter("registroConselho"));
            item.setTelefone(request.getParameter("telefone"));
            item.setEmail(request.getParameter("email"));

            Especialidade especialidade = new Especialidade();
            Long especialidadeId = Long.parseLong(request.getParameter("especialidade"));
            especialidade.setId(especialidadeId);

            Unidade unidade = new Unidade();
            Long unidadeId = Long.parseLong(request.getParameter("unidade"));
            unidade.setId(unidadeId);
            this.save(item);
        }
        return new Profissional();
    }
    
}
