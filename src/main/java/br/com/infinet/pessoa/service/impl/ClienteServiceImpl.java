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

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void incluir(Cliente cliente) {

        atualizarEndereco(cliente);

        clienteRepository.save(cliente);
    }

    @Override
    public void alterar(Long id, Cliente cliente) {

        Cliente clienteSalvo = clienteRepository.findById(id).orElse(null);

        BeanUtils.copyProperties(cliente, clienteSalvo, "id");

        atualizarEndereco(clienteSalvo);

        clienteRepository.save(clienteSalvo);
    }

    @Override
    public Cliente atualizarEndereco(Cliente cliente) {

        if (!Objects.isNull(cliente.getCep())) {

            if (cliente.getCep().trim().length() > 0) {

                Cep cep = retornarDadosCep(cliente.getCep());

                if (!Objects.isNull(cep)) {
                    cliente.setEndereco(cep.getLogradouro());
                    cliente.setBairro(cep.getBairro());
                    cliente.setCidade(cep.getLocalidade());
                    cliente.setEstado(cep.getUf());
                }
            }
        }
        return cliente;
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

        return restTemplate.getForObject(url, Cep.class);
    }

}
