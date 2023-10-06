package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.model.EStatus;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

@Service
public class AtendimentoService implements IService<Atendimento> {

    @Autowired
    private AtendimentoRepository repo;

    @Override
    public List<Atendimento> get() {
        return repo.findAll();
    }

    @Override
    public Atendimento get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Atendimento> get(String termoBusca) {
       return repo.busca(termoBusca);
    }

    @Override
    public Atendimento save(Atendimento objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        Atendimento registro = this.get(id);
        registro.setStatus(EStatus.CANCELADO);
        repo.save(registro);
    }

    public Atendimento updateStatus(Long id) {
        Atendimento registro = this.get(id);
        registro.setStatus(registro.getStatus().proximo());
        repo.save(registro);
        return registro;
    }

    
}
