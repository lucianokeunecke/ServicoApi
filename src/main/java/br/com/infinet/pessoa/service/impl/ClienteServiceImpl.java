package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.model.Cep;
import br.com.infinet.pessoa.model.Cliente;
import br.com.infinet.pessoa.model.Fabricante;
import br.com.infinet.pessoa.repository.ClienteRepository;
import br.com.infinet.pessoa.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteServiceImpl implements ClienteService {

    //private String url = "http://localhost:8081/cep/";

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void incluir(Cliente cliente) {

        clienteRepository.save(cliente);
    }

    @Override
    public void alterar(Long id, Cliente cliente) {

        Cliente clienteSalvo = clienteRepository.findById(id).orElse(null);

        BeanUtils.copyProperties(cliente, clienteSalvo, "id");

        if (clienteSalvo.getCep().trim().length() > 0) {

            Cep cep = retornarDadosCep(clienteSalvo.getCep());

            if (!Objects.isNull(cep)) {
                clienteSalvo.setEndereco(cep.getLogradouro());
                clienteSalvo.setBairro(cep.getBairro());
            }
        }

        clienteRepository.save(clienteSalvo);
    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> buscarPeloId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cep retornarDadosCep(String numeroCep) {

        String url = String.format("http://localhost:8081/cep/%s",numeroCep);

        Cep cep = restTemplate.getForObject(url, Cep.class);

        return cep;
    }

}
